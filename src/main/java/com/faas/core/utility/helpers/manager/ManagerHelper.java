package com.faas.core.utility.helpers.manager;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ManagerHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationSmsRepository operationSmsRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

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
        Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.getProcessId());
        processDBModel.ifPresent(campaignManagerWSDTO::setCampaignProcess);

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
        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(operationModel.getSessionId());
        if (sessionDBModel.isPresent()){
            operationWSDTO.setOperationSession(sessionDBModel.get());
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



    public OperationManagerWSDTO getOperationManagerWSDTOBySessionModel(Page<SessionDBModel> sessionModelPage){

        OperationManagerWSDTO operationManagerWSDTO = new OperationManagerWSDTO();
        operationManagerWSDTO.setPagination(getOperationManagerPaginationBySessionModel(sessionModelPage));
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;sessionModelPage.getContent().size()>i;i++){
            OperationWSDTO operationWSDTO = fillManagerOperationWSDTOBySessionModel(sessionModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationManagerWSDTO.setOperations(operationWSDTOS);
        return operationManagerWSDTO;
    }

    public OperationWSDTO fillManagerOperationWSDTOBySessionModel(SessionDBModel sessionDBModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperationSession(sessionDBModel);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionDBModel.getId());
        if (!operationDBModels.isEmpty()){
            operationWSDTO.setOperation(operationDBModels.get(0));
        }
        return operationWSDTO;
    }

    public PaginationWSDTO getOperationManagerPaginationBySessionModel(Page<SessionDBModel> sessionModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionModelPage.getTotalElements());

        return paginationWSDTO;
    }

    public void removeOperationManager(SessionDBModel sessionDBModel){

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.getClientId());
            if (clientDBModel.isPresent()) {
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            sessionRepository.delete(sessionDBModel);
            operationRepository.deleteAll(operationRepository.findBySessionId(sessionDBModel.getId()));
            operationEmailRepository.deleteAll(operationEmailRepository.findBySessionId(sessionDBModel.getId()));
            operationPushRepository.deleteAll(operationPushRepository.findBySessionId(sessionDBModel.getId()));
            operationSipCallRepository.deleteAll(operationSipCallRepository.findBySessionId(sessionDBModel.getId()));
            operationSmsRepository.deleteAll(operationSmsRepository.findBySessionId(sessionDBModel.getId()));
            operationWappCallRepository.deleteAll(operationWappCallRepository.findBySessionId(sessionDBModel.getId()));
            operationWappMessageRepository.deleteAll(operationWappMessageRepository.findBySessionId(sessionDBModel.getId()));

        }


}
