package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManualHelper {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    OperationEmailMessageRepository operationEmailMessageRepository;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public OperationListWSDTO getManualOperationListWSDTO(Page<SessionDBModel> sessionModelPage){

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;i<sessionModelPage.getContent().size();i++){
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientId(sessionModelPage.getContent().get(i).getId(), sessionModelPage.getContent().get(i).getClientId());
            if (!operationDBModels.isEmpty()){
                operationWSDTOS.add(getManualOperationWSDTO(sessionModelPage.getContent().get(i),operationDBModels.get(0)));
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(mapManualOperationSessionPagination(sessionModelPage));

        return operationListWSDTO;
    }


    public OperationWSDTO getManualOperationWSDTO(SessionDBModel sessionDBModel,OperationDBModel operationDBModel){

        OperationWSDTO manualOperationWSDTO  = new OperationWSDTO();
        manualOperationWSDTO.setOperation(operationDBModel);
        manualOperationWSDTO.setOperationSession(sessionDBModel);
        return manualOperationWSDTO;
    }


    public PaginationWSDTO mapManualOperationSessionPagination(Page<SessionDBModel> sessionDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionDBModelPage.getTotalElements());

        return paginationWSDTO;
    }

    public List<ApiSummaryWSDTO> getApiOperationSummary(long agentId){

        List<ApiSummaryWSDTO> operationSummary = new ArrayList<>();
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_OPERATIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.READY_OPERATIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return operationSummary;
    }



}
