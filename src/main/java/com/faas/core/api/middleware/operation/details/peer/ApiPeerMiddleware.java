package com.faas.core.api.middleware.operation.details.peer;

import com.faas.core.api.framework.operation.details.peer.ApiPeerFramework;
import com.faas.core.api.model.ws.operation.details.peer.ApiOperationPeerWSModel;
import com.faas.core.api.model.ws.operation.details.peer.dto.ApiOperationPeerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiPeerMiddleware {


    @Autowired
    ApiPeerFramework operationHookFramework;


    public ApiOperationPeerWSModel apiGetOperationPeer(long agentId, long sessionId, long clientId, String campaignId) {

        ApiOperationPeerWSModel response = new ApiOperationPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = operationHookFramework.apiGetOperationPeerService();
        if (operationPeerWSDTO != null){
            response.setOperationPeer(operationPeerWSDTO);
        }

        general.setOperation("apiGetOperationPeer");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
