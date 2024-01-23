package com.faas.core.api.middleware.operation.details.client.osint;

import com.faas.core.api.framework.operation.details.client.osint.ApiOperationOSINTFramework;
import com.faas.core.api.model.ws.operation.details.client.osint.ApiOperationOSINTWSModel;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationOSINTMiddleware {


    @Autowired
    ApiOperationOSINTFramework apiOperationOSINTFramework;



    public ApiOperationOSINTWSModel apiGetOperationOSINTs(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = apiOperationOSINTFramework.apiGetOperationOSINTsService(agentId,clientId);
        if (operationOSINTWSDTOS != null){
            response.setOperationOSINTs(operationOSINTWSDTOS);
        }

        general.setOperation("apiGetOperationOSINTs");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationOSINTWSModel apiGetOperationOSINT(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = new ArrayList<>();

        ApiOperationOSINTWSDTO operationOSINTWSDTO = apiOperationOSINTFramework.apiGetOperationOSINTService(agentId,clientId);
        if (operationOSINTWSDTO != null){
            operationOSINTWSDTOS.add(operationOSINTWSDTO);
        }

        response.setOperationOSINTs(operationOSINTWSDTOS);
        general.setOperation("apiGetOperationOSINT");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
