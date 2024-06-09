package com.faas.core.api.framework.operation.client.content;

import com.faas.core.api.model.ws.operation.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationClientFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationClientWSDTO apiAgentGetClientsService(long agentId, int reqPage, int reqSize) {


        return null;
    }


    public ApiOperationClientWSDTO apiGetClientService(long agentId, long clientId) {

        if (operationRepository.existsByClientIdAndAgentId(clientId,agentId)){
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
            if (clientDBModel.isPresent() && !clientDetailsDBModels.isEmpty()){
                ApiOperationClientWSDTO clientWSDTO = new ApiOperationClientWSDTO();
                clientWSDTO.setClient(clientDBModel.get());
                clientWSDTO.setClientDetails(clientDetailsDBModels.get(0));

                return clientWSDTO;
            }
        }
        return null;
    }

}
