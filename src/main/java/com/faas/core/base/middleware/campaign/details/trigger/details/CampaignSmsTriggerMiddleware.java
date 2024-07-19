package com.faas.core.base.middleware.campaign.details.trigger.details;

import com.faas.core.base.framework.campaign.details.trigger.details.CampaignSmsTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.CampaignSmsTriggerWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.details.dto.CampaignSmsTriggerWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignSmsTriggerMiddleware {


    @Autowired
    CampaignSmsTriggerFramework campaignSmsTriggerFramework;


    public CampaignSmsTriggerWSModel getCampaignSmsTriggers(long userId, String campaignId) {

        CampaignSmsTriggerWSModel response = new CampaignSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = campaignSmsTriggerFramework.getCampaignSmsTriggersService(userId,campaignId);
        if (campaignSmsTriggerWSDTOS != null){
            response.setCampaignSmsTriggers(campaignSmsTriggerWSDTOS);
        }

        general.setOperation("getCampaignSmsTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTriggerWSModel getCampaignSmsTrigger(long userId, String triggerId) {

        CampaignSmsTriggerWSModel response = new CampaignSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();

        CampaignSmsTriggerWSDTO campaignSmsTriggerWSDTO = campaignSmsTriggerFramework.getCampaignSmsTriggerService(userId,triggerId);
        if (campaignSmsTriggerWSDTO != null){
            campaignSmsTriggerWSDTOS.add(campaignSmsTriggerWSDTO);
        }

        response.setCampaignSmsTriggers(campaignSmsTriggerWSDTOS);
        general.setOperation("getCampaignSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTriggerWSModel createCampaignSmsTrigger(long userId, String campaignId, String trigger, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        CampaignSmsTriggerWSModel response = new CampaignSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();

        CampaignSmsTriggerWSDTO campaignSmsTriggerWSDTO = campaignSmsTriggerFramework.createCampaignSmsTriggerService(userId,campaignId,trigger,accountId,smsTitle,smsBody,senderId,typeId);
        if (campaignSmsTriggerWSDTO != null){
            campaignSmsTriggerWSDTOS.add(campaignSmsTriggerWSDTO);
        }

        response.setCampaignSmsTriggers(campaignSmsTriggerWSDTOS);
        general.setOperation("createCampaignSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTriggerWSModel updateCampaignSmsTrigger(long userId, String triggerId, String trigger, String accountId, String smsTitle, String smsBody, String senderId) {

        CampaignSmsTriggerWSModel response = new CampaignSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();

        CampaignSmsTriggerWSDTO campaignSmsTriggerWSDTO = campaignSmsTriggerFramework.updateCampaignSmsTriggerService(userId,triggerId,trigger,accountId,smsTitle,smsBody,senderId);
        if (campaignSmsTriggerWSDTO != null){
            campaignSmsTriggerWSDTOS.add(campaignSmsTriggerWSDTO);
        }

        response.setCampaignSmsTriggers(campaignSmsTriggerWSDTOS);
        general.setOperation("updateCampaignSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSmsTriggerWSModel removeCampaignSmsTrigger(long userId, String triggerId) {

        CampaignSmsTriggerWSModel response = new CampaignSmsTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSmsTriggerWSDTO> campaignSmsTriggerWSDTOS = new ArrayList<>();

        CampaignSmsTriggerWSDTO campaignSmsTriggerWSDTO = campaignSmsTriggerFramework.removeCampaignSmsTriggerService(userId,triggerId);
        if (campaignSmsTriggerWSDTO != null){
            campaignSmsTriggerWSDTOS.add(campaignSmsTriggerWSDTO);
        }

        response.setCampaignSmsTriggers(campaignSmsTriggerWSDTOS);
        general.setOperation("removeCampaignSmsTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
