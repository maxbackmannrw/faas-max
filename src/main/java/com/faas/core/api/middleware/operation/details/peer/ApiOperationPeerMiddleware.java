package com.faas.core.api.middleware.operation.details.peer;

import com.faas.core.api.framework.operation.details.peer.ApiOperationPeerFramework;
import com.faas.core.api.model.ws.operation.details.peer.ApiClientPeerWSModel;
import com.faas.core.api.model.ws.operation.details.peer.ApiOperationPeerWSModel;
import com.faas.core.api.model.ws.operation.details.peer.dto.ApiOperationPeerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationPeerMiddleware {


    @Autowired
    ApiOperationPeerFramework apiOperationPeerFramework;


    public ApiOperationPeerWSModel apiGetOperationPeer(long agentId, long sessionId, long clientId, String campaignId) {

        ApiOperationPeerWSModel response = new ApiOperationPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = apiOperationPeerFramework.apiGetOperationPeerService();
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


    public ApiClientPeerWSModel apiGetClientPeers(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientPeerWSModel response = new ApiClientPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = apiOperationPeerFramework.apiGetClientPeersService();
        if (operationPeerWSDTO != null){
        }

        general.setOperation("apiGetOperationPeer");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientPeerWSModel apiGetClientPeer(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientPeerWSModel response = new ApiClientPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = apiOperationPeerFramework.apiGetClientPeerService();
        if (operationPeerWSDTO != null){
        }

        general.setOperation("apiGetOperationPeer");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientPeerWSModel apiCreateClientPeer(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientPeerWSModel response = new ApiClientPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = apiOperationPeerFramework.apiCreateClientPeerService();
        if (operationPeerWSDTO != null){
        }

        general.setOperation("apiGetOperationPeer");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientPeerWSModel apiUpdateClientPeer(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientPeerWSModel response = new ApiClientPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = apiOperationPeerFramework.apiUpdateClientPeerService();
        if (operationPeerWSDTO != null){
        }

        general.setOperation("apiGetOperationPeer");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientPeerWSModel apiRemoveClientPeer(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientPeerWSModel response = new ApiClientPeerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPeerWSDTO operationPeerWSDTO = apiOperationPeerFramework.apiRemoveClientPeerService();
        if (operationPeerWSDTO != null){
        }

        general.setOperation("apiGetOperationPeer");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
