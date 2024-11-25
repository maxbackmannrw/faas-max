package com.faas.core.api.middleware.operation.manager.intel;

import com.faas.core.api.framework.operation.manager.intel.ApiOperationIntelFramework;
import com.faas.core.api.model.ws.operation.manager.intel.ApiOperationIntelWSModel;
import com.faas.core.api.model.ws.operation.manager.intel.dto.ApiOperationIntelWSDTO;
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


    public ApiOperationIntelWSModel apiGetOperationIntels(long agentId, long clientId) {

        ApiOperationIntelWSModel response = new ApiOperationIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationIntelWSDTO> operationIntelWSDTOS = apiOperationIntelFramework.apiGetOperationIntelsService(agentId, clientId);
        if (operationIntelWSDTOS != null) {
            response.setOperationIntels(operationIntelWSDTOS);
        }

        general.setOperation("apiGetOperationIntels");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationIntelWSModel apiGetOperationIntel(long agentId, long clientId) {

        ApiOperationIntelWSModel response = new ApiOperationIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationIntelWSDTO> operationIntelWSDTOS = new ArrayList<>();

        ApiOperationIntelWSDTO operationIntelWSDTO = apiOperationIntelFramework.apiGetOperationIntelService(agentId, clientId);
        if (operationIntelWSDTO != null) {
            operationIntelWSDTOS.add(operationIntelWSDTO);
        }

        response.setOperationIntels(operationIntelWSDTOS);
        general.setOperation("apiGetOperationIntel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
