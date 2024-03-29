package com.faas.core.api.framework.operation.details.osint;

import com.faas.core.api.model.ws.operation.details.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationOSINTFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationOSINTWSDTO> apiGetOperationClientOSINTsService(long agentId, long clientId){

        return null;
    }

    public ApiOperationOSINTWSDTO apiGetOperationClientOSINTService(long agentId,long clientId){

        return null;
    }


}
