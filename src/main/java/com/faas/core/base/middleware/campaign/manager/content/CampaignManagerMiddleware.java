package com.faas.core.base.middleware.campaign.manager.content;

import com.faas.core.base.framework.campaign.manager.content.CampaignManagerFramework;
import com.faas.core.data.ws.base.campaign.manager.content.CampaignManagerDetailsWSModel;
import com.faas.core.data.ws.base.campaign.manager.content.CampaignManagerWSModel;
import com.faas.core.data.ws.base.campaign.manager.content.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.data.ws.base.campaign.manager.content.dto.CampaignManagerWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignManagerMiddleware {


    @Autowired
    CampaignManagerFramework campaignManagerFramework;


    public CampaignManagerWSModel getCampaignManagers(long userId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = campaignManagerFramework.getCampaignManagersService(userId);
        if (campaignManagerWSDTOS != null) {
            response.setCampaignManagers(campaignManagerWSDTOS);
        }

        general.setOperation("getCampaignManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel getCampaignManagersByCategory(long userId, String campaignCategory) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = campaignManagerFramework.getCampaignManagersByCategoryService(userId, campaignCategory);
        if (campaignManagerWSDTOS != null) {
            response.setCampaignManagers(campaignManagerWSDTOS);
        }

        general.setOperation("getCampaignManagersByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel getCampaignManagersByState(long userId, String campaignState) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = campaignManagerFramework.getCampaignManagersByStateService(userId, campaignState);
        if (campaignManagerWSDTOS != null) {
            response.setCampaignManagers(campaignManagerWSDTOS);
        }

        general.setOperation("getCampaignManagersByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel getCampaignManager(long userId, String campaignId) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.getCampaignManagerService(userId, campaignId);
        if (campaignManagerWSDTO != null) {
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("getCampaignManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel updateCampaignManagerState(long userId, String campaignId, String campaignState) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.updateCampaignManagerStateService(userId, campaignId, campaignState);
        if (campaignManagerWSDTO != null) {
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("updateCampaignManagerState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel updateCampaignManagerInquiryState(long userId, String campaignId, String inquiryState) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.updateCampaignManagerInquiryStateService(userId, campaignId, inquiryState);
        if (campaignManagerWSDTO != null) {
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("updateCampaignManagerInquiryState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerWSModel updateCampaignManagerFlowState(long userId, String campaignId, String flowState) {

        CampaignManagerWSModel response = new CampaignManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = campaignManagerFramework.updateCampaignManagerFlowStateService(userId, campaignId, flowState);
        if (campaignManagerWSDTO != null) {
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
        general.setOperation("updateCampaignManagerFlowState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignManagerDetailsWSModel getCampaignManagerDetails(long userId, String campaignId) {

        CampaignManagerDetailsWSModel response = new CampaignManagerDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignManagerDetailsWSDTO campaignManagerDetailsWSDTO = campaignManagerFramework.getCampaignManagerDetailsService(userId, campaignId);
        if (campaignManagerDetailsWSDTO != null) {
            response.setCampaignManagerDetails(campaignManagerDetailsWSDTO);
        }

        general.setOperation("getCampaignManagerDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
