package com.faas.core.base.framework.campaign.details.trigger.details;

import com.faas.core.data.db.campaign.details.trigger.EmailTriggerDBModel;
import com.faas.core.data.db.campaign.settings.TriggerTypeDBModel;
import com.faas.core.data.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignEmailTriggerWSDTO;
import com.faas.core.data.repo.campaign.details.trigger.EmailTriggerRepository;
import com.faas.core.data.repo.campaign.settings.TriggerTypeRepository;
import com.faas.core.data.repo.channel.account.EmailAccountRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignEmailTriggerFramework {


    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignEmailTriggerWSDTO> getCampaignEmailTriggersService(long userId, String campaignId) {

        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();
        List<EmailTriggerDBModel> emailTriggerDBModels = emailTriggerRepository.findByCampaignId(campaignId);
        for (EmailTriggerDBModel emailTriggerDBModel : emailTriggerDBModels) {
            campaignEmailTriggerWSDTOS.add(new CampaignEmailTriggerWSDTO(emailTriggerDBModel));
        }
        return campaignEmailTriggerWSDTOS;
    }

    public CampaignEmailTriggerWSDTO getCampaignEmailTriggerService(long userId, String triggerId) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()) {
            return new CampaignEmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }

    public CampaignEmailTriggerWSDTO createCampaignEmailTriggerService(long userId, String campaignId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (triggerTypeDBModel.isPresent() && emailAccountDBModel.isPresent()) {

            EmailTriggerDBModel emailTriggerDBModel = new EmailTriggerDBModel();
            emailTriggerDBModel.setCampaignId(campaignId);
            emailTriggerDBModel.setTrigger(trigger);
            emailTriggerDBModel.setAccountId(accountId);
            emailTriggerDBModel.setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerDBModel.setEmailSubject(emailSubject);
            emailTriggerDBModel.setEmailTitle(emailTitle);
            emailTriggerDBModel.setEmailBody(emailBody);
            emailTriggerDBModel.setEmailSender(emailSender);
            emailTriggerDBModel.setTriggerDatas(new ArrayList<>());
            emailTriggerDBModel.setTypeId(typeId);
            emailTriggerDBModel.setTriggerType(triggerTypeDBModel.get().getTriggerType());
            emailTriggerDBModel.setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.setcDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.setStatus(1);

            return new CampaignEmailTriggerWSDTO(emailTriggerRepository.save(emailTriggerDBModel));
        }
        return null;
    }

    public CampaignEmailTriggerWSDTO updateCampaignEmailTriggerService(long userId, String triggerId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailTriggerDBModel.isPresent() && emailAccountDBModel.isPresent()) {

            emailTriggerDBModel.get().setTrigger(trigger);
            emailTriggerDBModel.get().setAccountId(accountId);
            emailTriggerDBModel.get().setAccount(emailAccountDBModel.get().getAccount());
            emailTriggerDBModel.get().setEmailSubject(emailSubject);
            emailTriggerDBModel.get().setEmailTitle(emailTitle);
            emailTriggerDBModel.get().setEmailBody(emailBody);
            emailTriggerDBModel.get().setEmailSender(emailSender);
            emailTriggerDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTriggerDBModel.get().setStatus(1);

            return new CampaignEmailTriggerWSDTO(emailTriggerRepository.save(emailTriggerDBModel.get()));
        }
        return null;
    }

    public CampaignEmailTriggerWSDTO removeCampaignEmailTriggerService(long userId, String triggerId) {

        Optional<EmailTriggerDBModel> emailTriggerDBModel = emailTriggerRepository.findById(triggerId);
        if (emailTriggerDBModel.isPresent()) {
            emailTriggerRepository.delete(emailTriggerDBModel.get());
            return new CampaignEmailTriggerWSDTO(emailTriggerDBModel.get());
        }
        return null;
    }


}
