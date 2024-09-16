package com.faas.core.misc.helpers.scenario;

import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.content.dao.OperationScenarioDAO;
import com.faas.core.data.db.operation.content.dao.OperationScenarioDataDAO;
import com.faas.core.data.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScenarioHelper {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public OperationScenarioDAO executeOperationScenarioHelper(OperationDBModel operationDBModel, CampaignScenarioDBModel campaignScenarioDBModel) {

        OperationScenarioDAO operationScenarioDAO = new OperationScenarioDAO();
        operationScenarioDAO.setId(appUtils.generateUUID());
        operationScenarioDAO.setScenarioId(campaignScenarioDBModel.getScenarioId());
        operationScenarioDAO.setScenario(campaignScenarioDBModel.getScenario());
        operationScenarioDAO.setScenarioDesc(campaignScenarioDBModel.getScenarioDesc());
        operationScenarioDAO.setTypeId(campaignScenarioDBModel.getTypeId());
        operationScenarioDAO.setScenarioType(campaignScenarioDBModel.getScenarioType());
        operationScenarioDAO.setBaseType(campaignScenarioDBModel.getBaseType());

        List<OperationScenarioDataDAO> operationScenarioDatas = new ArrayList<>();
        if (campaignScenarioDBModel.getScenarioDatas() != null) {
            for (int i = 0; i < campaignScenarioDBModel.getScenarioDatas().size(); i++) {
                operationScenarioDatas.add(convert2OperationScenarioData(campaignScenarioDBModel.getScenarioDatas().get(i)));
            }
        }
        operationScenarioDAO.setScenarioDatas(operationScenarioDatas);
        operationScenarioDAO.setScenarioResults(new ArrayList<>());
        operationScenarioDAO.setScenarioState(AppConstant.READY_STATE);
        operationScenarioDAO.setuDate(appUtils.getCurrentTimeStamp());
        operationScenarioDAO.setcDate(appUtils.getCurrentTimeStamp());
        operationScenarioDAO.setStatus(1);


        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationRepository.save(operationDBModel);

        return operationScenarioDAO;
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
