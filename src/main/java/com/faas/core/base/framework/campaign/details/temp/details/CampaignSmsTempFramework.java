package com.faas.core.base.framework.campaign.details.temp.details;

import com.faas.core.data.db.campaign.details.temp.SmsTempDBModel;
import com.faas.core.data.db.channel.settings.MessageTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.temp.details.dto.CampaignSmsTempWSDTO;
import com.faas.core.data.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.data.repo.channel.settings.MessageTypeRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignSmsTempFramework {


    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignSmsTempWSDTO> getCampaignSmsTempsService(long userId, String campaignId) {

        List<CampaignSmsTempWSDTO> campaignSmsTempWSDTOS = new ArrayList<>();
        List<SmsTempDBModel> smsTempDBModels = smsTempRepository.findByCampaignId(campaignId);
        for (SmsTempDBModel smsTempDBModel : smsTempDBModels) {
            campaignSmsTempWSDTOS.add(new CampaignSmsTempWSDTO(smsTempDBModel));
        }
        return campaignSmsTempWSDTOS;
    }

    public CampaignSmsTempWSDTO getCampaignSmsTempService(long userId, String tempId) {

        Optional<SmsTempDBModel> smsTempDBModel = smsTempRepository.findById(tempId);
        if (smsTempDBModel.isPresent()) {
            return new CampaignSmsTempWSDTO(smsTempDBModel.get());
        }
        return null;
    }

    public CampaignSmsTempWSDTO createCampaignSmsTempService(long userId, String campaignId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (messageTypeDBModel.isPresent()) {

            SmsTempDBModel smsTempDBModel = new SmsTempDBModel();
            smsTempDBModel.setCampaignId(campaignId);
            smsTempDBModel.setSmsTitle(smsTitle);
            smsTempDBModel.setSmsBody(smsBody);
            smsTempDBModel.setSenderId(senderId);
            smsTempDBModel.setTypeId(typeId);
            smsTempDBModel.setMessageType(messageTypeDBModel.get().getMessageType());
            smsTempDBModel.setTempDatas(new ArrayList<>());
            smsTempDBModel.setTempAssets(new ArrayList<>());
            smsTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsTempDBModel.setStatus(1);

            return new CampaignSmsTempWSDTO(smsTempRepository.save(smsTempDBModel));
        }
        return null;
    }

    public CampaignSmsTempWSDTO updateCampaignSmsTempService(long userId, String tempId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<SmsTempDBModel> smsTempDBModel = smsTempRepository.findById(tempId);
        Optional<MessageTypeDBModel> messageTypeDBModel = messageTypeRepository.findById(typeId);
        if (smsTempDBModel.isPresent() && messageTypeDBModel.isPresent()) {

            smsTempDBModel.get().setSmsTitle(smsTitle);
            smsTempDBModel.get().setSmsBody(smsBody);
            smsTempDBModel.get().setSenderId(senderId);
            smsTempDBModel.get().setTypeId(typeId);
            smsTempDBModel.get().setMessageType(messageTypeDBModel.get().getMessageType());
            smsTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsTempDBModel.get().setStatus(1);

            return new CampaignSmsTempWSDTO(smsTempRepository.save(smsTempDBModel.get()));
        }
        return null;
    }

    public CampaignSmsTempWSDTO removeCampaignSmsTempService(long userId, String tempId) {

        Optional<SmsTempDBModel> smsTempDBModel = smsTempRepository.findById(tempId);
        if (smsTempDBModel.isPresent()) {
            smsTempRepository.delete(smsTempDBModel.get());
            return new CampaignSmsTempWSDTO(smsTempDBModel.get());
        }
        return null;
    }


}
