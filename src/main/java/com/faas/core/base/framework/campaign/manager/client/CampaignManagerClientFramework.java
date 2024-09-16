package com.faas.core.base.framework.campaign.manager.client;

import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.ws.base.campaign.manager.client.CampaignClientRequest;
import com.faas.core.data.ws.base.campaign.manager.client.dto.CampaignClientWSDTO;
import com.faas.core.data.ws.base.client.content.dto.ClientWSDTO;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.client.ClientHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignManagerClientFramework {


    @Autowired
    ClientHelpers clientHelpers;

    @Autowired
    ClientRepository clientRepository;


    public CampaignClientWSDTO searchCampaignClientsService(String city, String clientState, int reqPage, int reqSize) {

        if (city.equalsIgnoreCase(AppConstant.NONE)) {
            return clientHelpers.mapCampaignClientWSDTO(clientRepository.findAllByClientState(clientState, PageRequest.of(reqPage, reqSize)));
        } else {
            return clientHelpers.mapCampaignClientWSDTO(clientRepository.findAllByClientCityAndClientState(city, clientState, PageRequest.of(reqPage, reqSize)));
        }
    }

    public List<ClientWSDTO> getSelectedCampaignClients(CampaignClientRequest clientRequest) {

        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();
        if (clientRequest.getClientRequests() != null) {
            for (int i = 0; i < clientRequest.getClientRequests().size(); i++) {
                List<ClientDBModel> clientDBModels = clientRepository.findByIdAndClientState(clientRequest.getClientRequests().get(i).getClientId(), AppConstant.READY_CLIENT);
                if (!clientDBModels.isEmpty()) {
                    clientWSDTOS.add(new ClientWSDTO(clientDBModels.get(0)));
                }
            }
        }
        return clientWSDTOS;
    }

    public ClientWSDTO getCampaignClientService(long userId, long clientId, String campaignId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()) {
            return new ClientWSDTO(clientDBModel.get());
        }
        return null;
    }


}
