package com.faas.core.base.framework.campaign.settings;

import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.base.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CampaignSettingsFramework {


    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignTypeWSDTO fillCampaignTypeWSDTO(CampaignTypeDBModel campaignTypeDBModel) {

        CampaignTypeWSDTO campaignTypeWSDTO = new CampaignTypeWSDTO();
        campaignTypeWSDTO.setCampaignType(campaignTypeDBModel);
        return campaignTypeWSDTO;
    }


    public CampaignTypeDBModel createCampaignType(String campaignType) {

        CampaignTypeDBModel campaignTypeDBModel = new CampaignTypeDBModel();
        campaignTypeDBModel.setCampaignType(campaignType);
        campaignTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        campaignTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        campaignTypeDBModel.setStatus(1);

        return campaignTypeRepository.save(campaignTypeDBModel);
    }

    public CampaignTypeDBModel updateCampaignType(long typeId, String campaignType) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeDBModel.get().setCampaignType(campaignType);
            campaignTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignTypeDBModel.get().setStatus(1);

            return campaignTypeRepository.save(campaignTypeDBModel.get());
        }
        return null;
    }


    public CampaignTypeDBModel removeCampaignType(long typeId) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeRepository.delete(campaignTypeDBModel.get());
            return campaignTypeDBModel.get();
        }
        return null;
    }





}
