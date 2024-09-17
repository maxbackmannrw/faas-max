package com.faas.core.base.framework.campaign.details.trigger.details;

import com.faas.core.data.db.campaign.details.trigger.SipTriggerDBModel;
import com.faas.core.data.db.campaign.settings.TriggerTypeDBModel;
import com.faas.core.data.db.channel.account.SipAccountDBModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignSipTriggerWSDTO;
import com.faas.core.data.repo.campaign.details.trigger.SipTriggerRepository;
import com.faas.core.data.repo.campaign.settings.TriggerTypeRepository;
import com.faas.core.data.repo.channel.account.SipAccountRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignSipTriggerFramework {


    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignSipTriggerWSDTO> getCampaignSipTriggersService(long userId, String campaignId) {

        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();
        List<SipTriggerDBModel> sipTriggerDBModels = sipTriggerRepository.findByCampaignId(campaignId);
        for (SipTriggerDBModel sipTriggerDBModel : sipTriggerDBModels) {
            campaignSipTriggerWSDTOS.add(new CampaignSipTriggerWSDTO(sipTriggerDBModel));
        }
        return campaignSipTriggerWSDTOS;
    }

    public CampaignSipTriggerWSDTO getCampaignSipTriggerService(long userId, String triggerId) {

        Optional<SipTriggerDBModel> sipTriggerDBModel = sipTriggerRepository.findById(triggerId);
        if (sipTriggerDBModel.isPresent()) {
            return new CampaignSipTriggerWSDTO(sipTriggerDBModel.get());
        }
        return null;
    }

    public CampaignSipTriggerWSDTO createCampaignSipTriggerService(long userId, String campaignId, String trigger, String accountId, String callerId, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && sipAccountDBModel.isPresent()) {

            SipTriggerDBModel sipTriggerDBModel = new SipTriggerDBModel();
            sipTriggerDBModel.setCampaignId(campaignId);
            sipTriggerDBModel.setTrigger(trigger);
            sipTriggerDBModel.setAccountId(accountId);
            sipTriggerDBModel.setAccount(sipAccountDBModel.get().getAccount());
            sipTriggerDBModel.setCallerId(callerId);
            sipTriggerDBModel.setTriggerDatas(new ArrayList<>());
            sipTriggerDBModel.setTypeId(typeId);
            sipTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            sipTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sipTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            sipTriggerDBModel.setStatus(1);

            return new CampaignSipTriggerWSDTO(sipTriggerRepository.save(sipTriggerDBModel));
        }
        return null;
    }

    public CampaignSipTriggerWSDTO updateCampaignSipTriggerService(long userId, String triggerId, String trigger, String accountId, String callerId) {

        Optional<SipTriggerDBModel> sipTriggerDBModel = sipTriggerRepository.findById(triggerId);
        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipTriggerDBModel.isPresent() && sipAccountDBModel.isPresent()) {

            sipTriggerDBModel.get().setTrigger(trigger);
            sipTriggerDBModel.get().setAccountId(accountId);
            sipTriggerDBModel.get().setAccount(sipAccountDBModel.get().getAccount());
            sipTriggerDBModel.get().setCallerId(callerId);
            sipTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sipTriggerDBModel.get().setStatus(1);

            return new CampaignSipTriggerWSDTO(sipTriggerRepository.save(sipTriggerDBModel.get()));
        }
        return null;
    }

    public CampaignSipTriggerWSDTO removeCampaignSipTriggerService(long userId, String triggerId) {

        Optional<SipTriggerDBModel> sipTriggerDBModel = sipTriggerRepository.findById(triggerId);
        if (sipTriggerDBModel.isPresent()) {
            sipTriggerRepository.delete(sipTriggerDBModel.get());
            return new CampaignSipTriggerWSDTO(sipTriggerDBModel.get());
        }
        return null;
    }


}
