package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
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
    OperationFlowRepository operationFlowRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

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
    EmailTempRepository emailTempRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

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
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.ACTIVE_OPERATIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.ACTIVE_SESSION))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.READY_OPERATIONS_SUMMARY,String.valueOf(sessionRepository.countByAgentIdAndSessionState(agentId, AppConstant.READY_SESSION))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.TOTAL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return operationSummary;
    }



}
