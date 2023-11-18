package com.faas.core.base.framework.campaign.details.client.content;

import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ClientHelper;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class CampaignClientFramework {

    @Autowired
    ClientHelper clientHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignClientWSDTO searchClientsService(String city, String country, String clientState, int reqPage, int reqSize) {

        if (country.equalsIgnoreCase("")){
            return clientHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientState(clientState,PageRequest.of(reqPage,reqSize)));
        }
        if (city.equalsIgnoreCase("") && !country.equalsIgnoreCase("")){
            return clientHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientCountryAndClientState(country,clientState,PageRequest.of(reqPage,reqSize)));
        }
        if (!city.equalsIgnoreCase("") && !country.equalsIgnoreCase("")){
            return clientHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientCountryAndClientCityContainingIgnoreCaseAndClientState(country,city,clientState,PageRequest.of(reqPage,reqSize)));
        }
        return null;
    }


    public ClientWSDTO getCampaignClientService(long userId, long clientId) {

        return null;
    }


}
