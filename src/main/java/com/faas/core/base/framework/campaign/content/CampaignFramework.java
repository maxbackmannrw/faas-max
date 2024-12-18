package com.faas.core.base.framework.campaign.content;

import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.channel.CampaignChannelRepository;
import com.faas.core.data.repo.campaign.details.temp.EmailTempRepository;
import com.faas.core.data.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.data.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.data.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.data.repo.campaign.details.trigger.*;
import com.faas.core.data.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignFramework {


    @Autowired
    CampaignHelper campaignHelper;

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
            campaignWSDTOS.add(campaignHelper.getCampaignWSDTO(campaignDBModel));
        }
        return campaignWSDTOS;
    }

    public List<CampaignWSDTO> getCampaignsByCategoryService(long userId, String campaignCategory) {

        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(campaignCategory);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignHelper.getCampaignWSDTO(campaignDBModel));
        }
        return campaignWSDTOS;
    }

    public List<CampaignWSDTO> getCampaignsByStateService(long userId, String campaignState) {

        List<CampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignState(campaignState);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            campaignWSDTOS.add(campaignHelper.getCampaignWSDTO(campaignDBModel));
        }
        return campaignWSDTOS;
    }

    public CampaignWSDTO getCampaignService(long userId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return campaignHelper.getCampaignWSDTO(campaignDBModel.get());
        }
        return null;
    }

    public CampaignWSDTO createCampaignService(long userId, String campaign, String campaignDesc, long campaignTypeId, String campaignCategory) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(campaignTypeId);
        if (campaignTypeDBModel.isPresent()) {

            CampaignDBModel campaignDBModel = new CampaignDBModel();
            campaignDBModel.setCampaign(campaign);
            campaignDBModel.setCampaignDesc(campaignDesc);
            campaignDBModel.setCampaignTypeId(campaignTypeId);
            campaignDBModel.setCampaignType(campaignTypeDBModel.get().getCampaignType());
            campaignDBModel.setCampaignCategory(campaignCategory);
            if (campaignCategory.equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
                campaignDBModel.setCampaignInquiry(campaignHelper.createCampaignInquiryDAO(campaign));
            }
            if (campaignCategory.equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)) {
                campaignDBModel.setCampaignFlow(campaignHelper.createCampaignFlowDAO(campaign));
            }
            campaignDBModel.setCampaignScripts(new ArrayList<>());
            campaignDBModel.setCampaignDatas(new ArrayList<>());
            campaignDBModel.setCampaignState(AppConstant.READY_CAMPAIGN);
            campaignDBModel.setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.setcDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.setStatus(1);

            campaignDBModel = campaignRepository.save(campaignDBModel);
            campaignHelper.createCampaignChannelDBModel(campaignDBModel);

            return campaignHelper.getCampaignWSDTO(campaignDBModel);
        }
        return null;
    }

    public CampaignWSDTO updateCampaignService(long userId, String campaignId, String campaign, String campaignDesc, String campaignState) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {

            campaignDBModel.get().setCampaign(campaign);
            campaignDBModel.get().setCampaignDesc(campaignDesc);
            campaignDBModel.get().setCampaignState(campaignState);
            campaignDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignDBModel.get().setStatus(1);

            return campaignHelper.getCampaignWSDTO(campaignRepository.save(campaignDBModel.get()));
        }
        return null;
    }

    public CampaignWSDTO removeCampaignService(String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {

            CampaignWSDTO campaignWSDTO = campaignHelper.getCampaignWSDTO(campaignDBModel.get());

            campaignRepository.delete(campaignDBModel.get());
            campaignChannelRepository.deleteAll(campaignChannelRepository.findByCampaignId(campaignId));

            emailTempRepository.deleteAll(emailTempRepository.findByCampaignId(campaignId));
            pushTempRepository.deleteAll(pushTempRepository.findByCampaignId(campaignId));
            smsTempRepository.deleteAll(smsTempRepository.findByCampaignId(campaignId));
            wappMessageTempRepository.deleteAll(wappMessageTempRepository.findByCampaignId(campaignId));

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
