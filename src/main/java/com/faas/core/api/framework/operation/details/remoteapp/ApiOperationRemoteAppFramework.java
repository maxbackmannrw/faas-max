package com.faas.core.api.framework.operation.details.remoteapp;

import com.faas.core.api.model.ws.operation.details.remoteapp.dto.ApiOperationRemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationRemoteAppFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationRemoteAppWSDTO> apiGetOperationRemoteAppsService(long agentId, long sessionId, long clientId){


        return null;
    }

    public ApiOperationRemoteAppWSDTO apiGetOperationRemoteAppService(long agentId, long sessionId,long clientId){


        return null;
    }


}
