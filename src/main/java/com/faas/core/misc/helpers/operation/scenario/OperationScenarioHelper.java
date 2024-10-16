package com.faas.core.misc.helpers.operation.scenario;

import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.scenario.OperationScenarioDBModel;
import com.faas.core.data.db.operation.details.scenario.dao.OperationScenarioDataDAO;
import com.faas.core.data.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationScenarioHelper {


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public OperationScenarioDBModel runOperationScenarioHelper(OperationDBModel operationDBModel, CampaignScenarioDBModel campaignScenarioDBModel) {

        OperationScenarioDBModel operationScenarioDBModel = new OperationScenarioDBModel();
        operationScenarioDBModel.setId(appUtils.generateUUID());
        operationScenarioDBModel.setScenarioId(campaignScenarioDBModel.getScenarioId());
        operationScenarioDBModel.setScenario(campaignScenarioDBModel.getScenario());
        operationScenarioDBModel.setScenarioDesc(campaignScenarioDBModel.getScenarioDesc());
        operationScenarioDBModel.setScenarioTypeId(campaignScenarioDBModel.getTypeId());
        operationScenarioDBModel.setScenarioType(campaignScenarioDBModel.getScenarioType());
        operationScenarioDBModel.setBaseType(campaignScenarioDBModel.getBaseType());

        List<OperationScenarioDataDAO> operationScenarioDatas = new ArrayList<>();
        if (campaignScenarioDBModel.getScenarioDatas() != null) {
            for (int i = 0; i < campaignScenarioDBModel.getScenarioDatas().size(); i++) {
                operationScenarioDatas.add(convert2OperationScenarioData(campaignScenarioDBModel.getScenarioDatas().get(i)));
            }
        }
        operationScenarioDBModel.setScenarioDatas(operationScenarioDatas);
        operationScenarioDBModel.setRunResults(new ArrayList<>());
        operationScenarioDBModel.setRunState(AppConstant.READY_STATE);
        operationScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationScenarioDBModel.setStatus(1);

        return operationScenarioRepository.save(operationScenarioDBModel);
    }


    public OperationScenarioDataDAO convert2OperationScenarioData(ScenarioDataDAO scenarioDataDAO) {

        OperationScenarioDataDAO operationScenarioDataDAO = new OperationScenarioDataDAO();
        operationScenarioDataDAO.setDataId(scenarioDataDAO.getDataId());
        operationScenarioDataDAO.setDataType(scenarioDataDAO.getDataType());
        operationScenarioDataDAO.setValue(scenarioDataDAO.getValue());
        operationScenarioDataDAO.setcDate(scenarioDataDAO.getcDate());
        operationScenarioDataDAO.setStatus(scenarioDataDAO.getStatus());

        return operationScenarioDataDAO;
    }


}
