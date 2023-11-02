package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.client.details.dto.ApiClientNoteWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.flow.content.dto.ApiFlowWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientNoteDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.db.operation.details.scenario.OperationScenarioDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.manager.manual.dto.ManualOperationListWSDTO;
import com.faas.core.base.model.ws.manager.manual.dto.ManualOperationWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.client.session.SessionRepository;
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
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class OperationHelper {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionHelper sessionHelper;

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


    public OperationListWSDTO getOperationListWSDTO(Page<SessionDBModel> sessionModelPage){

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        operationListWSDTO.setPagination(mapOperationSessionPagination(sessionModelPage));
        for (int i=0;sessionModelPage.getContent().size()>i;i++){
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionModelPage.getContent().get(i).getId());
            if (!operationDBModels.isEmpty()){
                operationWSDTOS.add(getOperationWSDTO(operationDBModels.get(0), sessionModelPage.getContent().get(i)));
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        return operationListWSDTO;
    }


    public OperationWSDTO getOperationWSDTO(OperationDBModel operationDBModel, SessionDBModel sessionDBModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);
        operationWSDTO.setOperationSession(sessionDBModel);

        return operationWSDTO;
    }

    public ManualOperationListWSDTO getManualOperationListWSDTO(Page<SessionDBModel>sessionModelPage){

        ManualOperationListWSDTO operationListWSDTO = new ManualOperationListWSDTO();
        operationListWSDTO.setPagination(mapOperationSessionPagination(sessionModelPage));
        List<ManualOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;i<sessionModelPage.getContent().size();i++){
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientId(sessionModelPage.getContent().get(i).getId(), sessionModelPage.getContent().get(i).getClientId());
            if (!operationDBModels.isEmpty()){
                operationWSDTOS.add(getManualOperationWSDTO(sessionModelPage.getContent().get(i),operationDBModels.get(0)));
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);

        return operationListWSDTO;
    }


    public ManualOperationWSDTO getManualOperationWSDTO(SessionDBModel sessionDBModel,OperationDBModel operationDBModel){

        ManualOperationWSDTO manualOperationWSDTO  = new ManualOperationWSDTO();
        manualOperationWSDTO.setOperation(operationDBModel);
        manualOperationWSDTO.setOperationSession(sessionDBModel);

        return manualOperationWSDTO;
    }


    public ApiOperationSessionWSDTO createApiOperationSessionFromOperationModel(Page<OperationDBModel> operationModelPage){

        ApiOperationSessionWSDTO operationSessionWSDTO = new ApiOperationSessionWSDTO();
        operationSessionWSDTO.setPagination(mapOperationPagination(operationModelPage));
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            ApiOperationWSDTO operationWSDTO = mapApiOperationWSDTOFromOperationModel(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationSessionWSDTO.setOperations(operationWSDTOS);

        return operationSessionWSDTO;
    }

    public ApiOperationSessionWSDTO createApiOperationSessionFromSessionModel(Page<SessionDBModel> sessionModelPage){

        ApiOperationSessionWSDTO operationSessionWSDTO = new ApiOperationSessionWSDTO();
        operationSessionWSDTO.setPagination(sessionHelper.createSessionPaginationWSDTO(sessionModelPage));
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;sessionModelPage.getContent().size()>i;i++){
            ApiOperationWSDTO operationWSDTO = mapApiOperationWSDTOFromSessionModel(sessionModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationSessionWSDTO.setOperations(operationWSDTOS);
        return operationSessionWSDTO;
    }



    public ApiSipAccountWSDTO createApiSipCallAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiSipAccountWSDTO sipCallAccountWSDTO = new ApiSipAccountWSDTO();

        return null;
    }


    public ApiWappAccountWSDTO createApiWappCallAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiWappAccountWSDTO wappCallAccountWSDTO = new ApiWappAccountWSDTO();
        List<ProcessWappChannelDBModel> processWappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!processWappChannels.isEmpty()){
            wappCallAccountWSDTO.setCallStatus(processWappChannels.get(0).getCallStatus());
        }

        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (!userDetails.isEmpty() && userDetails.get(0).getWappChannel() != null){
            wappCallAccountWSDTO.setAccountId(userDetails.get(0).getWappChannel().getAccountId());
            wappCallAccountWSDTO.setInstanceKey(userDetails.get(0).getWappChannel().getInstanceKey());
            wappCallAccountWSDTO.setPhoneNumber(userDetails.get(0).getWappChannel().getPhoneNumber());
            wappCallAccountWSDTO.setServerUrl(userDetails.get(0).getWappChannel().getServerUrl());

            if (userDetails.get(0).getWappChannel().getAccountDatas() != null){
                wappCallAccountWSDTO.setAccountDatas(userDetails.get(0).getWappChannel().getAccountDatas());
            }else {
                wappCallAccountWSDTO.setAccountDatas(new ArrayList<>());
            }
            wappCallAccountWSDTO.setcDate(userDetails.get(0).getWappChannel().getcDate());
            wappCallAccountWSDTO.setStatus(userDetails.get(0).getWappChannel().getStatus());
        }
        return wappCallAccountWSDTO;
    }


    public ApiEmailAccountWSDTO createApiEmailAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){
        return null;
    }


    public ApiSmsAccountWSDTO createApiSmsMessageAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiSmsAccountWSDTO smsMessageAccountWSDTO = new ApiSmsAccountWSDTO();
        List<ProcessSmsChannelDBModel> processSmsChannels = processSmsChannelRepository.findByProcessId(processId);
        if (processSmsChannels.size()>0){

        }
        return null;
    }


    public ApiWappAccountWSDTO createApiWappMessageAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        ApiWappAccountWSDTO wappAccountWSDTO = new ApiWappAccountWSDTO();
        List<ProcessWappChannelDBModel> processWappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!processWappChannels.isEmpty()){
        }
        List<UserDetailsDBModel> userDetails = userDetailsRepository.findByUserId(agentId);
        if (!userDetails.isEmpty() && userDetails.get(0).getWappChannel() != null){
            wappAccountWSDTO.setAccountId(userDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setInstanceKey(userDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(userDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(userDetails.get(0).getWappChannel().getServerUrl());

            if (userDetails.get(0).getWappChannel().getAccountDatas() != null){
                wappAccountWSDTO.setAccountDatas(userDetails.get(0).getWappChannel().getAccountDatas());
            }else {
                wappAccountWSDTO.setAccountDatas(new ArrayList<>());
            }
            wappAccountWSDTO.setcDate(userDetails.get(0).getWappChannel().getcDate());
            wappAccountWSDTO.setStatus(userDetails.get(0).getWappChannel().getStatus());
        }
        return wappAccountWSDTO;
    }


    public ApiPushAccountWSDTO createApiPushAccountWSDTO(long agentId, long sessionId, long clientId, String campaignId, String processId){

        return null;
    }

    public ApiOperationScenarioWSDTO getApiOperationScenarioWSDTO(OperationScenarioDBModel operationScenarioDBModel){

        ApiOperationScenarioWSDTO operationScenarioWSDTO = new ApiOperationScenarioWSDTO();
        operationScenarioWSDTO.setOperationScenario(operationScenarioDBModel);
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(operationScenarioDBModel.getProcessId(),operationScenarioDBModel.getScenarioId());
        if (!processScenarioDBModels.isEmpty()){
            operationScenarioWSDTO.setProcessScenario(processScenarioDBModels.get(0));
        }
        return operationScenarioWSDTO;
    }



    public OperationDBModel mapOperationDBModel(SessionDBModel sessionDBModel) {

        if (!operationRepository.existsBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId())){

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
        return null;
    }

    public ApiOperationDetailsWSDTO mapApiOperationDetailsWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel, OperationDBModel operationDBModel, CampaignDBModel campaignDBModel, ProcessDBModel processDBModel) {

        ApiOperationDetailsWSDTO operationDetailsWSDTO = new ApiOperationDetailsWSDTO();
        operationDetailsWSDTO.setOperation(operationDBModel);
        operationDetailsWSDTO.setOperationSession(sessionDBModel);
        if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
            List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
            if (!operationInquiryDBModels.isEmpty()){
                operationDetailsWSDTO.setOperationInquiry(mapApiOperationInquiryWSDTO(sessionDBModel,operationDBModel,operationInquiryDBModels.get(0)));
            }
        }
        if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
            List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
            if (!operationFlowDBModels.isEmpty()){
                operationDetailsWSDTO.setOperationFlow(mapApiOperationFlowWSDTO(sessionDBModel,operationDBModel,operationFlowDBModels.get(0)));
            }
        }
        operationDetailsWSDTO.setOperationClient(mapApiOperationClientWSDTO(clientDBModel));
        operationDetailsWSDTO.setClientOsInts(mapApiClientOsIntWSDTOS(clientDBModel));
        operationDetailsWSDTO.setClientNotes(mapApiOperationNoteWSDTO(clientDBModel));
        operationDetailsWSDTO.setOperationActivities(mapApiOperationActivities(operationDBModel));
        operationDetailsWSDTO.setOperationCampaign(mapApiOperationCampaignWSDTO(campaignDBModel,processDBModel));
        operationDetailsWSDTO.setOperationChannel(mapApiOperationChannelWSDTO(sessionDBModel,clientDBModel));
        operationDetailsWSDTO.setOperationScenarios(mapApiOperationScenarioWSDTOS(sessionDBModel.getId(),sessionDBModel.getProcessId()));

        return operationDetailsWSDTO;
    }

    public ApiOperationClientWSDTO mapApiOperationClientWSDTO(ClientDBModel clientDBModel) {

        ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();
        operationClientWSDTO.setClient(clientDBModel);
        operationClientWSDTO.setClientDatas(clientDataRepository.findByClientId(clientDBModel.getId()));
        operationClientWSDTO.setClientAddresses(clientAddressRepository.findByClientId(clientDBModel.getId()));
        operationClientWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientDBModel.getId()));
        operationClientWSDTO.setClientEmails(clientEmailRepository.findByClientId(clientDBModel.getId()));

        return operationClientWSDTO;
    }

    public ApiInquiryWSDTO mapApiOperationInquiryWSDTO(SessionDBModel sessionDBModel,OperationDBModel operationDBModel,OperationInquiryDBModel operationInquiryDBModel) {

        ApiInquiryWSDTO operationInquiryWSDTO = new ApiInquiryWSDTO();
        operationInquiryWSDTO.setOperationSession(sessionDBModel);
        operationInquiryWSDTO.setOperation(operationDBModel);
        operationInquiryWSDTO.setOperationInquiry(operationInquiryDBModel);

        return operationInquiryWSDTO;
    }

    public ApiFlowWSDTO mapApiOperationFlowWSDTO(SessionDBModel sessionDBModel,OperationDBModel operationDBModel,OperationFlowDBModel operationFlowDBModel) {

        ApiFlowWSDTO operationFlowWSDTO = new ApiFlowWSDTO();
        operationFlowWSDTO.setOperationSession(sessionDBModel);
        operationFlowWSDTO.setOperation(operationDBModel);
        operationFlowWSDTO.setOperationFlow(operationFlowDBModel);

        return operationFlowWSDTO;
    }

    public List<ApiClientOsIntWSDTO> mapApiClientOsIntWSDTOS(ClientDBModel clientDBModel) {

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = new ArrayList<>();
        return clientOsIntWSDTOS;
    }


    public List<ApiClientNoteWSDTO> mapApiOperationNoteWSDTO(ClientDBModel clientDBModel) {

        List<ApiClientNoteWSDTO> clientNoteWSDTOS = new ArrayList<>();
        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByClientId(clientDBModel.getId());
        for (ClientNoteDBModel clientNoteDBModel : clientNoteDBModels) {
            clientNoteWSDTOS.add(new ApiClientNoteWSDTO(clientNoteDBModel));
        }
        return clientNoteWSDTOS;
    }


    public ApiOperationCampaignWSDTO mapApiOperationCampaignWSDTO(CampaignDBModel campaignDBModel, ProcessDBModel processDBModel) {

        ApiOperationCampaignWSDTO operationCampaignWSDTO = new ApiOperationCampaignWSDTO();
        operationCampaignWSDTO.setOperationCampaign(campaignDBModel);
        operationCampaignWSDTO.setOperationProcess(processDBModel);
        return operationCampaignWSDTO;
    }


    public List<ApiOperationActivityWSDTO> mapApiOperationActivities(OperationDBModel operationDBModel) {

        if (operationDBModel != null && operationDBModel.getActivities() != null) {
            List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();
            for (int i = 0; i < operationDBModel.getActivities().size(); i++) {
                operationActivityWSDTOS.add(new ApiOperationActivityWSDTO(operationDBModel.getActivities().get(i)));
            }
            return operationActivityWSDTOS;
        }
        return null;
    }


    public List<ApiOperationScenarioWSDTO> mapApiOperationScenarioWSDTOS(long sessionId, String processId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();
        List<OperationScenarioDBModel> operationScenarioDBModels = operationScenarioRepository.findBySessionIdAndProcessId(sessionId, processId);
        for (OperationScenarioDBModel operationScenarioDBModel : operationScenarioDBModels) {
            ApiOperationScenarioWSDTO operationScenarioWSDTO = new ApiOperationScenarioWSDTO();
            operationScenarioWSDTO.setOperationScenario(operationScenarioDBModel);
            operationScenarioWSDTOS.add(operationScenarioWSDTO);
        }
        return operationScenarioWSDTOS;
    }






    public ApiOperationChannelWSDTO mapApiOperationChannelWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel) {

        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientDBModel.getId());
        ApiOperationChannelWSDTO operationChannelWSDTO = new ApiOperationChannelWSDTO();
        operationChannelWSDTO.setOperationSipCall(channelHelper.mapApiOperationSipCallWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationWappCall(channelHelper.mapApiOperationWappCallWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationSmsMessage(channelHelper.mapApiOperationSmsMessageWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationWappMessage(channelHelper.mapApiOperationWappMessageWSDTO(sessionDBModel,clientPhoneDBModels));
        operationChannelWSDTO.setOperationPushMessage(channelHelper.mapApiOperationPushMessageWSDTO(sessionDBModel));
        operationChannelWSDTO.setOperationEmail(channelHelper.mapApiOperationEmailWSDTO(sessionDBModel));

        return operationChannelWSDTO;
    }


    public ApiOperationWSDTO mapApiOperationWSDTOFromOperationModel(OperationDBModel operationDBModel) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(operationDBModel.getSessionId());
        if (sessionDBModel.isPresent()){
            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
            operationWSDTO.setOperation(operationDBModel);
            operationWSDTO.setOperationSession(sessionDBModel.get());
            if (sessionDBModel.get().getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(),sessionDBModel.get().getClientId());
                if (!operationInquiryDBModels.isEmpty()) {
                    operationWSDTO.setOperationInquiry(operationInquiryDBModels.get(0));
                }
            }
            if (sessionDBModel.get().getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
                List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(),sessionDBModel.get().getClientId());
                if (!operationFlowDBModels.isEmpty()) {
                    operationWSDTO.setOperationFlow(operationFlowDBModels.get(0));
                }
            }
            return operationWSDTO;
        }
        return null;
    }


    public ApiOperationWSDTO mapApiOperationWSDTOFromSessionModel(SessionDBModel sessionDBModel) {

        List<OperationDBModel>operationDBModels = operationRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
        if (!operationDBModels.isEmpty()){

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
            operationWSDTO.setOperation(operationDBModels.get(0));
            operationWSDTO.setOperationSession(sessionDBModel);

            if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
                if (!operationInquiryDBModels.isEmpty()) {
                    operationWSDTO.setOperationInquiry(operationInquiryDBModels.get(0));
                }
            }
            if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
                List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId());
                if (!operationFlowDBModels.isEmpty()) {
                    operationWSDTO.setOperationFlow(operationFlowDBModels.get(0));
                }
            }
            return operationWSDTO;
        }
        return null;
    }


    public PaginationWSDTO mapOperationPagination(Page<OperationDBModel> operationDBModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(operationDBModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(operationDBModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(operationDBModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(operationDBModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public PaginationWSDTO mapOperationSessionPagination(Page<SessionDBModel> sessionDBModelPage){

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
