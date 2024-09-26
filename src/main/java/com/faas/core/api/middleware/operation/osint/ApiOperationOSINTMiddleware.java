package com.faas.core.api.middleware.operation.osint;

import com.faas.core.api.framework.operation.osint.ApiOperationOSINTFramework;
import com.faas.core.api.model.ws.operation.osint.ApiOperationOSINTWSModel;
import com.faas.core.api.model.ws.operation.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationOSINTMiddleware {


    @Autowired
    ApiOperationOSINTFramework apiOperationOSINTFramework;


    public ApiOperationOSINTWSModel apiGetOperationClientOSINTs(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = apiOperationOSINTFramework.apiGetOperationClientOSINTsService(agentId, clientId);
        if (operationOSINTWSDTOS != null) {
            response.setOperationOSINTs(operationOSINTWSDTOS);
        }

        general.setOperation("apiGetOperationClientOSINTs");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationOSINTWSModel apiGetOperationClientOSINT(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = new ArrayList<>();

        ApiOperationOSINTWSDTO operationOSINTWSDTO = apiOperationOSINTFramework.apiGetOperationClientOSINTService(agentId, clientId);
        if (operationOSINTWSDTO != null) {
            operationOSINTWSDTOS.add(operationOSINTWSDTO);
        }

        response.setOperationOSINTs(operationOSINTWSDTOS);
        general.setOperation("apiGetOperationClientOSINT");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
