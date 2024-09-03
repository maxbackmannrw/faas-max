package com.faas.core.base.framework.campaign.manager.client;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.campaign.manager.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.helpers.client.ClientHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CampaignManagerClientFramework {


    @Autowired
    ClientHelpers clientHelpers;

    @Autowired
    ClientRepository clientRepository;


    public CampaignClientWSDTO searchCampaignClientsService(String city,String clientState,int reqPage,int reqSize) {

        if (city.equalsIgnoreCase(AppConstant.NONE)){
            return clientHelpers.mapCampaignClientWSDTO(clientRepository.findAllByClientState(clientState,PageRequest.of(reqPage,reqSize)));
        }else {
            return clientHelpers.mapCampaignClientWSDTO(clientRepository.findAllByClientCityAndClientState(city,clientState,PageRequest.of(reqPage,reqSize)));
        }
    }

    public ClientWSDTO getCampaignClientService(long userId,long clientId,String campaignId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        return null;
    }


}
