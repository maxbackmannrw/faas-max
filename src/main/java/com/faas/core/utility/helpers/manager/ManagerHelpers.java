package com.faas.core.utility.helpers.manager;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerHelpers {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public MainManagerContentWSDTO getMainManagerContentWSDTO(long userId, String category, int reqPage, int reqSize){

        MainManagerContentWSDTO mainManagerContentWSDTO = new MainManagerContentWSDTO();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(category);
        if (!campaignDBModels.isEmpty()){
            List<CampaignManagerWSDTO> campaignManagerWSDTOS = getCampaignManagerWSDTOS(campaignDBModels);
            if (campaignManagerWSDTOS != null){
                mainManagerContentWSDTO.setCampaignManagers(campaignManagerWSDTOS);
            }
        }
        OperationManagerWSDTO readyOperationManagerWSDTO = getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationStateAndOperationType(AppConstant.READY_STATE,category, PageRequest.of(reqPage,reqSize)));
        if (readyOperationManagerWSDTO != null){
            mainManagerContentWSDTO.setReadyOperation(readyOperationManagerWSDTO);
        }
        OperationManagerWSDTO activeOperationManagerWSDTO = getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationStateAndOperationType(AppConstant.ACTIVE_STATE,category, PageRequest.of(reqPage,reqSize)));
        if (activeOperationManagerWSDTO != null){
            mainManagerContentWSDTO.setActiveOperation(activeOperationManagerWSDTO);
        }
        return mainManagerContentWSDTO;
    }


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

        return campaignManagerWSDTO;
    }


    public OperationManagerWSDTO getOperationManagerWSDTOByOperationModel(Page<OperationDBModel> operationModelPage){

        OperationManagerWSDTO operationManagerWSDTO = new OperationManagerWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            OperationWSDTO operationWSDTO = fillManagerOperationWSDTOByOperationModel(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationManagerWSDTO.setOperations(operationWSDTOS);
        operationManagerWSDTO.setPagination(getOperationManagerPaginationByOperationModel(operationModelPage));
        return operationManagerWSDTO;
    }

    public OperationWSDTO fillManagerOperationWSDTOByOperationModel(OperationDBModel operationModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationModel);
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







}
