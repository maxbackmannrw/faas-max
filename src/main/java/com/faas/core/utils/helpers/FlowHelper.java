package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.client.flow.dto.FlowSessionWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.client.flow.ClientFlowRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlowHelper {

    @Autowired
    ClientFlowRepository clientFlowRepository;

    @Autowired
    AppUtils appUtils;


    public ClientFlowDBModel mapClientFlowDBModel(SessionDBModel sessionDBModel){

        ClientFlowDBModel clientFlowDBModel = new ClientFlowDBModel();
        clientFlowDBModel.setSessionId(sessionDBModel.getId());
        clientFlowDBModel.setClientId(sessionDBModel.getClientId());
        clientFlowDBModel.setCampaignId(sessionDBModel.getCampaignId());
        clientFlowDBModel.setProcessId(sessionDBModel.getProcessId());
        clientFlowDBModel.setFlowState(AppConstant.NEW_FLOW);
        clientFlowDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientFlowDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientFlowDBModel.setStatus(1);

        return clientFlowDBModel;
    }


    public List<FlowSessionWSDTO> createFlowSessionWSDTOS(List<SessionDBModel> sessionDBModels){

        List<FlowSessionWSDTO> flowSessionWSDTOS = new ArrayList<>();
        for (SessionDBModel sessionDBModel : sessionDBModels) {
            flowSessionWSDTOS.add(createFlowSessionWSDTO(sessionDBModel));
        }
        return flowSessionWSDTOS;
    }


    public FlowSessionWSDTO createFlowSessionWSDTO(SessionDBModel sessionDBModel){

        FlowSessionWSDTO flowSessionWSDTO = new FlowSessionWSDTO();
        flowSessionWSDTO.setClientSession(sessionDBModel);
        List<ClientFlowDBModel> clientFlowDBModels = clientFlowRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        if (!clientFlowDBModels.isEmpty()){
            flowSessionWSDTO.setClientFlow(clientFlowDBModels.get(0));
        }
        return flowSessionWSDTO;
    }


    public List<ClientFlowWSDTO> createFlowWSDTOS(List<ClientFlowDBModel> clientFlowDBModels){

        List<ClientFlowWSDTO> clientFlowWSDTOS = new ArrayList<>();
        for (ClientFlowDBModel clientFlowDBModel : clientFlowDBModels) {
            ClientFlowWSDTO clientFlowWSDTO = new ClientFlowWSDTO();
            clientFlowWSDTO.setClientFlow(clientFlowDBModel);
            clientFlowWSDTOS.add(clientFlowWSDTO);
        }
        return clientFlowWSDTOS;
    }



    public PaginationWSDTO createFlowPagination(Page<ClientFlowDBModel> flowDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(flowDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(flowDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(flowDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(flowDBModelPage.getTotalElements());

        return paginationWSDTO;
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
        sessionDBModel.setSessionState(AppConstant.NEW_SESSION);
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
        operationDBModel.setOperationState(AppConstant.NEW_OPERATION);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationDBModel.setStatus(1);

        return operationDBModel;
    }



}
