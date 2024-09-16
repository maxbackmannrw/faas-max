package com.faas.core.base.framework.campaign.details.remote;

import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.data.db.remote.content.RemoteDBModel;
import com.faas.core.data.ws.base.campaign.details.remote.dto.CampaignRemoteWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.remote.CampaignRemoteRepository;
import com.faas.core.data.repo.remote.content.RemoteRepository;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import com.faas.core.misc.helpers.remote.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignRemoteFramework {

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignRemoteRepository campaignRemoteRepository;

    @Autowired
    RemoteRepository remoteRepository;


    public List<CampaignRemoteWSDTO> getCampaignRemotesService(long userId, String campaignId) {

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();
        List<CampaignRemoteDBModel> campaignRemoteDBModels = campaignRemoteRepository.findByCampaignId(campaignId);
        for (CampaignRemoteDBModel campaignRemoteDBModel : campaignRemoteDBModels) {
            campaignRemoteWSDTOS.add(campaignHelper.createCampaignRemoteWSDTO(campaignRemoteDBModel));
        }
        return campaignRemoteWSDTOS;
    }

    public List<CampaignRemoteWSDTO> getCampaignRemotesByCategoryService(long userId, String campaignId, String remoteCategory) {

        List<CampaignRemoteWSDTO> campaignRemoteWSDTOS = new ArrayList<>();
        List<CampaignRemoteDBModel> campaignRemoteDBModels = campaignRemoteRepository.findByCampaignIdAndRemoteCategory(campaignId, remoteCategory);
        for (CampaignRemoteDBModel campaignRemoteDBModel : campaignRemoteDBModels) {
            campaignRemoteWSDTOS.add(campaignHelper.createCampaignRemoteWSDTO(campaignRemoteDBModel));
        }
        return campaignRemoteWSDTOS;
    }

    public CampaignRemoteWSDTO getCampaignRemoteService(long userId, String campaignRemoteId) {

        Optional<CampaignRemoteDBModel> campaignRemoteDBModel = campaignRemoteRepository.findById(campaignRemoteId);
        if (!campaignRemoteDBModel.isEmpty()) {
            return campaignHelper.createCampaignRemoteWSDTO(campaignRemoteDBModel.get());
        }
        return null;
    }

    public CampaignRemoteWSDTO createCampaignRemoteService(long userId, String campaignId, String remoteId, String remoteCategory) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (campaignDBModel.isPresent() && remoteDBModel.isPresent()) {
            return campaignHelper.createCampaignRemoteWSDTO(remoteHelper.createCampaignRemoteDBModel(campaignDBModel.get(), remoteDBModel.get(), remoteCategory));
        }
        return null;
    }

    public CampaignRemoteWSDTO removeCampaignRemoteService(long userId, String campaignRemoteId) {

        Optional<CampaignRemoteDBModel> campaignRemoteDBModel = campaignRemoteRepository.findById(campaignRemoteId);
        if (campaignRemoteDBModel.isPresent()) {
            campaignRemoteRepository.delete(campaignRemoteDBModel.get());
            return campaignHelper.createCampaignRemoteWSDTO(campaignRemoteDBModel.get());
        }
        return null;
    }


}
