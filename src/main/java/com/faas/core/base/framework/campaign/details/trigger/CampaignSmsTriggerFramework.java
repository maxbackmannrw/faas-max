package com.faas.core.base.framework.campaign.details.trigger;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.campaign.details.trigger.*;
import com.faas.core.base.model.db.campaign.settings.TriggerTypeDBModel;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignSmsTriggerWSDTO;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.channel.settings.MessageTypeRepository;
import com.faas.core.base.repo.campaign.details.trigger.*;
import com.faas.core.base.repo.campaign.settings.TriggerTypeRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignSmsTriggerFramework {


    @Autowired
    SmsTriggerRepository smsTriggerRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignSmsTriggerWSDTO> getCampaignSmsTriggersService(long userId, String campaignId) {

        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();
        List<SmsTriggerDBModel> smsTriggerDBModels = smsTriggerRepository.findByCampaignId(campaignId);
        for (SmsTriggerDBModel smsTriggerDBModel : smsTriggerDBModels) {
            campaignSmsTriggerWSDTOS.add(new CampaignSmsTriggerWSDTO(smsTriggerDBModel));
        }
        return campaignSmsTriggerWSDTOS;
    }

    public CampaignSmsTriggerWSDTO getCampaignSmsTriggerService(long userId, String triggerId) {

        Optional<SmsTriggerDBModel> smsTriggerDBModel = smsTriggerRepository.findById(triggerId);
        if (smsTriggerDBModel.isPresent()){
            return new CampaignSmsTriggerWSDTO(smsTriggerDBModel.get());
        }
        return null;
    }

    public CampaignSmsTriggerWSDTO createCampaignSmsTriggerService(long userId, String campaignId, String trigger, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (smsAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()){

            SmsTriggerDBModel smsTriggerDBModel = new SmsTriggerDBModel();
            smsTriggerDBModel.setCampaignId(campaignId);
            smsTriggerDBModel.setTrigger(trigger);
            smsTriggerDBModel.setAccountId(accountId);
            smsTriggerDBModel.setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerDBModel.setSmsTitle(smsTitle);
            smsTriggerDBModel.setSmsBody(smsBody);
            smsTriggerDBModel.setSenderId(senderId);
            smsTriggerDBModel.setTriggerDatas(new ArrayList<>());
            smsTriggerDBModel.setTypeId(typeId);
            smsTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            smsTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsTriggerDBModel.setStatus(1);

            return new CampaignSmsTriggerWSDTO(smsTriggerRepository.save(smsTriggerDBModel));
        }
        return null;
    }

    public CampaignSmsTriggerWSDTO updateCampaignSmsTriggerService(long userId, String triggerId, String trigger, String accountId, String smsTitle, String smsBody, String senderId) {

        Optional<SmsTriggerDBModel> smsTriggerDBModel = smsTriggerRepository.findById(triggerId);
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsTriggerDBModel.isPresent() && smsAccountDBModel.isPresent()){

            smsTriggerDBModel.get().setTrigger(trigger);
            smsTriggerDBModel.get().setAccountId(accountId);
            smsTriggerDBModel.get().setAccount(smsAccountDBModel.get().getAccount());
            smsTriggerDBModel.get().setSmsTitle(smsTitle);
            smsTriggerDBModel.get().setSmsBody(smsBody);
            smsTriggerDBModel.get().setSenderId(senderId);
            smsAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsTriggerDBModel.get().setStatus(1);

            return new CampaignSmsTriggerWSDTO(smsTriggerRepository.save(smsTriggerDBModel.get()));
        }
        return null;
    }

    public CampaignSmsTriggerWSDTO removeCampaignSmsTriggerService(long userId, String triggerId) {

        Optional<SmsTriggerDBModel> smsTriggerDBModel = smsTriggerRepository.findById(triggerId);
        if (smsTriggerDBModel.isPresent()){
            smsTriggerRepository.delete(smsTriggerDBModel.get());
            return new CampaignSmsTriggerWSDTO(smsTriggerDBModel.get());
        }
        return null;
    }



}
