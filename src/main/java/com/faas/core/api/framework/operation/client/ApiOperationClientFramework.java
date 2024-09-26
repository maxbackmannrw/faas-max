package com.faas.core.api.framework.operation.client;

import com.faas.core.api.model.ws.operation.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.client.dto.ApiOperationClientDetailsWSDTO;
import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
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


    public ApiOperationClientWSDTO apiGetClientService(long agentId, long clientId) {

        if (operationRepository.existsByClientIdAndAgentId(clientId, agentId)) {
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
            if (clientDBModel.isPresent() && !clientDetailsDBModels.isEmpty()) {
                ApiOperationClientWSDTO clientWSDTO = new ApiOperationClientWSDTO();
                clientWSDTO.setClient(clientDBModel.get());
                clientWSDTO.setClientDetails(clientDetailsDBModels.get(0));

                return clientWSDTO;
            }
        }
        return null;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientDetailsService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


    public ApiOperationClientDetailsWSDTO apiGetClientNotesService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiCreateClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiUpdateClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiRemoveClientNoteService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


    public ApiOperationClientDetailsWSDTO apiGetClientRemoteAppsService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientRemoteAppService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


    public ApiOperationClientDetailsWSDTO apiGetClientOSINTsService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    public ApiOperationClientDetailsWSDTO apiGetClientOSINTService(long agentId, long clientId) {

        ApiOperationClientDetailsWSDTO clientDetailsWSDTO = new ApiOperationClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }


}
