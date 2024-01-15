package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiOperationOSINTWSDTO;
import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardOperationWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.api.model.ws.operation.details.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationFlowDAO;
import com.faas.core.base.model.db.operation.content.dao.OperationInquiryDAO;
import com.faas.core.base.model.db.operation.content.dao.OperationScenarioDAO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
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
    ClientRepository clientRepository;

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
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


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


    public OperationWSDTO getOperationWSDTO(OperationDBModel operationDBModel, SessionDBModel sessionDBModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);
        operationWSDTO.setOperationSession(sessionDBModel);

        return operationWSDTO;
    }


    public ApiOperationListWSDTO getApiOperationListWSDTO(Page<OperationDBModel> operationModelPage){

        ApiOperationListWSDTO operationListWSDTO = new ApiOperationListWSDTO();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            ApiOperationWSDTO operationWSDTO = mapApiOperationWSDTO(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(mapOperationPagination(operationModelPage));

        return operationListWSDTO;
    }

    public ApiDashboardOperationWSDTO createApiDashboardOperationWSDTO(Page<OperationDBModel> operationModelPage){

        ApiDashboardOperationWSDTO dashboardOperationWSDTO = new ApiDashboardOperationWSDTO();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            ApiOperationWSDTO operationWSDTO = mapApiOperationWSDTO(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        dashboardOperationWSDTO.setOperations(operationWSDTOS);
        dashboardOperationWSDTO.setPagination(mapOperationPagination(operationModelPage));

        return dashboardOperationWSDTO;
    }




    public ApiOperationScenarioWSDTO getApiOperationScenarioWSDTO(OperationScenarioDAO operationScenarioDAO){

        ApiOperationScenarioWSDTO operationScenarioWSDTO = new ApiOperationScenarioWSDTO();

        return operationScenarioWSDTO;
    }


    public SessionDBModel createSessionDBModel(ClientDBModel clientDBModel, UserDBModel agentDBModel,CampaignDBModel campaignDBModel  ) {

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
            operationDBModel.setSessionUUID(sessionDBModel.getSessionUUID());
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


    public ApiOperationDetailsWSDTO mapApiOperationDetailsWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel, OperationDBModel operationDBModel, CampaignDBModel campaignDBModel, ProcessDBModel processDBModel) {

        ApiOperationDetailsWSDTO operationDetailsWSDTO = new ApiOperationDetailsWSDTO();
        operationDetailsWSDTO.setOperation(operationDBModel);
        operationDetailsWSDTO.setOperationSession(sessionDBModel);
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

        return operationClientWSDTO;
    }


    public List<ApiOperationOSINTWSDTO> mapApiClientOsIntWSDTOS(ClientDBModel clientDBModel) {

        List<ApiOperationOSINTWSDTO> clientOsIntWSDTOS = new ArrayList<>();
        return clientOsIntWSDTOS;
    }


    public List<ApiOperationNoteWSDTO> mapApiOperationNoteWSDTO(ClientDBModel clientDBModel) {

        List<ApiOperationNoteWSDTO> clientNoteWSDTOS = new ArrayList<>();
        return clientNoteWSDTOS;
    }


    public ApiOperationCampaignWSDTO mapApiOperationCampaignWSDTO(CampaignDBModel campaignDBModel, ProcessDBModel processDBModel) {

        ApiOperationCampaignWSDTO operationCampaignWSDTO = new ApiOperationCampaignWSDTO();
        operationCampaignWSDTO.setOperationCampaign(campaignDBModel);
        operationCampaignWSDTO.setOperationProcess(processDBModel);
        return operationCampaignWSDTO;
    }


    public List<ApiOperationActivityWSDTO> mapApiOperationActivities(OperationDBModel operationDBModel) {


        return null;
    }


    public List<ApiOperationScenarioWSDTO> mapApiOperationScenarioWSDTOS(long sessionId, String processId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        return operationScenarioWSDTOS;
    }





    public ApiOperationChannelWSDTO mapApiOperationChannelWSDTO(SessionDBModel sessionDBModel, ClientDBModel clientDBModel) {

        ApiOperationChannelWSDTO operationChannelWSDTO = new ApiOperationChannelWSDTO();

        operationChannelWSDTO.setOperationPushMessage(channelHelper.mapApiOperationPushMessageWSDTO(sessionDBModel));
        operationChannelWSDTO.setOperationEmail(channelHelper.mapApiOperationEmailWSDTO(sessionDBModel));

        return operationChannelWSDTO;
    }


    public ApiOperationWSDTO mapApiOperationWSDTO(OperationDBModel operationDBModel) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(operationDBModel.getSessionId());
        if (sessionDBModel.isPresent()){

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
            operationWSDTO.setOperation(operationDBModel);
            operationWSDTO.setOperationSession(sessionDBModel.get());

            return operationWSDTO;
        }
        return null;
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


    public PaginationWSDTO mapOperationPagination(Page<OperationDBModel> operationModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(operationModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(operationModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(operationModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(operationModelPage.getTotalElements());

        return paginationWSDTO;
    }

    public PaginationWSDTO mapSessionModelPagination(Page<SessionDBModel> sessionModelPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(sessionModelPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(sessionModelPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(sessionModelPage.getTotalPages());
        paginationWSDTO.setTotalElements(sessionModelPage.getTotalElements());

        return paginationWSDTO;
    }


    public List<ApiSummaryWSDTO> getApiOperationSummary(long agentId){

        List<ApiSummaryWSDTO> operationSummary = new ArrayList<>();
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.READY_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return operationSummary;
    }


}
