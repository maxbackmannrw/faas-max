package com.faas.core.api.framework.operation.details.osint;

import com.faas.core.data.ws.api.operation.details.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationOSINTFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationOSINTWSDTO> apiGetOperationClientOSINTsService(long agentId, long clientId) {

        return null;
    }

    public ApiOperationOSINTWSDTO apiGetOperationClientOSINTService(long agentId, long clientId) {

        return null;
    }


}
