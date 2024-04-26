package com.faas.core.base.framework.manager.campaign.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignManagerFramework {


    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignManagerWSDTO> getCampaignManagersService(long userId) {

        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignState(AppConstant.ACTIVE_STATE);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignManagerWSDTOS.add(managerHelper.fillCampaignManagerWSDTO(campaignDBModel));
        }
        return campaignManagerWSDTOS;
    }

    public List<CampaignManagerWSDTO> getCampaignManagersByCategoryService(long userId,String campaignCategory) {

        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategoryAndCampaignState(campaignCategory,AppConstant.ACTIVE_STATE);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignManagerWSDTOS.add(managerHelper.fillCampaignManagerWSDTO(campaignDBModel));
        }
        return campaignManagerWSDTOS;
    }

    public CampaignManagerWSDTO getCampaignManagerService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return managerHelper.fillCampaignManagerWSDTO(campaignDBModel.get());
        }
        return null;
    }

    public CampaignManagerWSDTO updateCampaignManagerService(long userId,String campaignId) {

        return null;
    }

    public CampaignManagerWSDTO removeCampaignManagerService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            campaignRepository.delete(campaignDBModel.get());
            return managerHelper.fillCampaignManagerWSDTO(campaignDBModel.get());
        }
        return null;
    }

}
