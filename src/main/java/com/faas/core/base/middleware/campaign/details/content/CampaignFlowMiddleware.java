package com.faas.core.base.middleware.campaign.details.content;

import com.faas.core.base.framework.campaign.details.content.CampaignFlowFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.CampaignFlowWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignFlowWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignFlowMiddleware {


    @Autowired
    CampaignFlowFramework campaignFlowFramework;


    public CampaignFlowWSModel getCampaignFlow(long userId, String campaignId) {

        CampaignFlowWSModel response = new CampaignFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowWSDTO campaignFlowWSDTO = campaignFlowFramework.getCampaignFlowService(userId,campaignId);
        if (campaignFlowWSDTO != null){
            response.setCampaignFlow(campaignFlowWSDTO);
        }

        general.setOperation("getCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignFlowWSModel updateCampaignFlow(long userId, String campaignId, String campaignFlow) {

        CampaignFlowWSModel response = new CampaignFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignFlowWSDTO campaignFlowWSDTO = campaignFlowFramework.updateCampaignFlowService(userId,campaignId,campaignFlow);
        if (campaignFlowWSDTO != null){
            response.setCampaignFlow(campaignFlowWSDTO);
        }

        general.setOperation("updateCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignDataWSModel getCampaignFlowDatas(long userId, String campaignId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignDataWSDTO> campaignDataWSDTOS = campaignFlowFramework.getCampaignFlowDatasService(userId,campaignId);
        if (campaignDataWSDTOS != null){
            response.setCampaignDatas(campaignDataWSDTOS);
        }

        general.setOperation("getCampaignFlowDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel getCampaignFlowData(long userId, String campaignId, String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignFlowFramework.getCampaignFlowDataService(userId,campaignId,dataId);
        if (campaignDataWSDTO != null){
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("getCampaignFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel createCampaignFlowData(long userId, String campaignId, long typeId, String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignFlowFramework.createCampaignFlowDataService(userId,campaignId,typeId,value);
        if (campaignDataWSDTO != null){
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("createCampaignFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel updateCampaignFlowData(long userId, String campaignId, String dataId, long typeId, String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignFlowFramework.updateCampaignFlowDataService(userId,campaignId,dataId,typeId,value);
        if (campaignDataWSDTO != null){
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("updateCampaignFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel removeCampaignFlowData(long userId, String campaignId, String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignFlowFramework.removeCampaignFlowDataService(userId,campaignId,dataId);
        if (campaignDataWSDTO != null){
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("removeCampaignFlowData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
