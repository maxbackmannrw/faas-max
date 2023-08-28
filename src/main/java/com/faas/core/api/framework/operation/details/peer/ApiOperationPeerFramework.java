package com.faas.core.api.framework.operation.details.peer;

import com.faas.core.api.model.ws.operation.details.peer.dto.ApiOperationPeerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationPeerFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationPeerWSDTO apiGetOperationPeerService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }


    public ApiOperationPeerWSDTO apiGetClientPeersService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }

    public ApiOperationPeerWSDTO apiGetClientPeerService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }

    public ApiOperationPeerWSDTO apiCreateClientPeerService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }

    public ApiOperationPeerWSDTO apiUpdateClientPeerService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }

    public ApiOperationPeerWSDTO apiRemoveClientPeerService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }

}
