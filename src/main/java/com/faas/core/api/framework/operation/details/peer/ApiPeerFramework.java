package com.faas.core.api.framework.operation.details.peer;

import com.faas.core.api.model.ws.operation.details.peer.dto.ApiOperationPeerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiPeerFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationPeerWSDTO apiGetOperationPeerService(){

        ApiOperationPeerWSDTO operationPeerWSDTO = new ApiOperationPeerWSDTO();
        return operationPeerWSDTO;
    }



}
