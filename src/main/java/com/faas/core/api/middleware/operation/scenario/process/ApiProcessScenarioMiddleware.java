package com.faas.core.api.middleware.operation.scenario.process;

import com.faas.core.api.framework.operation.scenario.process.ApiProcessScenarioFramework;
import com.faas.core.api.model.ws.operation.scenario.process.ApiProcessScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.process.ApiScenarioElementWSModel;
import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiProcessScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.process.dto.ApiScenarioElementWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiProcessScenarioMiddleware {


    @Autowired
    ApiProcessScenarioFramework apiProcessScenarioFramework;


    public ApiProcessScenarioWSModel apiGetProcessScenarios(long agentId, long sessionId, String processId) {

        ApiProcessScenarioWSModel response = new ApiProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiProcessScenarioWSDTO> scenarioWSDTOS = apiProcessScenarioFramework.apiGetProcessScenariosService(agentId,sessionId,processId);
        if (scenarioWSDTOS != null){
            response.setProcessScenarios(scenarioWSDTOS);
        }

        general.setOperation("apiGetProcessScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiProcessScenarioWSModel apiGetProcessScenario(long agentId, long sessionId, String processId, String scenarioId) {

        ApiProcessScenarioWSModel response = new ApiProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessScenarioWSDTO>scenarioWSDTOS = new ArrayList<>();

        ApiProcessScenarioWSDTO scenarioWSDTO = apiProcessScenarioFramework.apiGetProcessScenarioService(agentId,sessionId,processId,scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setProcessScenarios(scenarioWSDTOS);
        general.setOperation("apiGetProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiScenarioElementWSModel apiGetProcessScenarioElements(long agentId, long sessionId, String scenarioId) {

        ApiScenarioElementWSModel response = new ApiScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiScenarioElementWSDTO> scenarioElementWSDTOS = apiProcessScenarioFramework.apiGetProcessScenarioElementsService(agentId,sessionId,scenarioId);
        if (scenarioElementWSDTOS != null){
            response.setScenarioElements(scenarioElementWSDTOS);
        }

        general.setOperation("apiGetProcessScenarioElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiScenarioElementWSModel apiGetProcessScenarioElement(long agentId,long sessionId, String scenarioId,String elementId) {

        ApiScenarioElementWSModel response = new ApiScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ApiScenarioElementWSDTO scenarioElementWSDTO = apiProcessScenarioFramework.apiGetProcessScenarioElementService(agentId,sessionId,scenarioId,elementId);
        if (scenarioElementWSDTO != null){
            scenarioElementWSDTOS.add(scenarioElementWSDTO);
        }

        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("apiGetProcessScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
