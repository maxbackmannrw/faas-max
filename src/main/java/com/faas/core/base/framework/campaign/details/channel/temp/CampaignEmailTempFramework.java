package com.faas.core.base.framework.campaign.details.channel.temp;

import com.faas.core.base.model.db.channel.settings.EmailTypeDBModel;
import com.faas.core.base.model.db.campaign.details.channel.temp.EmailTempDBModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignEmailTempWSDTO;
import com.faas.core.base.repo.channel.settings.EmailTypeRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.EmailTempRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CampaignEmailTempFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    EmailTypeRepository emailTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignEmailTempWSDTO> getCampaignEmailTempsService(long userId, String campaignId) {

        List<CampaignEmailTempWSDTO> campaignEmailTempWSDTOS = new ArrayList<>();
        List<EmailTempDBModel> emailTempDBModels = emailTempRepository.findByCampaignId(campaignId);
        for (EmailTempDBModel emailTempDBModel : emailTempDBModels) {
            campaignEmailTempWSDTOS.add(new CampaignEmailTempWSDTO(emailTempDBModel));
        }
        return campaignEmailTempWSDTOS;
    }

    public CampaignEmailTempWSDTO getCampaignEmailTempService(long userId, String tempId) {

        Optional<EmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()) {
            return new CampaignEmailTempWSDTO(emailTempDBModel.get());
        }
        return null;
    }

    public CampaignEmailTempWSDTO createCampaignEmailTempService(long userId, String campaignId, String emailSubject, String emailBody, String emailSender, long typeId) {

        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTypeDBModel.isPresent()){

            EmailTempDBModel emailTempDBModel = new EmailTempDBModel();
            emailTempDBModel.setCampaignId(campaignId);
            emailTempDBModel.setEmailSubject(emailSubject);
            emailTempDBModel.setEmailBody(emailBody);
            emailTempDBModel.setEmailSender(emailSender);
            emailTempDBModel.setTypeId(typeId);
            emailTempDBModel.setEmailType(emailTypeDBModel.get().getEmailType());
            emailTempDBModel.setTempDatas(new ArrayList<>());
            emailTempDBModel.setTempAssets(new ArrayList<>());
            emailTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
            emailTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
            emailTempDBModel.setStatus(1);

            return new CampaignEmailTempWSDTO(emailTempRepository.save(emailTempDBModel));
        }
        return null;
    }

    public CampaignEmailTempWSDTO updateCampaignEmailTempService(String tempId, String emailSubject, String emailBody, String emailSender, long typeId) {

        Optional<EmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        Optional<EmailTypeDBModel> emailTypeDBModel = emailTypeRepository.findById(typeId);
        if (emailTempDBModel.isPresent() && emailTypeDBModel.isPresent()){

            emailTempDBModel.get().setEmailSubject(emailSubject);
            emailTempDBModel.get().setEmailBody(emailBody);
            emailTempDBModel.get().setEmailSender(emailSender);
            emailTempDBModel.get().setTypeId(typeId);
            emailTempDBModel.get().setEmailType(emailTypeDBModel.get().getEmailType());
            emailTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailTempDBModel.get().setStatus(1);

            return new CampaignEmailTempWSDTO(emailTempRepository.save(emailTempDBModel.get()));
        }
        return null;
    }

    public CampaignEmailTempWSDTO removeCampaignEmailTempService(String tempId) {

        Optional<EmailTempDBModel> emailTempDBModel = emailTempRepository.findById(tempId);
        if (emailTempDBModel.isPresent()){
            emailTempRepository.delete(emailTempDBModel.get());
            return new CampaignEmailTempWSDTO(emailTempDBModel.get());
        }
        return null;
    }


}
