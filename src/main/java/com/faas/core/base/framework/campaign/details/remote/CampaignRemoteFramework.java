package com.faas.core.base.framework.campaign.details.remote;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.ws.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.remote.CampaignRemoteRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utils.UrlRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import com.faas.core.utility.helpers.remote.RemoteHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignRemoteFramework {

    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    RemoteHelpers remoteHelpers;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignRemoteRepository campaignRemoteRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignRemoteWSDTO> getCampaignRemotesService(long userId, String campaignId) {

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();
        List<CampaignRemoteDBModel> campaignRemoteDBModels = campaignRemoteRepository.findByCampaignId(campaignId);
        for (CampaignRemoteDBModel campaignRemoteDBModel : campaignRemoteDBModels) {
            campaignRemoteWSDTOS.add(campaignHelpers.createCampaignRemoteWSDTO(campaignRemoteDBModel));
        }
        return campaignRemoteWSDTOS;
    }

    public List<CampaignRemoteWSDTO> getCampaignRemotesByCategoryService(long userId, String campaignId, String remoteCategory) {

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();
        List<CampaignRemoteDBModel> campaignRemoteDBModels = campaignRemoteRepository.findByCampaignIdAndRemoteCategory(campaignId, remoteCategory);
        for (CampaignRemoteDBModel campaignRemoteDBModel : campaignRemoteDBModels) {
            campaignRemoteWSDTOS.add(campaignHelpers.createCampaignRemoteWSDTO(campaignRemoteDBModel));
        }
        return campaignRemoteWSDTOS;
    }

    public CampaignRemoteWSDTO getCampaignRemoteService(long userId, String campaignRemoteId) {

        Optional<CampaignRemoteDBModel> campaignRemoteDBModel = campaignRemoteRepository.findById(campaignRemoteId);
        if (!campaignRemoteDBModel.isEmpty()) {
            return campaignHelpers.createCampaignRemoteWSDTO(campaignRemoteDBModel.get());
        }
        return null;
    }

    public CampaignRemoteWSDTO createCampaignRemoteService(long userId, String campaignId, String remoteId, String remoteCategory) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (campaignDBModel.isPresent() && remoteDBModel.isPresent()) {
            return campaignHelpers.createCampaignRemoteWSDTO(remoteHelpers.createCampaignRemoteDBModel(campaignDBModel.get(),remoteDBModel.get(),remoteCategory));
        }
        return null;
    }

    public CampaignRemoteWSDTO removeCampaignRemoteService(long userId, String campaignRemoteId) {

        Optional<CampaignRemoteDBModel> campaignRemoteDBModel = campaignRemoteRepository.findById(campaignRemoteId);
        if (campaignRemoteDBModel.isPresent()) {
            campaignRemoteRepository.delete(campaignRemoteDBModel.get());
            return campaignHelpers.createCampaignRemoteWSDTO(campaignRemoteDBModel.get());
        }
        return null;
    }



}
