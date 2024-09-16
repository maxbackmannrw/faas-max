package com.faas.core.base.middleware.campaign.details.trigger.details;

import com.faas.core.base.framework.campaign.details.trigger.details.CampaignWappTriggerFramework;
import com.faas.core.data.ws.base.campaign.details.trigger.details.CampaignWappCallTriggerWSModel;
import com.faas.core.data.ws.base.campaign.details.trigger.details.CampaignWappMessageTriggerWSModel;
import com.faas.core.data.ws.base.campaign.details.trigger.details.dto.CampaignWappCallTriggerWSDTO;
import com.faas.core.data.ws.base.campaign.details.trigger.details.dto.CampaignWappMessageTriggerWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignWappTriggerMiddleware {


    @Autowired
    CampaignWappTriggerFramework campaignWappTriggerFramework;


    public CampaignWappMessageTriggerWSModel getCampaignWappMessageTriggers(long userId, String campaignId) {

        CampaignWappMessageTriggerWSModel response = new CampaignWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = campaignWappTriggerFramework.getCampaignWappMessageTriggersService(userId, campaignId);
        if (campaignWappMessageTriggerWSDTOS != null) {
            response.setCampaignWappMessageTriggers(campaignWappMessageTriggerWSDTOS);
        }

        general.setOperation("getCampaignWappMessageTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTriggerWSModel getCampaignWappMessageTrigger(long userId, String triggerId) {

        CampaignWappMessageTriggerWSModel response = new CampaignWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();

        CampaignWappMessageTriggerWSDTO campaignWappMessageTriggerWSDTO = campaignWappTriggerFramework.getCampaignWappMessageTriggerService(userId, triggerId);
        if (campaignWappMessageTriggerWSDTO != null) {
            campaignWappMessageTriggerWSDTOS.add(campaignWappMessageTriggerWSDTO);
        }

        response.setCampaignWappMessageTriggers(campaignWappMessageTriggerWSDTOS);
        general.setOperation("getCampaignWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTriggerWSModel createCampaignWappMessageTrigger(long userId, String campaignId, String trigger, String accountId, String wappTitle, String wappBody, long typeId) {

        CampaignWappMessageTriggerWSModel response = new CampaignWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();

        CampaignWappMessageTriggerWSDTO campaignWappMessageTriggerWSDTO = campaignWappTriggerFramework.createCampaignWappMessageTriggerService(userId, campaignId, trigger, accountId, wappTitle, wappBody, typeId);
        if (campaignWappMessageTriggerWSDTO != null) {
            campaignWappMessageTriggerWSDTOS.add(campaignWappMessageTriggerWSDTO);
        }

        response.setCampaignWappMessageTriggers(campaignWappMessageTriggerWSDTOS);
        general.setOperation("createCampaignWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTriggerWSModel updateCampaignWappMessageTrigger(long userId, String triggerId, String trigger, String accountId, String wappTitle, String wappBody) {

        CampaignWappMessageTriggerWSModel response = new CampaignWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();

        CampaignWappMessageTriggerWSDTO campaignWappMessageTriggerWSDTO = campaignWappTriggerFramework.updateCampaignWappMessageTriggerService(userId, triggerId, trigger, accountId, wappTitle, wappBody);
        if (campaignWappMessageTriggerWSDTO != null) {
            campaignWappMessageTriggerWSDTOS.add(campaignWappMessageTriggerWSDTO);
        }

        response.setCampaignWappMessageTriggers(campaignWappMessageTriggerWSDTOS);
        general.setOperation("updateCampaignWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappMessageTriggerWSModel removeCampaignWappMessageTrigger(long userId, String triggerId) {

        CampaignWappMessageTriggerWSModel response = new CampaignWappMessageTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappMessageTriggerWSDTO> campaignWappMessageTriggerWSDTOS = new ArrayList<>();

        CampaignWappMessageTriggerWSDTO campaignWappMessageTriggerWSDTO = campaignWappTriggerFramework.removeCampaignWappMessageTriggerService(userId, triggerId);
        if (campaignWappMessageTriggerWSDTO != null) {
            campaignWappMessageTriggerWSDTOS.add(campaignWappMessageTriggerWSDTO);
        }

        response.setCampaignWappMessageTriggers(campaignWappMessageTriggerWSDTOS);
        general.setOperation("removeCampaignWappMessageTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignWappCallTriggerWSModel getCampaignWappCallTriggers(long userId, String campaignId) {

        CampaignWappCallTriggerWSModel response = new CampaignWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = campaignWappTriggerFramework.getCampaignWappCallTriggersService(userId, campaignId);
        if (campaignWappCallTriggerWSDTOS != null) {
            response.setCampaignWappCallTriggers(campaignWappCallTriggerWSDTOS);
        }

        general.setOperation("getCampaignWappCallTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappCallTriggerWSModel getCampaignWappCallTrigger(long userId, String triggerId) {

        CampaignWappCallTriggerWSModel response = new CampaignWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();

        CampaignWappCallTriggerWSDTO campaignWappCallTriggerWSDTO = campaignWappTriggerFramework.getCampaignWappCallTriggerService(userId, triggerId);
        if (campaignWappCallTriggerWSDTO != null) {
            campaignWappCallTriggerWSDTOS.add(campaignWappCallTriggerWSDTO);
        }

        response.setCampaignWappCallTriggers(campaignWappCallTriggerWSDTOS);
        general.setOperation("getCampaignWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappCallTriggerWSModel createCampaignWappCallTrigger(long userId, String campaignId, String trigger, String accountId, long typeId) {

        CampaignWappCallTriggerWSModel response = new CampaignWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();

        CampaignWappCallTriggerWSDTO campaignWappCallTriggerWSDTO = campaignWappTriggerFramework.createCampaignWappCallTriggerService(userId, campaignId, trigger, accountId, typeId);
        if (campaignWappCallTriggerWSDTO != null) {
            campaignWappCallTriggerWSDTOS.add(campaignWappCallTriggerWSDTO);
        }

        response.setCampaignWappCallTriggers(campaignWappCallTriggerWSDTOS);
        general.setOperation("createCampaignWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappCallTriggerWSModel updateCampaignWappCallTrigger(long userId, String triggerId, String trigger, String accountId) {

        CampaignWappCallTriggerWSModel response = new CampaignWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();

        CampaignWappCallTriggerWSDTO campaignWappCallTriggerWSDTO = campaignWappTriggerFramework.updateCampaignWappCallTriggerService(userId, triggerId, trigger, accountId);
        if (campaignWappCallTriggerWSDTO != null) {
            campaignWappCallTriggerWSDTOS.add(campaignWappCallTriggerWSDTO);
        }

        response.setCampaignWappCallTriggers(campaignWappCallTriggerWSDTOS);
        general.setOperation("updateCampaignWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignWappCallTriggerWSModel removeCampaignWappCallTrigger(long userId, String triggerId) {

        CampaignWappCallTriggerWSModel response = new CampaignWappCallTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignWappCallTriggerWSDTO> campaignWappCallTriggerWSDTOS = new ArrayList<>();

        CampaignWappCallTriggerWSDTO campaignWappCallTriggerWSDTO = campaignWappTriggerFramework.removeCampaignWappCallTriggerService(userId, triggerId);
        if (campaignWappCallTriggerWSDTO != null) {
            campaignWappCallTriggerWSDTOS.add(campaignWappCallTriggerWSDTO);
        }

        response.setCampaignWappCallTriggers(campaignWappCallTriggerWSDTOS);
        general.setOperation("removeCampaignWappCallTrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
