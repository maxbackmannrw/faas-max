package com.faas.core.base.framework.campaign.manager.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.campaign.manager.content.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignManagerFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    CampaignRepository campaignRepository;


    public List<CampaignManagerWSDTO> getCampaignManagersService(long userId) {

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByStatus(1);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignManagerWSDTOS.add(campaignHelpers.getCampaignManagerWSDTO(campaignDBModel));
        }
        return campaignManagerWSDTOS;
    }

    public List<CampaignManagerWSDTO> getCampaignManagersByCategoryService(long userId,String campaignCategory) {

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(campaignCategory);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignManagerWSDTOS.add(campaignHelpers.getCampaignManagerWSDTO(campaignDBModel));
        }
        return campaignManagerWSDTOS;
    }

    public List<CampaignManagerWSDTO> getCampaignManagersByStateService(long userId,String campaignState) {

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignState(campaignState);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignManagerWSDTOS.add(campaignHelpers.getCampaignManagerWSDTO(campaignDBModel));
        }
        return campaignManagerWSDTOS;
    }

    public CampaignManagerWSDTO getCampaignManagerService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if(campaignDBModel.isPresent()) {
            return campaignHelpers.getCampaignManagerWSDTO(campaignDBModel.get());
        }
        return null;
    }

    public CampaignManagerWSDTO updateCampaignManagerStateService(long userId, String campaignId, String campaignState) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if(campaignDBModel.isPresent()) {
            CampaignDBModel updatedCampaign  = campaignHelpers.updateCampaignManagerStateHelper(campaignDBModel.get(),campaignState);
            if (updatedCampaign != null){
                return campaignHelpers.getCampaignManagerWSDTO(campaignRepository.save(updatedCampaign));
            }
        }
        return null;
    }

    public CampaignManagerWSDTO updateCampaignManagerInquiryStateService(long userId, String campaignId, String inquiryState) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if(campaignDBModel.isPresent()) {
            CampaignDBModel updatedCampaign  = campaignHelpers.updateCampaignManagerInquiryStateHelper(campaignDBModel.get(),inquiryState);
            if (updatedCampaign != null){
                return campaignHelpers.getCampaignManagerWSDTO(campaignRepository.save(updatedCampaign));
            }
        }
        return null;
    }

    public CampaignManagerWSDTO updateCampaignManagerFlowStateService(long userId, String campaignId, String flowState) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if(campaignDBModel.isPresent()) {
            CampaignDBModel updatedCampaign  = campaignHelpers.updateCampaignManagerFlowStateHelper(campaignDBModel.get(),flowState);
            if (updatedCampaign != null){
                return campaignHelpers.getCampaignManagerWSDTO(campaignRepository.save(updatedCampaign));
            }
        }
        return null;
    }

    public CampaignManagerDetailsWSDTO getCampaignManagerDetailsService(long userId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            return campaignHelpers.getCampaignManagerDetailsWSDTO(campaignDBModel.get());
        }
        return null;
    }


}