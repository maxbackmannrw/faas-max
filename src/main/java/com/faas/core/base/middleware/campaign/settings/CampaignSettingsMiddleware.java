package com.faas.core.base.middleware.campaign.settings;

import com.faas.core.base.framework.campaign.settings.CampaignSettingsFramework;
import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.ws.campaign.settings.CampaignTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.base.model.ws.campaign.settings.FlowTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.InquiryTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.dto.FlowTypeWSDTO;
import com.faas.core.base.model.ws.campaign.settings.dto.InquiryTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignSettingsMiddleware {


    @Autowired
    CampaignSettingsFramework campaignSettingsFramework;

    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignTypeWSModel getAllCampaignTypes(long userId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        List<CampaignTypeDBModel> campaignTypeDBModels = campaignTypeRepository.findByStatus(1);
        if (campaignTypeDBModels.size() > 0) {
            for (CampaignTypeDBModel campaignTypeDBModel : campaignTypeDBModels) {
                campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
            }
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("getAllCampaignTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel getCampaignType(long userId, long typeId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel.get()));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("getCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel createCampaignType(long userId, String campaignType) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        CampaignTypeDBModel campaignTypeDBModel = campaignSettingsFramework.createCampaignType(campaignType);
        if (campaignTypeDBModel != null) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("createCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel updateCampaignType(long userId, long typeId, String campaignType) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        CampaignTypeDBModel campaignTypeDBModel = campaignSettingsFramework.updateCampaignType(typeId, campaignType);
        if (campaignTypeDBModel != null) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("updateCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignTypeWSModel removeCampaignType(long userId, long typeId) {

        CampaignTypeWSModel response = new CampaignTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignTypeWSDTO> campaignTypeWSDTOS = new ArrayList<>();

        CampaignTypeDBModel campaignTypeDBModel = campaignSettingsFramework.removeCampaignType(typeId);
        if (campaignTypeDBModel != null) {
            campaignTypeWSDTOS.add(campaignSettingsFramework.fillCampaignTypeWSDTO(campaignTypeDBModel));
        }

        response.setCampaignTypes(campaignTypeWSDTOS);
        general.setOperation("removeCampaignType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquiryTypeWSModel getAllInquiryTypes(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = campaignSettingsFramework.getAllInquiryTypesService(userId);
        if (inquiryTypeWSDTOS != null){
            response.setInquiryTypes(inquiryTypeWSDTOS);
        }

        general.setOperation("getAllInquiryTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel getInquiryType(long userId,long typeId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = campaignSettingsFramework.getInquiryTypeService(typeId);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("getInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel createInquiryType(long userId,String inquiryType) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = campaignSettingsFramework.createInquiryTypeService(inquiryType);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("createInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel updateInquiryType(long userId,long typeId,String inquiryType) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = campaignSettingsFramework.updateInquiryTypeService(typeId,inquiryType);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("updateInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel removeInquiryType(long userId,long typeId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = campaignSettingsFramework.removeInquiryTypeService(typeId);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("removeInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public FlowTypeWSModel getAllFlowTypes(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowTypeWSDTO> flowTypeWSDTOS = campaignSettingsFramework.getAllFlowTypesService(userId);
        if (flowTypeWSDTOS != null){
            response.setFlowTypes(flowTypeWSDTOS);
        }

        general.setOperation("getAllFlowTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel getFlowType(long userId,long typeId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = campaignSettingsFramework.getFlowTypeService(typeId);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("getFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel createFlowType(long userId,String flowType) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = campaignSettingsFramework.createFlowTypeService(flowType);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("createFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel updateFlowType(long userId,long typeId,String flowType) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = campaignSettingsFramework.updateFlowTypeService(typeId,flowType);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("updateFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel removeFlowType(long userId,long typeId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = campaignSettingsFramework.removeFlowTypeService(typeId);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("removeFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
