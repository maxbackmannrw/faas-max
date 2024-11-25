package com.faas.core.api.framework.operation.manager.intel;

import com.faas.core.api.model.ws.operation.manager.intel.dto.ApiOperationIntelWSDTO;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationIntelFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationIntelWSDTO> apiGetOperationIntelsService(long agentId, long clientId) {

        return null;
    }

    public ApiOperationIntelWSDTO apiGetOperationIntelService(long agentId, long clientId) {

        return null;
    }


}
