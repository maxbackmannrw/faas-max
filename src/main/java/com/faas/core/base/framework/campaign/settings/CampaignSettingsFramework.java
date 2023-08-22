package com.faas.core.base.framework.campaign.settings;

import com.faas.core.base.model.db.campaign.settings.CampaignTypeDBModel;
import com.faas.core.base.model.db.campaign.settings.FlowTypeDBModel;
import com.faas.core.base.model.db.campaign.settings.InquiryTypeDBModel;
import com.faas.core.base.model.ws.campaign.settings.dto.CampaignTypeWSDTO;
import com.faas.core.base.model.ws.campaign.settings.dto.FlowTypeWSDTO;
import com.faas.core.base.model.ws.campaign.settings.dto.InquiryTypeWSDTO;
import com.faas.core.base.repo.campaign.settings.CampaignTypeRepository;
import com.faas.core.base.repo.campaign.settings.FlowTypeRepository;
import com.faas.core.base.repo.campaign.settings.InquiryTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignSettingsFramework {


    @Autowired
    CampaignTypeRepository campaignTypeRepository;

    @Autowired
    InquiryTypeRepository inquiryTypeRepository;

    @Autowired
    FlowTypeRepository flowTypeRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignTypeWSDTO fillCampaignTypeWSDTO(CampaignTypeDBModel campaignTypeDBModel) {

        CampaignTypeWSDTO campaignTypeWSDTO = new CampaignTypeWSDTO();
        campaignTypeWSDTO.setCampaignType(campaignTypeDBModel);
        return campaignTypeWSDTO;
    }


    public CampaignTypeDBModel createCampaignType(String campaignType) {

        CampaignTypeDBModel campaignTypeDBModel = new CampaignTypeDBModel();
        campaignTypeDBModel.setCampaignType(campaignType);
        campaignTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        campaignTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        campaignTypeDBModel.setStatus(1);

        return campaignTypeRepository.save(campaignTypeDBModel);
    }

    public CampaignTypeDBModel updateCampaignType(long typeId, String campaignType) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeDBModel.get().setCampaignType(campaignType);
            campaignTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            campaignTypeDBModel.get().setStatus(1);

            return campaignTypeRepository.save(campaignTypeDBModel.get());
        }
        return null;
    }


    public CampaignTypeDBModel removeCampaignType(long typeId) {

        Optional<CampaignTypeDBModel> campaignTypeDBModel = campaignTypeRepository.findById(typeId);
        if (campaignTypeDBModel.isPresent()) {
            campaignTypeRepository.delete(campaignTypeDBModel.get());
            return campaignTypeDBModel.get();
        }
        return null;
    }





    public List<InquiryTypeWSDTO> getAllInquiryTypesService(long userId) {

        List<InquiryTypeWSDTO>inquiryTypeWSDTOS = new ArrayList<>();
        List<InquiryTypeDBModel> inquiryTypeDBModels = inquiryTypeRepository.findByStatus(1);
        for (InquiryTypeDBModel inquiryTypeDBModel : inquiryTypeDBModels) {
            inquiryTypeWSDTOS.add(new InquiryTypeWSDTO(inquiryTypeDBModel));
        }
        return inquiryTypeWSDTOS;
    }


    public InquiryTypeWSDTO getInquiryTypeService(long typeId) {

        Optional<InquiryTypeDBModel> inquiryTypeDBModel = inquiryTypeRepository.findById(typeId);
        if (inquiryTypeDBModel.isPresent()) {
            return new InquiryTypeWSDTO(inquiryTypeDBModel.get());
        }
        return null;
    }


    public InquiryTypeWSDTO createInquiryTypeService(String inquiryType) {

        InquiryTypeDBModel inquiryTypeDBModel = new InquiryTypeDBModel();
        inquiryTypeDBModel.setInquiryType(inquiryType);
        inquiryTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        inquiryTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        inquiryTypeDBModel.setStatus(1);

        return new InquiryTypeWSDTO(inquiryTypeRepository.save(inquiryTypeDBModel));
    }


    public InquiryTypeWSDTO updateInquiryTypeService(long typeId,String inquiryType) {

        Optional<InquiryTypeDBModel> inquiryTypeDBModel = inquiryTypeRepository.findById(typeId);
        if (inquiryTypeDBModel.isPresent()){
            inquiryTypeDBModel.get().setInquiryType(inquiryType);
            inquiryTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            inquiryTypeDBModel.get().setStatus(1);

            return new InquiryTypeWSDTO(inquiryTypeRepository.save(inquiryTypeDBModel.get()));
        }
        return null;
    }


    public InquiryTypeWSDTO removeInquiryTypeService(long typeId) {

        Optional<InquiryTypeDBModel> inquiryTypeDBModel = inquiryTypeRepository.findById(typeId);
        if (inquiryTypeDBModel.isPresent()){
            inquiryTypeRepository.delete(inquiryTypeDBModel.get());
            return new InquiryTypeWSDTO(inquiryTypeDBModel.get());
        }
        return null;
    }




    public List<FlowTypeWSDTO> getAllFlowTypesService(long userId) {

        List<FlowTypeWSDTO>flowTypeWSDTOS = new ArrayList<>();
        List<FlowTypeDBModel> flowTypeDBModels = flowTypeRepository.findByStatus(1);
        for (FlowTypeDBModel flowTypeDBModel : flowTypeDBModels) {
            flowTypeWSDTOS.add(new FlowTypeWSDTO(flowTypeDBModel));
        }
        return flowTypeWSDTOS;
    }


    public FlowTypeWSDTO getFlowTypeService(long typeId) {

        Optional<FlowTypeDBModel> flowTypeDBModel = flowTypeRepository.findById(typeId);
        if (flowTypeDBModel.isPresent()) {
            return new FlowTypeWSDTO(flowTypeDBModel.get());
        }
        return null;
    }


    public FlowTypeWSDTO createFlowTypeService(String flowType) {

        FlowTypeDBModel flowTypeDBModel = new FlowTypeDBModel();
        flowTypeDBModel.setFlowType(flowType);
        flowTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        flowTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        flowTypeDBModel.setStatus(1);

        return new FlowTypeWSDTO(flowTypeRepository.save(flowTypeDBModel));
    }


    public FlowTypeWSDTO updateFlowTypeService(long typeId,String flowType) {

        Optional<FlowTypeDBModel> flowTypeDBModel = flowTypeRepository.findById(typeId);
        if (flowTypeDBModel.isPresent()){

            flowTypeDBModel.get().setFlowType(flowType);
            flowTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            flowTypeDBModel.get().setStatus(1);

            return new FlowTypeWSDTO(flowTypeRepository.save(flowTypeDBModel.get()));
        }
        return null;
    }


    public FlowTypeWSDTO removeFlowTypeService(long typeId) {

        Optional<FlowTypeDBModel> flowTypeDBModel = flowTypeRepository.findById(typeId);
        if (flowTypeDBModel.isPresent()){
            flowTypeRepository.delete(flowTypeDBModel.get());
            return new FlowTypeWSDTO(flowTypeDBModel.get());
        }
        return null;
    }



}
