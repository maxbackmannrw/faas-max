package com.faas.core.base.middleware.campaign.details.trigger.details;

import com.faas.core.base.framework.campaign.details.trigger.details.CampaignSipTriggerFramework;
import com.faas.core.data.ws.base.campaign.details.trigger.details.CampaignSipTriggerWSModel;
import com.faas.core.data.ws.base.campaign.details.trigger.details.dto.CampaignSipTriggerWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignSipTriggerMiddleware {


    @Autowired
    CampaignSipTriggerFramework campaignSipTriggerFramework;


    public CampaignSipTriggerWSModel getCampaignSipTriggers(long userId, String campaignId) {

        CampaignSipTriggerWSModel response = new CampaignSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = campaignSipTriggerFramework.getCampaignSipTriggersService(userId, campaignId);
        if (campaignSipTriggerWSDTOS != null) {
            response.setCampaignSipTriggers(campaignSipTriggerWSDTOS);
        }

        general.setOperation("getCampaignSipTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSipTriggerWSModel getCampaignSipTrigger(long userId, String triggerId) {

        CampaignSipTriggerWSModel response = new CampaignSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();

        CampaignSipTriggerWSDTO campaignSipTriggerWSDTO = campaignSipTriggerFramework.getCampaignSipTriggerService(userId, triggerId);
        if (campaignSipTriggerWSDTO != null) {
            campaignSipTriggerWSDTOS.add(campaignSipTriggerWSDTO);
        }

        response.setCampaignSipTriggers(campaignSipTriggerWSDTOS);
        general.setOperation("getCampaignSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSipTriggerWSModel createCampaignSipTrigger(long userId, String campaignId, String trigger, String accountId, String callerId, long typeId) {

        CampaignSipTriggerWSModel response = new CampaignSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();

        CampaignSipTriggerWSDTO campaignSipTriggerWSDTO = campaignSipTriggerFramework.createCampaignSipTriggerService(userId, campaignId, trigger, accountId, callerId, typeId);
        if (campaignSipTriggerWSDTO != null) {
            campaignSipTriggerWSDTOS.add(campaignSipTriggerWSDTO);
        }

        response.setCampaignSipTriggers(campaignSipTriggerWSDTOS);
        general.setOperation("createCampaignSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSipTriggerWSModel updateCampaignSipTrigger(long userId, String triggerId, String trigger, String accountId, String callerId) {

        CampaignSipTriggerWSModel response = new CampaignSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();

        CampaignSipTriggerWSDTO campaignSipTriggerWSDTO = campaignSipTriggerFramework.updateCampaignSipTriggerService(userId, triggerId, trigger, accountId, callerId);
        if (campaignSipTriggerWSDTO != null) {
            campaignSipTriggerWSDTOS.add(campaignSipTriggerWSDTO);
        }

        response.setCampaignSipTriggers(campaignSipTriggerWSDTOS);
        general.setOperation("updateCampaignSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignSipTriggerWSModel removeCampaignSipTrigger(long userId, String triggerId) {

        CampaignSipTriggerWSModel response = new CampaignSipTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignSipTriggerWSDTO> campaignSipTriggerWSDTOS = new ArrayList<>();

        CampaignSipTriggerWSDTO campaignSipTriggerWSDTO = campaignSipTriggerFramework.removeCampaignSipTriggerService(userId, triggerId);
        if (campaignSipTriggerWSDTO != null) {
            campaignSipTriggerWSDTOS.add(campaignSipTriggerWSDTO);
        }

        response.setCampaignSipTriggers(campaignSipTriggerWSDTOS);
        general.setOperation("removeCampaignSipTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
