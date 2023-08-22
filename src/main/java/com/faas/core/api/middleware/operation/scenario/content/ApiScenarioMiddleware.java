package com.faas.core.api.middleware.operation.scenario.content;

import com.faas.core.api.framework.operation.scenario.content.ApiScenarioFramework;
import com.faas.core.api.model.ws.operation.scenario.content.*;
import com.faas.core.api.model.ws.operation.scenario.content.dto.*;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiScenarioMiddleware {


    @Autowired
    ApiScenarioFramework apiScenarioFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId,long sessionId,String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationScenarioWSDTO operationScenarioWSDTO = apiScenarioFramework.apiGetOperationScenarioService(agentId,sessionId,processId);
        if (operationScenarioWSDTO != null){
            response.setOperationScenario(operationScenarioWSDTO);
        }

        general.setOperation("apiGetOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenarios(long agentId,long sessionId, String processId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioWSDTO> scenarioWSDTOS = apiScenarioFramework.apiGetScenariosService(agentId,sessionId,processId);
        if (scenarioWSDTOS != null){
            response.setScenarios(scenarioWSDTOS);
        }

        general.setOperation("apiGetScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioWSModel apiGetScenario(long agentId,long sessionId,String processId,String scenarioId) {

        ApiScenarioWSModel response = new ApiScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

        ApiScenarioWSDTO scenarioWSDTO = apiScenarioFramework.apiGetScenarioService(agentId,sessionId,processId,scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("apiGetScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioDetailsWSModel apiGetScenarioDetails(long agentId, long sessionId, String processId, String scenarioId) {

        ApiScenarioDetailsWSModel response = new ApiScenarioDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiScenarioDetailsWSDTO scenarioDetailsWSDTO = apiScenarioFramework.apiGetScenarioDetailsService(agentId,sessionId,processId,scenarioId);
        if (scenarioDetailsWSDTO != null){
            response.setScenarioDetails(scenarioDetailsWSDTO);
        }

        general.setOperation("apiGetScenarioDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioElementWSModel apiGetScenarioElements(long agentId,long sessionId,String scenarioId) {

        ApiScenarioElementWSModel response = new ApiScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioElementWSDTO> scenarioElementWSDTOS = apiScenarioFramework.apiGetScenarioElementsService(agentId,sessionId,scenarioId);
        if (scenarioElementWSDTOS != null){
            response.setScenarioElements(scenarioElementWSDTOS);
        }

        general.setOperation("apiGetScenarioElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioElementWSModel apiGetScenarioElement(long agentId,long sessionId, String scenarioId,String elementId) {

        ApiScenarioElementWSModel response = new ApiScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ApiScenarioElementWSDTO scenarioElementWSDTO = apiScenarioFramework.apiGetScenarioElementService(agentId,sessionId,scenarioId,elementId);
        if (scenarioElementWSDTO != null){
            scenarioElementWSDTOS.add(scenarioElementWSDTO);
        }

        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("apiGetScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
