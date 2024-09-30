package com.faas.core.api.middleware.operation.manager.intel;

import com.faas.core.api.framework.operation.manager.intel.ApiOperationIntelFramework;
import com.faas.core.api.model.ws.operation.manager.intel.ApiOperationOSINTWSModel;
import com.faas.core.api.model.ws.operation.manager.intel.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationIntelMiddleware {


    @Autowired
    ApiOperationIntelFramework apiOperationIntelFramework;


    public ApiOperationOSINTWSModel apiGetOperationClientOSINTs(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = apiOperationIntelFramework.apiGetOperationClientOSINTsService(agentId, clientId);
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

        ApiOperationOSINTWSDTO operationOSINTWSDTO = apiOperationIntelFramework.apiGetOperationClientOSINTService(agentId, clientId);
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
