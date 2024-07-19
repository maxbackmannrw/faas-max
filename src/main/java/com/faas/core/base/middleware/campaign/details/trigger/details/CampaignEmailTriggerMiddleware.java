package com.faas.core.base.middleware.campaign.details.trigger.details;

import com.faas.core.base.framework.campaign.details.trigger.details.CampaignEmailTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.CampaignEmailTriggerWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignEmailTriggerWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignEmailTriggerMiddleware {


    @Autowired
    CampaignEmailTriggerFramework campaignEmailTriggerFramework;


    public CampaignEmailTriggerWSModel getCampaignEmailTriggers(long userId, String campaignId) {

        CampaignEmailTriggerWSModel response = new CampaignEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = campaignEmailTriggerFramework.getCampaignEmailTriggersService(userId,campaignId);
        if (campaignEmailTriggerWSDTOS != null){
            response.setCampaignEmailTriggers(campaignEmailTriggerWSDTOS);
        }

        general.setOperation("getCampaignEmailTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTriggerWSModel getCampaignEmailTrigger(long userId, String triggerId) {

        CampaignEmailTriggerWSModel response = new CampaignEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();

        CampaignEmailTriggerWSDTO campaignEmailTriggerWSDTO = campaignEmailTriggerFramework.getCampaignEmailTriggerService(userId,triggerId);
        if (campaignEmailTriggerWSDTO != null){
            campaignEmailTriggerWSDTOS.add(campaignEmailTriggerWSDTO);
        }

        response.setCampaignEmailTriggers(campaignEmailTriggerWSDTOS);
        general.setOperation("getCampaignEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTriggerWSModel createCampaignEmailTrigger(long userId, String campaignId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender, long typeId) {

        CampaignEmailTriggerWSModel response = new CampaignEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();

        CampaignEmailTriggerWSDTO campaignEmailTriggerWSDTO = campaignEmailTriggerFramework.createCampaignEmailTriggerService(userId,campaignId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender,typeId);
        if (campaignEmailTriggerWSDTO != null){
            campaignEmailTriggerWSDTOS.add(campaignEmailTriggerWSDTO);
        }

        response.setCampaignEmailTriggers(campaignEmailTriggerWSDTOS);
        general.setOperation("createCampaignEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTriggerWSModel updateCampaignEmailTrigger(long userId, String triggerId, String trigger, String accountId, String emailSubject, String emailTitle, String emailBody, String emailSender) {

        CampaignEmailTriggerWSModel response = new CampaignEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();

        CampaignEmailTriggerWSDTO campaignEmailTriggerWSDTO = campaignEmailTriggerFramework.updateCampaignEmailTriggerService(userId,triggerId,trigger,accountId,emailSubject,emailTitle,emailBody,emailSender);
        if (campaignEmailTriggerWSDTO != null){
            campaignEmailTriggerWSDTOS.add(campaignEmailTriggerWSDTO);
        }

        response.setCampaignEmailTriggers(campaignEmailTriggerWSDTOS);
        general.setOperation("updateCampaignEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignEmailTriggerWSModel removeCampaignEmailTrigger(long userId, String triggerId) {

        CampaignEmailTriggerWSModel response = new CampaignEmailTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignEmailTriggerWSDTO> campaignEmailTriggerWSDTOS = new ArrayList<>();

        CampaignEmailTriggerWSDTO campaignEmailTriggerWSDTO = campaignEmailTriggerFramework.removeCampaignEmailTriggerService(userId,triggerId);
        if (campaignEmailTriggerWSDTO != null){
            campaignEmailTriggerWSDTOS.add(campaignEmailTriggerWSDTO);
        }

        response.setCampaignEmailTriggers(campaignEmailTriggerWSDTOS);
        general.setOperation("removeCampaignEmailTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
