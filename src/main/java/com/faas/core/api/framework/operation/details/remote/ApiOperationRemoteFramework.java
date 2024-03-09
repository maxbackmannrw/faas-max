package com.faas.core.api.framework.operation.details.remote;

import com.faas.core.api.model.ws.operation.details.remote.dto.ApiOperationClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationRemoteFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationClientRemoteWSDTO> apiGetOperationClientRemotesService(long agentId, long sessionId, long clientId){


        return null;
    }

    public ApiOperationClientRemoteWSDTO apiGetOperationClientRemoteService(long agentId, long sessionId, long clientId){


        return null;
    }


}
