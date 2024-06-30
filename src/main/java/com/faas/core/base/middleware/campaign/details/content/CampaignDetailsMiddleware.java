package com.faas.core.base.middleware.campaign.details.content;

import com.faas.core.base.framework.campaign.details.content.CampaignDetailsFramework;
import com.faas.core.base.model.db.campaign.content.dao.CampaignDataDAO;
import com.faas.core.base.model.ws.campaign.details.content.CampaignScriptWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignScriptWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDetailsWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignDetailsMiddleware {


    @Autowired
    CampaignDetailsFramework campaignDetailsFramework;


    public CampaignDetailsWSModel getCampaignDetails(long userId, String campaignId) {

        CampaignDetailsWSModel response = new CampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignDetailsWSDTO campaignDetailsWSDTO = campaignDetailsFramework.getCampaignDetailsService(userId, campaignId);
        if (campaignDetailsWSDTO != null){
            response.setCampaignDetails(campaignDetailsWSDTO);
        }

        general.setOperation("getCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignDataWSModel getCampaignDatas(long userId, String campaignId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignDataWSDTO> campaignDataWSDTOS = campaignDetailsFramework.getCampaignDatasService(userId,campaignId);
        if (campaignDataWSDTOS != null) {
            response.setCampaignDatas(campaignDataWSDTOS);
        }

        general.setOperation("getCampaignDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel getCampaignData(long userId, String campaignId, String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignDetailsFramework.getCampaignDataService(userId,campaignId,dataId);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("getCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel createCampaignData(long userId, String campaignId, long typeId, String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignDetailsFramework.createCampaignDataService(userId,campaignId,typeId,value);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("createCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel updateCampaignData(long userId, String campaignId, String dataId, long typeId, String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignDetailsFramework.updateCampaignDataService(userId,campaignId,dataId,typeId,value);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("updateCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel removeCampaignData(long userId, String campaignId, String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignDetailsFramework.removeCampaignDataService(userId, campaignId, dataId);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("removeCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignScriptWSModel getCampaignScripts(long userId, String campaignId) {

        CampaignScriptWSModel response = new CampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignScriptWSDTO> campaignScriptWSDTOS = campaignDetailsFramework.getCampaignScriptsService(userId, campaignId);
        if (campaignScriptWSDTOS != null){
            response.setCampaignScripts(campaignScriptWSDTOS);
        }

        general.setOperation("getCampaignScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScriptWSModel getCampaignScript(long userId, String campaignId, String scriptId) {

        CampaignScriptWSModel response = new CampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScriptWSDTO> campaignScriptWSDTOS = new ArrayList<>();

        CampaignScriptWSDTO campaignScriptWSDTO = campaignDetailsFramework.getCampaignScriptService(userId, campaignId, scriptId);
        if (campaignScriptWSDTO != null){
            campaignScriptWSDTOS.add(campaignScriptWSDTO);
        }

        response.setCampaignScripts(campaignScriptWSDTOS);
        general.setOperation("getCampaignScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScriptWSModel createCampaignScript(long userId, String campaignId, String scriptTitle, String scriptBody, int scriptOrder) {

        CampaignScriptWSModel response = new CampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScriptWSDTO> campaignScriptWSDTOS = new ArrayList<>();

        CampaignScriptWSDTO campaignScriptWSDTO = campaignDetailsFramework.createCampaignScriptService(userId, campaignId, scriptTitle, scriptBody, scriptOrder);
        if (campaignScriptWSDTO != null){
            campaignScriptWSDTOS.add(campaignScriptWSDTO);
        }

        response.setCampaignScripts(campaignScriptWSDTOS);
        general.setOperation("createCampaignScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScriptWSModel updateCampaignScript(long userId, String campaignId, String scriptId, String scriptTitle, String scriptBody, int scriptOrder) {

        CampaignScriptWSModel response = new CampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScriptWSDTO> campaignScriptWSDTOS = new ArrayList<>();

        CampaignScriptWSDTO campaignScriptWSDTO = campaignDetailsFramework.updateCampaignScriptService(userId, campaignId, scriptId, scriptTitle, scriptBody, scriptOrder);
        if (campaignScriptWSDTO != null){
            campaignScriptWSDTOS.add(campaignScriptWSDTO);
        }

        response.setCampaignScripts(campaignScriptWSDTOS);
        general.setOperation("updateCampaignScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScriptWSModel removeCampaignScript(long userId, String campaignId, String scriptId) {

        CampaignScriptWSModel response = new CampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScriptWSDTO> campaignScriptWSDTOS = new ArrayList<>();

        CampaignScriptWSDTO campaignScriptWSDTO = campaignDetailsFramework.removeCampaignScriptService(userId, campaignId, scriptId);
        if (campaignScriptWSDTO != null){
            campaignScriptWSDTOS.add(campaignScriptWSDTO);
        }

        response.setCampaignScripts(campaignScriptWSDTOS);
        general.setOperation("removeCampaignScript");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
