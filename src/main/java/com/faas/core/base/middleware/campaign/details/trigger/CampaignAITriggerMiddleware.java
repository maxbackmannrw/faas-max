package com.faas.core.base.middleware.campaign.details.trigger;

import com.faas.core.base.framework.campaign.details.trigger.CampaignAITriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.CampaignAITriggerWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.dto.CampaignAITriggerWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignAITriggerMiddleware {


    @Autowired
    CampaignAITriggerFramework campaignAiTriggerFramework;


    public CampaignAITriggerWSModel getCampaignAITriggers(long userId, String campaignId) {

        CampaignAITriggerWSModel response = new CampaignAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignAITriggerWSDTO> campaignAITriggerWSDTOS = campaignAiTriggerFramework.getCampaignAITriggersService(userId,campaignId);
        if (campaignAITriggerWSDTOS != null){
            response.setCampaignAITriggers(campaignAITriggerWSDTOS);
        }

        general.setOperation("getCampaignAITriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAITriggerWSModel getCampaignAITrigger(long userId, String triggerId) {

        CampaignAITriggerWSModel response = new CampaignAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAITriggerWSDTO> campaignAITriggerWSDTOS = new ArrayList<>();

        CampaignAITriggerWSDTO campaignAITriggerWSDTO = campaignAiTriggerFramework.getCampaignAITriggerService(userId,triggerId);
        if (campaignAITriggerWSDTO != null){
            campaignAITriggerWSDTOS.add(campaignAITriggerWSDTO);
        }

        response.setCampaignAITriggers(campaignAITriggerWSDTOS);
        general.setOperation("getCampaignAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAITriggerWSModel createCampaignAITrigger(long userId, String campaignId, String trigger, String accountId, long typeId) {

        CampaignAITriggerWSModel response = new CampaignAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAITriggerWSDTO> campaignAITriggerWSDTOS = new ArrayList<>();

        CampaignAITriggerWSDTO campaignAITriggerWSDTO = campaignAiTriggerFramework.createCampaignAITriggerService(userId,campaignId,trigger,accountId,typeId);
        if (campaignAITriggerWSDTO != null){
            campaignAITriggerWSDTOS.add(campaignAITriggerWSDTO);
        }

        response.setCampaignAITriggers(campaignAITriggerWSDTOS);
        general.setOperation("createCampaignAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAITriggerWSModel updateCampaignAITrigger(long userId, String triggerId, String trigger, String accountId) {

        CampaignAITriggerWSModel response = new CampaignAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAITriggerWSDTO> campaignAITriggerWSDTOS = new ArrayList<>();

        CampaignAITriggerWSDTO campaignAITriggerWSDTO = campaignAiTriggerFramework.updateCampaignAITriggerService(userId,triggerId,trigger,accountId);
        if (campaignAITriggerWSDTO != null){
            campaignAITriggerWSDTOS.add(campaignAITriggerWSDTO);
        }

        response.setCampaignAITriggers(campaignAITriggerWSDTOS);
        general.setOperation("updateCampaignAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignAITriggerWSModel removeCampaignAITrigger(long userId, String triggerId) {

        CampaignAITriggerWSModel response = new CampaignAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignAITriggerWSDTO> campaignAITriggerWSDTOS = new ArrayList<>();

        CampaignAITriggerWSDTO campaignAITriggerWSDTO = campaignAiTriggerFramework.removeCampaignAITriggerService(userId,triggerId);
        if (campaignAITriggerWSDTO != null){
            campaignAITriggerWSDTOS.add(campaignAITriggerWSDTO);
        }

        response.setCampaignAITriggers(campaignAITriggerWSDTOS);
        general.setOperation("removeCampaignAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
