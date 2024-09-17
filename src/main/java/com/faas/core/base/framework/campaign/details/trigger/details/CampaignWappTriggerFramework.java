package com.faas.core.base.framework.campaign.details.trigger.details;

import com.faas.core.data.db.campaign.details.trigger.WappCallTriggerDBModel;
import com.faas.core.data.db.campaign.details.trigger.WappMessageTriggerDBModel;
import com.faas.core.data.db.campaign.settings.TriggerTypeDBModel;
import com.faas.core.data.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignWappCallTriggerWSDTO;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignWappMessageTriggerWSDTO;
import com.faas.core.data.repo.campaign.details.trigger.WappCallTriggerRepository;
import com.faas.core.data.repo.campaign.details.trigger.WappMessageTriggerRepository;
import com.faas.core.data.repo.campaign.settings.TriggerTypeRepository;
import com.faas.core.data.repo.channel.account.WappAccountRepository;
import com.faas.core.data.repo.channel.settings.MessageTypeRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignWappTriggerFramework {


    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    MessageTypeRepository messageTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignWappMessageTriggerWSDTO> getCampaignWappMessageTriggersService(long userId, String campaignId) {

        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();
        List<WappMessageTriggerDBModel> wappMessageTriggerDBModels = wappMessageTriggerRepository.findByCampaignId(campaignId);
        for (WappMessageTriggerDBModel wappMessageTriggerDBModel : wappMessageTriggerDBModels) {
            campaignWappMessageTriggerWSDTOS.add(new CampaignWappMessageTriggerWSDTO(wappMessageTriggerDBModel));
        }
        return campaignWappMessageTriggerWSDTOS;
    }

    public CampaignWappMessageTriggerWSDTO getCampaignWappMessageTriggerService(long userId, String triggerId) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()) {
            return new CampaignWappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }

    public CampaignWappMessageTriggerWSDTO createCampaignWappMessageTriggerService(long userId, String campaignId, String trigger, String accountId, String wappTitle, String wappBody, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()) {

            WappMessageTriggerDBModel wappMessageTriggerDBModel = new WappMessageTriggerDBModel();
            wappMessageTriggerDBModel.setCampaignId(campaignId);
            wappMessageTriggerDBModel.setTrigger(trigger);
            wappMessageTriggerDBModel.setAccountId(accountId);
            wappMessageTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.setWappTitle(wappTitle);
            wappMessageTriggerDBModel.setWappBody(wappBody);
            wappMessageTriggerDBModel.setTriggerDatas(new ArrayList<>());
            wappMessageTriggerDBModel.setTypeId(typeId);
            wappMessageTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappMessageTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.setStatus(1);

            return new CampaignWappMessageTriggerWSDTO(wappMessageTriggerRepository.save(wappMessageTriggerDBModel));
        }
        return null;
    }

    public CampaignWappMessageTriggerWSDTO updateCampaignWappMessageTriggerService(long userId, String triggerId, String trigger, String accountId, String wappTitle, String wappBody) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappMessageTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()) {

            wappMessageTriggerDBModel.get().setTrigger(trigger);
            wappMessageTriggerDBModel.get().setAccountId(accountId);
            wappMessageTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappMessageTriggerDBModel.get().setWappTitle(wappTitle);
            wappMessageTriggerDBModel.get().setWappBody(wappBody);
            wappMessageTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappMessageTriggerDBModel.get().setStatus(1);

            return new CampaignWappMessageTriggerWSDTO(wappMessageTriggerRepository.save(wappMessageTriggerDBModel.get()));
        }
        return null;
    }

    public CampaignWappMessageTriggerWSDTO removeCampaignWappMessageTriggerService(long userId, String triggerId) {

        Optional<WappMessageTriggerDBModel> wappMessageTriggerDBModel = wappMessageTriggerRepository.findById(triggerId);
        if (wappMessageTriggerDBModel.isPresent()) {
            wappMessageTriggerRepository.delete(wappMessageTriggerDBModel.get());
            return new CampaignWappMessageTriggerWSDTO(wappMessageTriggerDBModel.get());
        }
        return null;
    }


    public List<CampaignWappCallTriggerWSDTO> getCampaignWappCallTriggersService(long userId, String campaignId) {

        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();
        List<WappCallTriggerDBModel> wappCallTriggerDBModels = wappCallTriggerRepository.findByCampaignId(campaignId);
        for (WappCallTriggerDBModel wappCallTriggerDBModel : wappCallTriggerDBModels) {
            campaignWappCallTriggerWSDTOS.add(new CampaignWappCallTriggerWSDTO(wappCallTriggerDBModel));
        }
        return campaignWappCallTriggerWSDTOS;
    }

    public CampaignWappCallTriggerWSDTO getCampaignWappCallTriggerService(long userId, String triggerId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()) {
            return new CampaignWappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }

    public CampaignWappCallTriggerWSDTO createCampaignWappCallTriggerService(long userId, String campaignId, String trigger, String accountId, long typeId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (wappAccountDBModel.isPresent() && triggerTypeDBModel.isPresent()) {

            WappCallTriggerDBModel wappCallTriggerDBModel = new WappCallTriggerDBModel();
            wappCallTriggerDBModel.setCampaignId(campaignId);
            wappCallTriggerDBModel.setTrigger(trigger);
            wappCallTriggerDBModel.setAccountId(accountId);
            wappCallTriggerDBModel.setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.setTriggerDatas(new ArrayList<>());
            wappCallTriggerDBModel.setTypeId(typeId);
            wappCallTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            wappCallTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.setStatus(1);

            return new CampaignWappCallTriggerWSDTO(wappCallTriggerRepository.save(wappCallTriggerDBModel));
        }
        return null;
    }

    public CampaignWappCallTriggerWSDTO updateCampaignWappCallTriggerService(long userId, String triggerId, String trigger, String accountId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappCallTriggerDBModel.isPresent() && wappAccountDBModel.isPresent()) {

            wappCallTriggerDBModel.get().setTrigger(trigger);
            wappCallTriggerDBModel.get().setAccountId(accountId);
            wappCallTriggerDBModel.get().setAccount(wappAccountDBModel.get().getAccount());
            wappCallTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            wappCallTriggerDBModel.get().setStatus(1);

            return new CampaignWappCallTriggerWSDTO(wappCallTriggerRepository.save(wappCallTriggerDBModel.get()));
        }
        return null;
    }

    public CampaignWappCallTriggerWSDTO removeCampaignWappCallTriggerService(long userId, String triggerId) {

        Optional<WappCallTriggerDBModel> wappCallTriggerDBModel = wappCallTriggerRepository.findById(triggerId);
        if (wappCallTriggerDBModel.isPresent()) {
            wappCallTriggerRepository.delete(wappCallTriggerDBModel.get());
            return new CampaignWappCallTriggerWSDTO(wappCallTriggerDBModel.get());
        }
        return null;
    }


}
