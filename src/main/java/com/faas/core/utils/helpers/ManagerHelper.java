package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ManagerHelper {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignManagerWSDTO> getCampaignManagerWSDTOS(List<CampaignDBModel>campaignModels){

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();
        for (CampaignDBModel campaignModel : campaignModels) {
            CampaignManagerWSDTO campaignManagerWSDTO = fillCampaignManagerWSDTO(campaignModel);
            if (campaignManagerWSDTO != null) {
                campaignManagerWSDTOS.add(campaignManagerWSDTO);
            }
        }
        return campaignManagerWSDTOS;
    }

    public CampaignManagerWSDTO fillCampaignManagerWSDTO(CampaignDBModel campaignDBModel){

        CampaignManagerWSDTO campaignManagerWSDTO = new CampaignManagerWSDTO();
        campaignManagerWSDTO.setCampaign(campaignDBModel);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        processDBModel.ifPresent(campaignManagerWSDTO::setCampaignProcess);

        return campaignManagerWSDTO;
    }


    public OperationManagerWSDTO getOperationManagerWSDTOBySessionModel(Page<SessionDBModel> sessionModelPage){

        OperationManagerWSDTO operationManagerWSDTO = new OperationManagerWSDTO();

        return operationManagerWSDTO;
    }


    public OperationManagerWSDTO getOperationManagerWSDTOByOperationModel(Page<OperationDBModel> operationModelPage){

        OperationManagerWSDTO operationManagerWSDTO = new OperationManagerWSDTO();
        operationManagerWSDTO.setPagination(getOperationManagerPaginationByOperationModel(operationModelPage));
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            OperationWSDTO operationWSDTO = fillManagerOperationWSDTO(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationManagerWSDTO.setOperations(operationWSDTOS);

        return operationManagerWSDTO;
    }


    public OperationWSDTO fillManagerOperationWSDTO(OperationDBModel operationModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationModel);
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(operationModel.getSessionId());
        if (sessionDBModel.isPresent()){
            operationWSDTO.setOperationSession(sessionDBModel.get());
            if (sessionDBModel.get().getCampaignType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionId(sessionDBModel.get().getId());
                if (!operationInquiryDBModels.isEmpty()){
                    operationWSDTO.setOperationInquiry(operationInquiryDBModels.get(0));
                }
            }
            if (sessionDBModel.get().getCampaignType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
                List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionDBModel.get().getId());
                if (!operationFlowDBModels.isEmpty()){
                    operationWSDTO.setOperationFlow(operationFlowDBModels.get(0));
                }
            }
        }
        return operationWSDTO;
    }


    public PaginationWSDTO getOperationManagerPaginationByOperationModel(Page<OperationDBModel> operationModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(operationModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(operationModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(operationModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(operationModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public PaginationWSDTO getOperationManagerPaginationBySessionModel(Page<SessionDBModel> sessionModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionModelPage.getTotalElements());

        return paginationWSDTO;
    }


}
