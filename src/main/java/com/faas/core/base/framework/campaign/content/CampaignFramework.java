package com.faas.core.base.framework.campaign.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;


@Component
public class CampaignFramework {


    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignWSDTO fillCampaignWSDTO(CampaignDBModel campaignDBModel) {

        CampaignWSDTO campaignWSDTO = new CampaignWSDTO();
        campaignWSDTO.setCampaign(campaignDBModel);
        return campaignWSDTO;
    }

    public CampaignDBModel createCampaignService(String campaign,String campaignDesc,String campaignCategory,long campaignTypeId,String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()){

            CampaignDBModel campaignDBModel = new CampaignDBModel();
            campaignDBModel.setCampaign(campaign);
            campaignDBModel.setCampaignDesc(campaignDesc);
            Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(campaignTypeId);
            if (campaignTypeDBModel.isPresent()) {
                campaignDBModel.setCampaignTypeId(campaignTypeId);
                campaignDBModel.setCampaignType(campaignTypeDBModel.get().getCampaignType());
            }
            campaignDBModel.setCampaignCategory(campaignCategory);
            campaignDBModel.setProcessId(processId);
            campaignDBModel.setProcess(processDBModel.get().getProcess());
            campaignDBModel.setProcessType(processDBModel.get().getProcessType());
            campaignDBModel.setProcessCategory(processDBModel.get().getCategory());
            campaignDBModel.setCampaignDatas(new ArrayList<>());
            campaignDBModel.setCampaignState(AppConstant.ACTIVE_CAMPAIGN);
            campaignDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.setStatus(1);

            return campaignRepository.save(campaignDBModel);
        }
        return null;
    }



    public CampaignDBModel updateCampaignService(String campaignId,String campaign,String campaignDesc,String campaignState) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {

            campaignDBModel.get().setCampaign(campaign);
            campaignDBModel.get().setCampaignDesc(campaignDesc);
            campaignDBModel.get().setCampaignState(campaignState);
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().setStatus(1);

            return campaignRepository.save(campaignDBModel.get());
        }
        return null;
    }


    public CampaignDBModel removeCampaignService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            campaignRepository.delete(campaignDBModel.get());
            return campaignDBModel.get();
        }
        return null;
    }


}
