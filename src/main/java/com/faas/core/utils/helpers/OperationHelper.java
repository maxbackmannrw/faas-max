package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationFlowDAO;
import com.faas.core.base.model.db.operation.content.dao.OperationInquiryDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.content.ProcessRepository;
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
import java.util.Optional;

@Component
public class OperationHelper {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

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
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    AppUtils appUtils;


    public SessionDBModel createSessionDBModel(ClientDBModel clientDBModel, UserDBModel agentDBModel,CampaignDBModel campaignDBModel  ) {

        SessionDBModel sessionDBModel = new SessionDBModel();
        sessionDBModel.setOperationId(AppConstant.NO_VALUE);
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
        sessionDBModel.setSessionState(AppConstant.READY_STATE);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sessionDBModel.setStatus(1);

        return sessionDBModel;
    }

    public OperationDBModel createOperationDBModel(SessionDBModel sessionDBModel) {

        if (!operationRepository.existsBySessionIdAndClientId(sessionDBModel.getId(),sessionDBModel.getClientId())){

            OperationDBModel operationDBModel = new OperationDBModel();
            operationDBModel.setSessionId(sessionDBModel.getId());
            operationDBModel.setClientId(sessionDBModel.getClientId());
            operationDBModel.setAgentId(sessionDBModel.getAgentId());
            operationDBModel.setCampaignId(sessionDBModel.getCampaignId());
            operationDBModel.setProcessId(sessionDBModel.getProcessId());

            if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.MANUAL_SESSION)){
                operationDBModel.setOperationInquiry(null);
                operationDBModel.setOperationInquiryState(AppConstant.NO_STATE);
                operationDBModel.setOperationFlow(null);
                operationDBModel.setOperationFlowState(AppConstant.NO_STATE);
            }

            if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_SESSION)){
                operationDBModel.setOperationInquiry(createOperationInquiryDAO(sessionDBModel));
                operationDBModel.setOperationInquiryState(AppConstant.NEW_STATE);
                operationDBModel.setOperationFlow(null);
                operationDBModel.setOperationFlowState(AppConstant.NO_STATE);
            }

            if (sessionDBModel.getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_SESSION)){
                operationDBModel.setOperationInquiry(null);
                operationDBModel.setOperationInquiryState(AppConstant.NO_STATE);
                operationDBModel.setOperationFlow(createOperationFlowDAO(sessionDBModel));
                operationDBModel.setOperationFlowState(AppConstant.NEW_STATE);
            }

            operationDBModel.setOperationScenarios(new ArrayList<>());
            operationDBModel.setOperationActivities(new ArrayList<>());
            operationDBModel.setOperationDatas(new ArrayList<>());
            operationDBModel.setOperationType(sessionDBModel.getSessionType());
            operationDBModel.setOperationState(sessionDBModel.getSessionState());
            operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationDBModel.setStatus(1);

            return operationDBModel;
        }
        return null;
    }

    public OperationInquiryDAO createOperationInquiryDAO(SessionDBModel sessionDBModel) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (processDBModel.isPresent()){

            OperationInquiryDAO operationInquiryDAO = new OperationInquiryDAO();
            operationInquiryDAO.setId(appUtils.generateUUID());
            operationInquiryDAO.setOperationInquiry(processDBModel.get().getProcessInquiry().getProcessInquiry());
            operationInquiryDAO.setOperationInquiryDatas(new ArrayList<>());
            operationInquiryDAO.setuDate(appUtils.getCurrentTimeStamp());
            operationInquiryDAO.setcDate(appUtils.getCurrentTimeStamp());
            operationInquiryDAO.setStatus(1);

            return operationInquiryDAO;
        }
        return null;
    }

    public OperationFlowDAO createOperationFlowDAO(SessionDBModel sessionDBModel) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (processDBModel.isPresent()){

            OperationFlowDAO operationFlowDAO = new OperationFlowDAO();
            operationFlowDAO.setId(appUtils.generateUUID());
            operationFlowDAO.setOperationFlow(processDBModel.get().getProcessFlow().getProcessFlow());
            operationFlowDAO.setOperationFlowDatas(new ArrayList<>());
            operationFlowDAO.setuDate(appUtils.getCurrentTimeStamp());
            operationFlowDAO.setcDate(appUtils.getCurrentTimeStamp());
            operationFlowDAO.setStatus(1);

            return operationFlowDAO;
        }
        return null;
    }


    public OperationWSDTO getOperationWSDTO(OperationDBModel operationDBModel, SessionDBModel sessionDBModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);
        operationWSDTO.setOperationSession(sessionDBModel);

        return operationWSDTO;
    }

    public OperationListWSDTO getOperationListWSDTO(Page<SessionDBModel> sessionModelPage){

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        operationListWSDTO.setPagination(mapSessionModelPagination(sessionModelPage));
        for (int i=0;sessionModelPage.getContent().size()>i;i++){
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionModelPage.getContent().get(i).getId());
            if (!operationDBModels.isEmpty()){
                operationWSDTOS.add(getOperationWSDTO(operationDBModels.get(0), sessionModelPage.getContent().get(i)));
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);

        return operationListWSDTO;
    }

    public List<OperationWSDTO> getOperationWSDTOSBySessionModels(List<SessionDBModel> sessionDBModels){

        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (SessionDBModel sessionDBModel : sessionDBModels) {
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionDBModel.getId());
            if (!operationDBModels.isEmpty()) {
                operationWSDTOS.add(getOperationWSDTO(operationDBModels.get(0), sessionDBModel));
            }
        }
        return operationWSDTOS;
    }

    public void removeOperationHelper(long sessionId){

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()) {

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.get().getClientId());
            if (clientDBModel.isPresent()) {
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }

            sessionRepository.delete(sessionDBModel.get());
            operationRepository.deleteAll(operationRepository.findBySessionId(sessionId));
            operationEmailMessageRepository.deleteAll(operationEmailMessageRepository.findBySessionId(sessionId));
            operationPushMessageRepository.deleteAll(operationPushMessageRepository.findBySessionId(sessionId));
            operationSipCallRepository.deleteAll(operationSipCallRepository.findBySessionId(sessionId));
            operationSmsMessageRepository.deleteAll(operationSmsMessageRepository.findBySessionId(sessionId));
            operationWappCallRepository.deleteAll(operationWappCallRepository.findBySessionId(sessionId));
            operationWappMessageRepository.deleteAll(operationWappMessageRepository.findBySessionId(sessionId));
        }
    }



    public ApiOperationWSDTO getApiOperationWSDTO(OperationDBModel operationDBModel) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(operationDBModel.getSessionId());
        if (sessionDBModel.isPresent()){
            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
            operationWSDTO.setOperation(operationDBModel);
            operationWSDTO.setOperationSession(sessionDBModel.get());

            return operationWSDTO;
        }
        return null;
    }


    public List<ApiSummaryWSDTO> apiGetOperationSummaryHelper(long agentId) {

        List<ApiSummaryWSDTO> operationSummary = new ArrayList<>();
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.READY_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return operationSummary;
    }


    public ApiOperationWSDTO startManualOperationHelper(SessionDBModel sessionDBModel,OperationDBModel operationDBModel){

        sessionDBModel.setSessionState(AppConstant.ACTIVE_STATE);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel = sessionRepository.save(sessionDBModel);

        operationDBModel.setOperationState(AppConstant.ACTIVE_STATE);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationDBModel = operationRepository.save(operationDBModel);

        return new ApiOperationWSDTO(operationDBModel,sessionDBModel);
    }


    public ApiOperationWSDTO startInquiryOperationHelper(SessionDBModel sessionDBModel,OperationDBModel operationDBModel){

        sessionDBModel.setSessionState(AppConstant.ACTIVE_STATE);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel = sessionRepository.save(sessionDBModel);

        operationDBModel.setOperationState(AppConstant.ACTIVE_STATE);
        operationDBModel.setOperationInquiryState(AppConstant.ACTIVE_STATE);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationDBModel = operationRepository.save(operationDBModel);

        return new ApiOperationWSDTO(operationDBModel,sessionDBModel);
    }

    public ApiOperationWSDTO startAutomaticOperationHelper(SessionDBModel sessionDBModel,OperationDBModel operationDBModel){

        sessionDBModel.setSessionState(AppConstant.ACTIVE_STATE);
        sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sessionDBModel = sessionRepository.save(sessionDBModel);

        operationDBModel.setOperationState(AppConstant.ACTIVE_STATE);
        operationDBModel.setOperationFlowState(AppConstant.ACTIVE_STATE);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationDBModel = operationRepository.save(operationDBModel);

        return new ApiOperationWSDTO(operationDBModel,sessionDBModel);
    }



    public ApiOperationValidateWSDTO operationValidateHelper(UserDBModel agentDBModel,OperationDBModel operationDBModel){

        ApiOperationValidateWSDTO operationValidateWSDTO = new ApiOperationValidateWSDTO();
        operationValidateWSDTO.setAgent(agentDBModel);
        operationValidateWSDTO.setOperation(operationDBModel);
        operationValidateWSDTO.setOperationCount(operationRepository.countByAgentIdAndOperationState(agentDBModel.getId(),AppConstant.ACTIVE_STATE));

        if (agentDBModel.getUserRole().equalsIgnoreCase(AppConstant.BASIC_AGENT)){
            operationValidateWSDTO.setOperationLimit(AppConstant.BASIC_AGENT_OPERATION_LIMIT);
        }
        if (agentDBModel.getUserRole().equalsIgnoreCase(AppConstant.SUPER_AGENT)){
            operationValidateWSDTO.setOperationLimit(AppConstant.SUPER_AGENT_OPERATION_LIMIT);
        }
        return operationValidateWSDTO;
    }



    public ApiOperationListWSDTO getApiOperationListWSDTO(Page<OperationDBModel> operationModelPage){

        ApiOperationListWSDTO operationListWSDTO = new ApiOperationListWSDTO();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            ApiOperationWSDTO operationWSDTO = getApiOperationWSDTO(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(mapOperationPagination(operationModelPage));

        return operationListWSDTO;
    }


    public ApiOperationDetailsWSDTO getApiOperationDetailsWSDTO(OperationDBModel operationDBModel) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(operationDBModel.getSessionId(),operationDBModel.getAgentId());
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(operationDBModel.getClientId());
        List<ClientDetailsDBModel> clientDetails = clientDetailsRepository.findByClientId(operationDBModel.getClientId());
        if (!sessionDBModels.isEmpty() && clientDBModel.isPresent() && !clientDetails.isEmpty()) {

            ApiOperationDetailsWSDTO operationDetailsWSDTO = new ApiOperationDetailsWSDTO();
            operationDetailsWSDTO.setOperation(operationDBModel);
            operationDetailsWSDTO.setOperationSession(sessionDBModels.get(0));
            operationDetailsWSDTO.setOperationClient(getApiOperationClientWSDTO(clientDBModel.get()));
            operationDetailsWSDTO.setOperationCampaign(getApiOperationCampaignWSDTO(operationDBModel.getCampaignId(),operationDBModel.getProcessId()));
            operationDetailsWSDTO.setOperationCallChannel(getApiOperationCallChannelWSDTO(operationDBModel,clientDetails.get(0)));
            operationDetailsWSDTO.setOperationMessageChannel(getApiOperationMessageChannelWSDTO(operationDBModel,clientDetails.get(0)));

            return operationDetailsWSDTO;
        }
        return null;
    }

    public ApiOperationClientWSDTO getApiOperationClientWSDTO(ClientDBModel clientDBModel) {

        ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();
        operationClientWSDTO.setClient(clientDBModel);
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientDBModel.getId());
        if (!clientDetailsDBModels.isEmpty()){
            operationClientWSDTO.setClientDetails(clientDetailsDBModels.get(0));
        }
        return operationClientWSDTO;
    }

    public ApiOperationCampaignWSDTO getApiOperationCampaignWSDTO(String campaignId,String processId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (campaignDBModel.isPresent() && processDBModel.isPresent()){

            ApiOperationCampaignWSDTO operationCampaignWSDTO = new ApiOperationCampaignWSDTO();
            operationCampaignWSDTO.setOperationCampaign(campaignDBModel.get());
            operationCampaignWSDTO.setOperationProcess(processDBModel.get());
            operationCampaignWSDTO.setProcessScenarios(processScenarioRepository.findByProcessId(processId));

            return operationCampaignWSDTO;
        }
        return null;
    }


    public ApiOperationCallChannelWSDTO getApiOperationCallChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = new ApiOperationCallChannelWSDTO();
        operationCallChannelWSDTO.setOperationSipChannel(getApiOperationSipChannelWSDTO(operationDBModel,clientDetails));
        operationCallChannelWSDTO.setOperationWappCallChannel(getApiOperationWappCallChannelWSDTO(operationDBModel,clientDetails));

        return operationCallChannelWSDTO;
    }

    public ApiOperationSipChannelWSDTO getApiOperationSipChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiSipAccountWSDTO sipAccountWSDTO = channelHelper.getApiSipAccountWSDTO(operationDBModel.getAgentId(),operationDBModel.getProcessId());
        if (sipAccountWSDTO != null && clientDetails.getClientPhones() != null){

            ApiOperationSipChannelWSDTO sipChannelWSDTO = new ApiOperationSipChannelWSDTO();
            sipChannelWSDTO.setSipAccount(sipAccountWSDTO);
            sipChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            List<OperationSipCallDBModel> sipCallDBModels = operationSipCallRepository.findByOperationId(operationDBModel.getId());
            for (OperationSipCallDBModel sipCallDBModel : sipCallDBModels) {
                if (sipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)) {
                    sipChannelWSDTO.setActiveSipCall(sipCallDBModel);
                }
            }
            sipChannelWSDTO.setRecentSipCalls(sipCallDBModels);
            return sipChannelWSDTO;
        }
        return null;
    }

    public ApiOperationWappCallChannelWSDTO getApiOperationWappCallChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiWappCallAccountWSDTO wappAccountWSDTO = channelHelper.getApiWappCallAccountWSDTO(operationDBModel.getAgentId(),operationDBModel.getProcessId());
        if (wappAccountWSDTO != null && clientDetails.getClientPhones() != null){

            ApiOperationWappCallChannelWSDTO wappCallChannelWSDTO = new ApiOperationWappCallChannelWSDTO();
            wappCallChannelWSDTO.setWappAccount(wappAccountWSDTO);
            wappCallChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            List<OperationWappCallDBModel> wappCallDBModels = operationWappCallRepository.findByOperationId(operationDBModel.getId());
            for (OperationWappCallDBModel wappCallDBModel : wappCallDBModels) {
                if (wappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)) {
                    wappCallChannelWSDTO.setActiveWappCall(wappCallDBModel);
                }
            }
            wappCallChannelWSDTO.setRecentWappCalls(wappCallDBModels);
            return wappCallChannelWSDTO;
        }
        return null;
    }



    public ApiOperationMessageChannelWSDTO getApiOperationMessageChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationMessageChannelWSDTO operationMessageChannelWSDTO = new ApiOperationMessageChannelWSDTO();
        operationMessageChannelWSDTO.setOperationSmsChannel(getApiOperationSmsChannelWSDTO(operationDBModel,clientDetails));
        operationMessageChannelWSDTO.setOperationWappMessageChannel(getApiOperationWappMessageChannelWSDTO(operationDBModel,clientDetails));
        operationMessageChannelWSDTO.setOperationEmailChannel(getApiOperationEmailChannelWSDTO(operationDBModel,clientDetails));
        operationMessageChannelWSDTO.setOperationPushChannel(getApiOperationPushChannelWSDTO(operationDBModel,clientDetails));

        return operationMessageChannelWSDTO;
    }


    public ApiOperationSmsChannelWSDTO getApiOperationSmsChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationSmsAccountWSDTO smsAccountWSDTO = channelHelper.getApiSmsAccountWSDTO(operationDBModel.getProcessId());
        if (smsAccountWSDTO != null && clientDetails.getClientPhones() != null){

            ApiOperationSmsChannelWSDTO operationSmsChannelWSDTO = new ApiOperationSmsChannelWSDTO();
            operationSmsChannelWSDTO.setSmsAccount(smsAccountWSDTO);
            operationSmsChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            operationSmsChannelWSDTO.setOperationSmss(operationSmsMessageRepository.findByOperationId(operationDBModel.getId()));
            operationSmsChannelWSDTO.setOperationSmsTemps(processSmsMessageTempRepository.findByProcessId(operationDBModel.getProcessId()));

            return operationSmsChannelWSDTO;
        }
        return null;
    }

    public ApiOperationWappMessageChannelWSDTO getApiOperationWappMessageChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationWappMessageAccountWSDTO wappAccountWSDTO = channelHelper.getApiWappMessageAccountWSDTO(operationDBModel.getAgentId(),operationDBModel.getProcessId());
        if (wappAccountWSDTO != null && clientDetails.getClientPhones() != null){

            ApiOperationWappMessageChannelWSDTO wappMessageChannelWSDTO = new ApiOperationWappMessageChannelWSDTO();
            wappMessageChannelWSDTO.setWappAccount(wappAccountWSDTO);
            wappMessageChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            wappMessageChannelWSDTO.setOperationWappMessageTemps(processWappMessageTempRepository.findByProcessId(operationDBModel.getProcessId()));
            wappMessageChannelWSDTO.setOperationWappMessages(operationWappMessageRepository.findByOperationId(operationDBModel.getId()));

            return wappMessageChannelWSDTO;
        }
        return null;
    }

    public ApiOperationEmailChannelWSDTO getApiOperationEmailChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationEmailAccountWSDTO emailAccountWSDTO = channelHelper.getApiEmailAccountWSDTO(operationDBModel.getProcessId());
        if (emailAccountWSDTO != null && clientDetails.getClientEmails() != null){

            ApiOperationEmailChannelWSDTO emailChannelWSDTO = new ApiOperationEmailChannelWSDTO();
            emailChannelWSDTO.setEmailAccount(emailAccountWSDTO);
            emailChannelWSDTO.setClientEmails(clientDetails.getClientEmails());
            emailChannelWSDTO.setOperationEmails(operationEmailMessageRepository.findByOperationId(operationDBModel.getId()));
            emailChannelWSDTO.setOperationEmailTemps(processEmailTempRepository.findByProcessId(operationDBModel.getProcessId()));

            return emailChannelWSDTO;
        }
        return null;
    }

    public ApiOperationPushChannelWSDTO getApiOperationPushChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationPushAccountWSDTO pushAccountWSDTO = channelHelper.getApiPushAccountWSDTO(operationDBModel.getProcessId());
        if (pushAccountWSDTO != null ){

            ApiOperationPushChannelWSDTO pushChannelWSDTO = new ApiOperationPushChannelWSDTO();
            pushChannelWSDTO.setPushAccount(pushAccountWSDTO);
            pushChannelWSDTO.setOperationPushes(operationPushMessageRepository.findByOperationId(operationDBModel.getId()));
            pushChannelWSDTO.setOperationPushTemps(processPushTempRepository.findByProcessId(operationDBModel.getProcessId()));

            return pushChannelWSDTO;
        }
        return null;
    }



    public PaginationWSDTO mapOperationPagination(Page<OperationDBModel> operationModelPage){

        PaginationWSDTO operationPagination = new PaginationWSDTO();
        operationPagination.setPageSize(operationModelPage.getPageable().getPageSize());
        operationPagination.setPageNumber(operationModelPage.getPageable().getPageNumber());
        operationPagination.setTotalPage(operationModelPage.getTotalPages());
        operationPagination.setTotalElements(operationModelPage.getTotalElements());

        return operationPagination;
    }

    public PaginationWSDTO mapSessionModelPagination(Page<SessionDBModel> sessionModelPage){

        PaginationWSDTO sessionPagination = new PaginationWSDTO();
        sessionPagination.setPageSize(sessionModelPage.getPageable().getPageSize());
        sessionPagination.setPageNumber(sessionModelPage.getPageable().getPageNumber());
        sessionPagination.setTotalPage(sessionModelPage.getTotalPages());
        sessionPagination.setTotalElements(sessionModelPage.getTotalElements());

        return sessionPagination;
    }



}
