package com.faas.core.api.middleware.operation.details.transaction.content;

import com.faas.core.api.framework.operation.details.transaction.content.ApiOperationTransactionFramework;
import com.faas.core.api.model.ws.operation.details.transaction.scenario.ApiOperationScenarioWSModel;
import com.faas.core.api.model.ws.operation.details.transaction.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiOperationTransactionMiddleware {


    @Autowired
    ApiOperationTransactionFramework apiOperationTransactionFramework;


    public ApiOperationScenarioWSModel apiGetOperationScenarios(long agentId, long sessionId, String processId) {

        ApiOperationScenarioWSModel response = new ApiOperationScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = apiOperationTransactionFramework.apiGetOperationScenariosService(agentId,sessionId,processId);
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


}
