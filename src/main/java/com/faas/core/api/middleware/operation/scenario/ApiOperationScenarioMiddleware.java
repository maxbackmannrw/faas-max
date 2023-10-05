package com.faas.core.api.middleware.operation.scenario;

import com.faas.core.api.framework.operation.scenario.ApiOperationScenarioFramework;
import com.faas.core.api.model.ws.operation.scenario.content.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiOperationScenarioWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.ApiProcessScenarioElementWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.ApiProcessScenarioWSModel;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiProcessScenarioElementWSDTO;
import com.faas.core.api.model.ws.operation.scenario.content.dto.ApiProcessScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationScenarioMiddleware {


    @Autowired
    ApiOperationScenarioFramework apiOperationScenarioFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenarios(long agentId, long sessionId, String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = apiOperationScenarioFramework.apiGetOperationScenariosService(agentId,sessionId,processId);
        if (operationScenarioWSDTOS != null){
            response.setOperationScenarios(operationScenarioWSDTOS);
        }

        general.setOperation("apiGetOperationScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiGetOperationScenario(long agentId, long sessionId, String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO =  apiOperationScenarioFramework.apiGetOperationScenarioService(agentId,sessionId,executeId);
        if (operationScenarioWSDTO != null){
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }

        response.setOperationScenarios(operationScenarioWSDTOS);
        general.setOperation("apiGetOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiExecuteOperationScenario(long agentId, long sessionId, String processId, String scenarioId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO =  apiOperationScenarioFramework.apiExecuteOperationScenarioService(agentId,sessionId,processId,scenarioId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setOperationScenarios(scenarioExecutionWSDTOS);
        general.setOperation("apiExecuteOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiUpdateOperationScenario(long agentId, long sessionId,String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>scenarioExecutionWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO scenarioExecutionWSDTO =  apiOperationScenarioFramework.apiUpdateOperationScenarioService(agentId,sessionId,executeId);
        if (scenarioExecutionWSDTO != null){
            scenarioExecutionWSDTOS.add(scenarioExecutionWSDTO);
        }

        response.setOperationScenarios(scenarioExecutionWSDTOS);
        general.setOperation("apiUpdateOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationScenarioWSModel apiRemoveOperationScenario(long agentId,long sessionId, String executeId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationScenarioWSDTO>operationScenarioWSDTOS = new ArrayList<>();

        ApiOperationScenarioWSDTO operationScenarioWSDTO =  apiOperationScenarioFramework.apiRemoveOperationScenarioService(agentId,sessionId,executeId);
        if (operationScenarioWSDTO != null){
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }

        response.setOperationScenarios(operationScenarioWSDTOS);
        general.setOperation("apiRemoveOperationScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiProcessScenarioWSModel apiGetProcessScenarios(long agentId, long sessionId, String processId) {

        ApiProcessScenarioWSModel response = new ApiProcessScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiProcessScenarioWSDTO> processScenarioWSDTOS = apiOperationScenarioFramework.apiGetProcessScenariosService(agentId,sessionId,processId);
        if (processScenarioWSDTOS != null){
            response.setProcessScenarios(processScenarioWSDTOS);
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
        List<ApiProcessScenarioWSDTO>processScenarioWSDTOS = new ArrayList<>();

        ApiProcessScenarioWSDTO processScenarioWSDTO = apiOperationScenarioFramework.apiGetProcessScenarioService(agentId,sessionId,processId,scenarioId);
        if (processScenarioWSDTO != null){
            processScenarioWSDTOS.add(processScenarioWSDTO);
        }

        response.setProcessScenarios(processScenarioWSDTOS);
        general.setOperation("apiGetProcessScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiProcessScenarioElementWSModel apiGetProcessScenarioElements(long agentId, long sessionId, String scenarioId) {

        ApiProcessScenarioElementWSModel response = new ApiProcessScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiProcessScenarioElementWSDTO> scenarioElementWSDTOS = apiOperationScenarioFramework.apiGetProcessScenarioElementsService(agentId,sessionId,scenarioId);
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

    public ApiProcessScenarioElementWSModel apiGetProcessScenarioElement(long agentId, long sessionId, String scenarioId, String elementId) {

        ApiProcessScenarioElementWSModel response = new ApiProcessScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ApiProcessScenarioElementWSDTO scenarioElementWSDTO = apiOperationScenarioFramework.apiGetProcessScenarioElementService(agentId,sessionId,scenarioId,elementId);
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
