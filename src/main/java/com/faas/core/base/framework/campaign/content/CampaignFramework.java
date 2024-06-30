package com.faas.core.base.framework.campaign.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.channel.content.*;
import com.faas.core.base.repo.campaign.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.base.repo.campaign.details.trigger.*;
import com.faas.core.base.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    CampaignChannelRepository campaignChannelRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    AITriggerRepository aiTriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SmsTriggerRepository smsTriggerRepository;

    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignWSDTO> getCampaignsService(long userId) {

        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByStatus(1);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignHelpers.getCampaignWSDTO(campaignDBModel));
        }
        return campaignWSDTOS;
    }

    public List<CampaignWSDTO> getCampaignsByCategoryService(long userId, String campaignCategory) {

        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(campaignCategory);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignHelpers.getCampaignWSDTO(campaignDBModel));
        }
        return campaignWSDTOS;
    }

    public List<CampaignWSDTO> getCampaignsByStateService(long userId, String campaignState) {

        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignState(campaignState);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignHelpers.getCampaignWSDTO(campaignDBModel));
        }
        return campaignWSDTOS;
    }

    public CampaignWSDTO getCampaignService(long userId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            return campaignHelpers.getCampaignWSDTO(campaignDBModel.get());
        }
        return null;
    }

    public CampaignWSDTO createCampaignService(long userId, String campaign,String campaignDesc,long campaignTypeId,String campaignCategory) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(campaignTypeId);
        if (campaignTypeDBModel.isPresent()){

            CampaignDBModel campaignDBModel = new CampaignDBModel();
            campaignDBModel.setCampaign(campaign);
            campaignDBModel.setCampaignDesc(campaignDesc);
            campaignDBModel.setCampaignTypeId(campaignTypeId);
            campaignDBModel.setCampaignType(campaignTypeDBModel.get().getCampaignType());
            campaignDBModel.setCampaignCategory(campaignCategory);
            if (campaignCategory.equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                campaignDBModel.setCampaignInquiry(campaignHelpers.createCampaignInquiryDAO(campaign));
            }
            if (campaignCategory.equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
                campaignDBModel.setCampaignFlow(campaignHelpers.createCampaignFlowDAO(campaign));;
            }
            campaignDBModel.setCampaignAssets(new ArrayList<>());
            campaignDBModel.setCampaignScripts(new ArrayList<>());
            campaignDBModel.setCampaignDatas(new ArrayList<>());
            campaignDBModel.setCampaignState(AppConstant.READY_CAMPAIGN);
            campaignDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.setStatus(1);

            campaignDBModel = campaignRepository.save(campaignDBModel);
            campaignHelpers.createCampaignChannelDBModel(campaignDBModel);

            return campaignHelpers.getCampaignWSDTO(campaignDBModel);
        }
        return null;
    }

    public CampaignWSDTO updateCampaignService(long userId, String campaignId, String campaign, String campaignDesc, String campaignState) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){

            campaignDBModel.get().setCampaign(campaign);
            campaignDBModel.get().setCampaignDesc(campaignDesc);
            campaignDBModel.get().setCampaignDesc(campaignState);
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().setStatus(1);

            return campaignHelpers.getCampaignWSDTO(campaignRepository.save(campaignDBModel.get()));
        }
       return null;
    }

    public CampaignWSDTO removeCampaignService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {

            CampaignWSDTO campaignWSDTO = campaignHelpers.getCampaignWSDTO(campaignDBModel.get());

            campaignRepository.delete(campaignDBModel.get());
            campaignScenarioRepository.deleteAll(campaignScenarioRepository.findByCampaignId(campaignId));
            campaignChannelRepository.deleteAll(campaignChannelRepository.findByCampaignId(campaignId));;

            emailTempRepository.deleteAll(emailTempRepository.findByCampaignId(campaignId));
            pushTempRepository.deleteAll(pushTempRepository.findByCampaignId(campaignId));
            smsTempRepository.deleteAll(smsTempRepository.findByCampaignId(campaignId));
            wappMessageTempRepository.deleteAll(wappMessageTempRepository.findByCampaignId(campaignId));

            aiTriggerRepository.deleteAll(aiTriggerRepository.findByCampaignId(campaignId));
            emailTriggerRepository.deleteAll(emailTriggerRepository.findByCampaignId(campaignId));
            sipTriggerRepository.deleteAll(sipTriggerRepository.findByCampaignId(campaignId));
            smsTriggerRepository.deleteAll(smsTriggerRepository.findByCampaignId(campaignId));
            wappCallTriggerRepository.deleteAll(wappCallTriggerRepository.findByCampaignId(campaignId));
            wappMessageTriggerRepository.deleteAll(wappMessageTriggerRepository.findByCampaignId(campaignId));

            return campaignWSDTO;
        }
        return null;
    }



}
