package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.details.content.dto.OperationFlowSessionWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutomaticHelper {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    AppUtils appUtils;


    public OperationListWSDTO getAutomaticOperationListWSDTO(Page<SessionDBModel>sessionModelPage){

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;sessionModelPage.getContent().size()>i;i++){
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionModelPage.getContent().get(i).getId());
            List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionModelPage.getContent().get(i).getId());
            if (!operationDBModels.isEmpty() && !operationFlowDBModels.isEmpty()){
                operationWSDTOS.add(getAutomaticOperationWSDTO(sessionModelPage.getContent().get(i), operationDBModels.get(0),operationFlowDBModels.get(0)));
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(createFlowSessionPagination(sessionModelPage));

        return operationListWSDTO;
    }

    public OperationWSDTO getAutomaticOperationWSDTO(SessionDBModel sessionDBModel,OperationDBModel operationDBModel,OperationFlowDBModel operationFlowDBModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);
        operationWSDTO.setOperationSession(sessionDBModel);
        operationWSDTO.setOperationFlow(operationFlowDBModel);

        return operationWSDTO;
    }


    public OperationFlowDBModel mapOperationFlowDBModel(SessionDBModel sessionDBModel){

        OperationFlowDBModel operationFlowDBModel = new OperationFlowDBModel();
        operationFlowDBModel.setSessionId(sessionDBModel.getId());
        operationFlowDBModel.setClientId(sessionDBModel.getClientId());
        operationFlowDBModel.setAgentId(sessionDBModel.getAgentId());
        operationFlowDBModel.setCampaignId(sessionDBModel.getCampaignId());
        operationFlowDBModel.setProcessId(sessionDBModel.getProcessId());
        operationFlowDBModel.setFlowState(AppConstant.NEW_FLOW);
        operationFlowDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationFlowDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationFlowDBModel.setStatus(1);

        return operationFlowDBModel;
    }


    public List<OperationFlowSessionWSDTO> createFlowSessionWSDTOS(List<SessionDBModel> sessionDBModels){

        List<OperationFlowSessionWSDTO> operationFlowSessionWSDTOS = new ArrayList<>();
        for (SessionDBModel sessionDBModel : sessionDBModels) {
            operationFlowSessionWSDTOS.add(createFlowSessionWSDTO(sessionDBModel));
        }
        return operationFlowSessionWSDTOS;
    }


    public OperationFlowSessionWSDTO createFlowSessionWSDTO(SessionDBModel sessionDBModel){

        OperationFlowSessionWSDTO operationFlowSessionWSDTO = new OperationFlowSessionWSDTO();
        operationFlowSessionWSDTO.setClientSession(sessionDBModel);
        List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        if (!operationFlowDBModels.isEmpty()){
            operationFlowSessionWSDTO.setClientFlow(operationFlowDBModels.get(0));
        }
        return operationFlowSessionWSDTO;
    }


    public PaginationWSDTO createFlowSessionPagination(Page<SessionDBModel> sessionDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public SessionDBModel mapFlowSession(ClientDBModel clientDBModel, UserDBModel agentDBModel, CampaignDBModel campaignDBModel) {

        SessionDBModel sessionDBModel = new SessionDBModel();

        sessionDBModel.setSessionUUID(appUtils.generateUUID());
        sessionDBModel.setClientId(clientDBModel.getId());
        sessionDBModel.setClientName(clientDBModel.getClientName());
        sessionDBModel.setNationalId(clientDBModel.getNationalId());
        sessionDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        sessionDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        sessionDBModel.setClientCity(clientDBModel.getClientCity());
        sessionDBModel.setClientCountry(clientDBModel.getClientCountry());
        sessionDBModel.setClientType(clientDBModel.getClientType());
        sessionDBModel.setCampaignId(campaignDBModel.getId());
        sessionDBModel.setCampaign(campaignDBModel.getCampaign());
        sessionDBModel.setCampaignType(campaignDBModel.getCampaignType());
        sessionDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        sessionDBModel.setProcessId(campaignDBModel.getProcessId());
        sessionDBModel.setProcess(campaignDBModel.getProcess());
        sessionDBModel.setProcessType(campaignDBModel.getProcessType());
        sessionDBModel.setProcessCategory(campaignDBModel.getProcessCategory());
        sessionDBModel.setAgentId(agentDBModel.getId());
        sessionDBModel.setAgentName(agentDBModel.getUserName());
        sessionDBModel.setSessionType(campaignDBModel.getCampaignCategory());
        sessionDBModel.setSessionState(AppConstant.READY_SESSION);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setStatus(1);

        return sessionDBModel;
    }


    public OperationDBModel mapFlowOperation(SessionDBModel sessionDBModel) {

        OperationDBModel operationDBModel = new OperationDBModel();
        operationDBModel.setSessionId(sessionDBModel.getId());
        operationDBModel.setSessionUUID(sessionDBModel.getSessionUUID());
        operationDBModel.setClientId(sessionDBModel.getClientId());
        operationDBModel.setAgentId(sessionDBModel.getAgentId());
        operationDBModel.setCampaignId(sessionDBModel.getCampaignId());
        operationDBModel.setProcessId(sessionDBModel.getProcessId());
        operationDBModel.setActivities(new ArrayList<>());
        operationDBModel.setOperationState(AppConstant.READY_OPERATION);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationDBModel.setStatus(1);

        return operationDBModel;
    }



}
