package com.faas.core.base.middleware.campaign.details.content;

import com.faas.core.base.framework.campaign.details.content.CampaignDetailsFramework;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.content.dao.CampaignDataDAO;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDetailsWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDetailsWSDTO;
import com.faas.core.base.model.ws.campaign.details.content.CampaignProcessWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CampaignDetailsMiddleware {


    @Autowired
    CampaignDetailsFramework campaignDetailsFramework;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignDetailsWSModel getCampaignDetails(long userId, String campaignId) {

        CampaignDetailsWSModel response = new CampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignDetailsWSDTO campaignDetailsWSDTO  = campaignDetailsFramework.getCampaignDetailsService(campaignId);
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


    public CampaignProcessWSModel getCampaignProcess(long userId, String campaignId) {

        CampaignProcessWSModel response = new CampaignProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignProcessWSDTO campaignProcessWSDTO = campaignDetailsFramework.getCampaignProcessService(campaignId);
        if (campaignProcessWSDTO != null){
            response.setCampaignProcess(campaignProcessWSDTO);
        }

        general.setOperation("getCampaignProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public CampaignDataWSModel getCampaignDatas(long userId, String campaignId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO>campaignDataWSDTOS = new ArrayList<>();

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignDatas().size();i++){
                campaignDataWSDTOS.add(campaignDetailsFramework.fillCampaignDataWSDTO(campaignDBModel.get().getCampaignDatas().get(i)));
            }
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("getCampaignDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel getCampaignData(long userId, String campaignId,String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO>campaignDataWSDTOS = new ArrayList<>();

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignDatas() != null){
            for (int i=0;i<campaignDBModel.get().getCampaignDatas().size();i++){
                if (campaignDBModel.get().getCampaignDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    campaignDataWSDTOS.add(campaignDetailsFramework.fillCampaignDataWSDTO(campaignDBModel.get().getCampaignDatas().get(i)));
                }
            }
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("getCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel createCampaignData(long userId,String campaignId,long dataTypeId,String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO>campaignDataWSDTOS = new ArrayList<>();

        CampaignDataDAO campaignDataDAO = campaignDetailsFramework.createCampaignDataService(campaignId,dataTypeId,value);
        if (campaignDataDAO != null){
            campaignDataWSDTOS.add(campaignDetailsFramework.fillCampaignDataWSDTO(campaignDataDAO));
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("createCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignDataWSModel updateCampaignData(long userId,String campaignId,String dataId,long dataTypeId,String value) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO>campaignDataWSDTOS = new ArrayList<>();

        CampaignDataDAO campaignDataDAO = campaignDetailsFramework.updateCampaignDataService(campaignId,dataId,dataTypeId,value);
        if (campaignDataDAO != null){
            campaignDataWSDTOS.add(campaignDetailsFramework.fillCampaignDataWSDTO(campaignDataDAO));
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("updateCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignDataWSModel removeCampaignData(long userId,String campaignId,String dataId) {

        CampaignDataWSModel response = new CampaignDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignDataWSDTO>campaignDataWSDTOS = new ArrayList<>();

        CampaignDataDAO campaignDataDAO = campaignDetailsFramework.removeCampaignDataService(campaignId,dataId);
        if (campaignDataDAO != null){
            campaignDataWSDTOS.add(campaignDetailsFramework.fillCampaignDataWSDTO(campaignDataDAO));
        }

        response.setCampaignDatas(campaignDataWSDTOS);
        general.setOperation("removeCampaignData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
