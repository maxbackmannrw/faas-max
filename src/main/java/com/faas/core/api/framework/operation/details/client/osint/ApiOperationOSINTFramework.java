package com.faas.core.api.framework.operation.details.client.osint;

import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationOSINTFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationOSINTWSDTO> apiGetOperationOSINTsService(long agentId, long clientId){

        return null;
    }

    public ApiOperationOSINTWSDTO apiGetOperationOSINTService(long agentId,long clientId){

        return null;
    }


}
