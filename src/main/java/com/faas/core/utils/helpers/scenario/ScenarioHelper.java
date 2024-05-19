package com.faas.core.utils.helpers.scenario;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationScenarioDAO;
import com.faas.core.base.model.db.operation.content.dao.OperationScenarioDataDAO;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
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


    public OperationScenarioDAO executeOperationScenarioHelper(OperationDBModel operationDBModel, ProcessScenarioDBModel processScenarioDBModel) {

        OperationScenarioDAO operationScenarioDAO = new OperationScenarioDAO();
        operationScenarioDAO.setId(appUtils.generateUUID());
        operationScenarioDAO.setScenarioId(processScenarioDBModel.getScenarioId());
        operationScenarioDAO.setScenario(processScenarioDBModel.getScenario());
        operationScenarioDAO.setScenarioDesc(processScenarioDBModel.getScenarioDesc());
        operationScenarioDAO.setTypeId(processScenarioDBModel.getTypeId());
        operationScenarioDAO.setScenarioType(processScenarioDBModel.getScenarioType());
        operationScenarioDAO.setBaseType(processScenarioDBModel.getBaseType());

        List<OperationScenarioDataDAO> operationScenarioDatas = new ArrayList<>();
        if (processScenarioDBModel.getScenarioDatas() != null){
            for (int i=0;i<processScenarioDBModel.getScenarioDatas().size();i++){
                operationScenarioDatas.add(convert2OperationScenarioData(processScenarioDBModel.getScenarioDatas().get(i)));
            }
        }
        operationScenarioDAO.setScenarioDatas(operationScenarioDatas);
        operationScenarioDAO.setScenarioResults(new ArrayList<>());
        operationScenarioDAO.setScenarioState(AppConstant.NEW_STATE);
        operationScenarioDAO.setuDate(appUtils.getCurrentTimeStamp());
        operationScenarioDAO.setcDate(appUtils.getCurrentTimeStamp());
        operationScenarioDAO.setStatus(1);

        if (operationDBModel.getOperationScenarios() != null){
            operationDBModel.getOperationScenarios().add(operationScenarioDAO);
        }else {
            List<OperationScenarioDAO> operationScenarioDAOS = new ArrayList<>();
            operationScenarioDAOS.add(operationScenarioDAO);
            operationDBModel.setOperationScenarios(operationScenarioDAOS);
        }
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
