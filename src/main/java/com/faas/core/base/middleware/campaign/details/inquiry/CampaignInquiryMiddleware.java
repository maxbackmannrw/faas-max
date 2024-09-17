package com.faas.core.base.middleware.campaign.details.inquiry;

import com.faas.core.base.framework.campaign.details.inquiry.CampaignInquiryFramework;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.inquiry.CampaignInquiryWSModel;
import com.faas.core.base.model.ws.campaign.details.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignInquiryMiddleware {


    @Autowired
    CampaignInquiryFramework campaignInquiryFramework;


    public CampaignInquiryWSModel getCampaignInquiry(long userId, String campaignId) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryFramework.getCampaignInquiryService(userId, campaignId);
        if (campaignInquiryWSDTO != null) {
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("getCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignInquiryWSModel updateCampaignInquiry(long userId, String campaignId, String campaignInquiry) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryFramework.updateCampaignInquiryService(userId, campaignId, campaignInquiry);
        if (campaignInquiryWSDTO != null) {
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("updateCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignDataWSModel getCampaignInquiryDatas(long userId, String campaignId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignDataWSDTO> campaignDataWSDTOS = campaignInquiryFramework.getCampaignInquiryDatasService(userId, campaignId);
        if (campaignDataWSDTOS != null) {
            response.setCampaignDatas(campaignDataWSDTOS);
        }

        general.setOperation("getCampaignInquiryDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel getCampaignInquiryData(long userId, String campaignId, String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignInquiryFramework.getCampaignInquiryDataService(userId, campaignId, dataId);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("getCampaignInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel createCampaignInquiryData(long userId, String campaignId, long typeId, String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignInquiryFramework.createCampaignInquiryDataService(userId, campaignId, typeId, value);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("createCampaignInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel updateCampaignInquiryData(long userId, String campaignId, String dataId, long typeId, String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignInquiryFramework.updateCampaignInquiryDataService(userId, campaignId, dataId, typeId, value);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("updateCampaignInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel removeCampaignInquiryData(long userId, String campaignId, String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO> campaignDataWSDTOS = new ArrayList<>();

        CampaignDataWSDTO campaignDataWSDTO = campaignInquiryFramework.removeCampaignInquiryDataService(userId, campaignId, dataId);
        if (campaignDataWSDTO != null) {
            campaignDataWSDTOS.add(campaignDataWSDTO);
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("removeCampaignInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
