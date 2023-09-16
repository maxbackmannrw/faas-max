package com.faas.core.base.middleware.process.details.scenario;

import com.faas.core.base.framework.process.details.scenario.ProcessScenarioFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioDataWSModel;
import com.faas.core.base.model.ws.process.details.scenario.ProcessScenarioWSModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioDataWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessScenarioMiddleware {

    @Autowired
    ProcessScenarioFramework processScenarioFramework;


    public ProcessScenarioWSModel getProcessScenarios(long userId, String processId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = processScenarioFramework.getProcessScenariosService(processId);
        if (processScenarioWSDTOS != null){
            response.setProcessScenarios(processScenarioWSDTOS);
        }

        general.setOperation("getProcessScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioWSModel getProcessScenario(long userId,String processId,String scenarioId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ProcessScenarioWSDTO processScenarioWSDTO = processScenarioFramework.getProcessScenarioService(processId,scenarioId);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("getProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioWSModel createProcessScenario(long userId,String processId,String scenarioId,int scenarioOrder) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ProcessScenarioWSDTO processScenarioWSDTO = processScenarioFramework.createProcessScenarioService(processId,scenarioId,scenarioOrder);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("getProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioWSModel removeProcessScenario(long userId,String processId,String scenarioId) {

        ProcessScenarioWSModel response = new ProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ProcessScenarioWSDTO processScenarioWSDTO = processScenarioFramework.removeProcessScenarioService(processId,scenarioId);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("getProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ProcessScenarioDataWSModel getProcessScenarioDatas(long userId, String processId, String scenarioId) {

        ProcessScenarioDataWSModel response = new ProcessScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = processScenarioFramework.getProcessScenarioDatasService(processId,scenarioId);
        if (scenarioDataWSDTOS != null){
            response.setScenarioDatas(scenarioDataWSDTOS);
        }

        general.setOperation("getProcessScenarioDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioDataWSModel getProcessScenarioData(long userId, String processId, String scenarioId, String dataId) {

        ProcessScenarioDataWSModel response = new ProcessScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = processScenarioFramework.getProcessScenarioDataService(processId,scenarioId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("getProcessScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioDataWSModel createProcessScenarioData(long userId, String processId, String scenarioId, long typeId, String value) {

        ProcessScenarioDataWSModel response = new ProcessScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = processScenarioFramework.createProcessScenarioDataService(processId,scenarioId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("createProcessScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioDataWSModel updateProcessScenarioData(long userId, String processId, String scenarioId, String dataId, long typeId, String value) {

        ProcessScenarioDataWSModel response = new ProcessScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = processScenarioFramework.updateProcessScenarioDataService(processId,scenarioId,dataId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("updateProcessScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessScenarioDataWSModel removeProcessScenarioData(long userId, String processId, String scenarioId, String dataId) {

        ProcessScenarioDataWSModel response = new ProcessScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = processScenarioFramework.removeProcessScenarioDataService(processId,scenarioId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("removeProcessScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
