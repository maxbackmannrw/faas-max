package com.faas.core.base.framework.campaign.details.client.content;

import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class CampaignClientFramework {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignClientWSDTO searchClientsService(String clientCity,String clientCountry,String clientState,int reqPage,int reqSize) {

        if (clientCountry.equalsIgnoreCase("")){
            return sessionHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientState(clientState,PageRequest.of(reqPage,reqSize)));
        }
        if (clientCity.equalsIgnoreCase("") && !clientCountry.equalsIgnoreCase("")){
            return sessionHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientCountryAndClientState(clientCountry,clientState,PageRequest.of(reqPage,reqSize)));
        }
        if (!clientCity.equalsIgnoreCase("") && !clientCountry.equalsIgnoreCase("")){
            return sessionHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientCountryAndClientCityContainingIgnoreCaseAndClientState(clientCountry,clientCity,clientState,PageRequest.of(reqPage,reqSize)));
        }
        return null;
    }


    public ClientWSDTO getCampaignClientService(long userId, long clientId) {

        return null;
    }



}
