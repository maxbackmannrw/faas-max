package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentOperationWSDTO apiGetAgentOperationsService(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationWSDTO agentOperationWSDTO = new ApiAgentOperationWSDTO();
        Page<OperationDBModel> readyOperationPage = operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.READY_STATE, PageRequest.of(reqPage,reqSize));
        if (readyOperationPage != null){
            agentOperationWSDTO.setReadyOperation(operationHelper.createApiOperationSessionFromOperationModel(readyOperationPage));
        }
        Page<OperationDBModel> activeOperationPage = operationRepository.findAllByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE, PageRequest.of(reqPage,reqSize));
        if (activeOperationPage != null){
            agentOperationWSDTO.setActiveOperation(operationHelper.createApiOperationSessionFromOperationModel(activeOperationPage));
        }
        return agentOperationWSDTO;
    }


    public ApiOperationSessionWSDTO apiGetCampaignOperationsService(long agentId,String campaignId,String operationState,int reqPage,int reqSize) {

        Page<OperationDBModel> campaignOperationPage = operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, operationState, PageRequest.of(reqPage,reqSize));
        if (campaignOperationPage != null){
            return operationHelper.createApiOperationSessionFromOperationModel(campaignOperationPage);
        }
        return null;
    }


    public ApiOperationSessionWSDTO apiGetOperationsService(long agentId, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> operationPage = operationRepository.findAllByAgentIdAndOperationState(agentId, operationState, PageRequest.of(reqPage,reqSize));
        if (operationPage != null){
            return operationHelper.createApiOperationSessionFromOperationModel(operationPage);
        }
        return null;
    }


    public ApiOperationWSDTO apiGetOperationService(long agentId, long sessionId) {

        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.mapApiOperationWSDTOFromOperationModel(operationDBModels.get(0));
        }
        return null;
    }


    public ApiOperationWSDTO apiLaunchOperationService(long agentId,long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.READY_STATE);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(sessionId, clientId, agentId, campaignId, AppConstant.READY_STATE);
        if (!sessionDBModels.isEmpty() && !operationDBModels.isEmpty()) {

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
            sessionDBModels.get(0).setSessionState(AppConstant.ACTIVE_STATE);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            SessionDBModel operationSession = sessionRepository.save(sessionDBModels.get(0));
            operationWSDTO.setOperationSession(operationSession);

            operationDBModels.get(0).setOperationState(AppConstant.ACTIVE_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            OperationDBModel operation = operationRepository.save(operationDBModels.get(0));
            operationWSDTO.setOperation(operation);

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){

                //List<InquiryDBModel> inquiryDBModels = inquiryRepository.findBySessionIdAndClientId(sessionId,clientId);
                //inquiryDBModels.get(0).setInquiryState(AppConstant.ACTIVE_INQUIRY);
                //inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                //operationWSDTO.setOperationInquiry(inquiryRepository.save(inquiryDBModels.get(0)));
            }

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){

                // List<FlowDBModel> flowDBModels = flowRepository.findBySessionIdAndClientId(sessionId,clientId);
                // flowDBModels.get(0).setFlowState(AppConstant.ACTIVE_FLOW);
                // flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                // operationWSDTO.setOperationFlow(flowRepository.save(flowDBModels.get(0)));
            }

            activityHelper.createOperationActivity(operation.getSessionId(), operation.getId(), AppConstant.LAUNCH_OPERATION_ACTIVITY,
                    AppConstant.OPERATION_ACTIVITY, String.valueOf(operation.getAgentId()), AppConstant.USER_TYPE, operation.getId(), AppConstant.OPERATION_TYPE);

            return operationWSDTO;
        }
        return null;
    }



    public ApiOperationWSDTO apiUpdateOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        return null;
    }



    public ApiOperationWSDTO apiFinishOperationService(long agentId, long sessionId, long clientId, String campaignId,String operationResult) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.ACTIVE_STATE);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(sessionId, clientId, agentId, campaignId, AppConstant.ACTIVE_OPERATION);

        if (clientDBModel.isPresent() && clientDBModel.get().getClientState().equalsIgnoreCase(AppConstant.BUSY_CLIENT) && !sessionDBModels.isEmpty() && !operationDBModels.isEmpty()) {

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();

            clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            sessionDBModels.get(0).setSessionState(AppConstant.FINISHED_STATE);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            operationWSDTO.setOperationSession(sessionRepository.save(sessionDBModels.get(0)));

            operationDBModels.get(0).setOperationState(AppConstant.FINISHED_OPERATION);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            operationWSDTO.setOperation(operationRepository.save(operationDBModels.get(0)));

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){

                // List<InquiryDBModel> inquiryDBModels = inquiryRepository.findBySessionIdAndClientId(sessionId,clientId);
                // inquiryDBModels.get(0).setInquiryState(AppConstant.FINISHED_INQUIRY);
                // inquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                // operationWSDTO.setOperationInquiry(inquiryRepository.save(inquiryDBModels.get(0)));
            }

            if (sessionDBModels.get(0).getSessionType().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){

                // List<FlowDBModel> flowDBModels = flowRepository.findBySessionIdAndClientId(sessionId,clientId);
                // flowDBModels.get(0).setFlowState(AppConstant.FINISHED_FLOW);
                // flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                // operationWSDTO.setOperationFlow(flowRepository.save(flowDBModels.get(0)));
            }

            return operationWSDTO;
        }
        return null;
    }


    public ApiOperationWSDTO apiRemoveOperationService(long agentId, long sessionId, long clientId, String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignId(sessionId, clientId, agentId, campaignId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentId(sessionId, clientId, agentId);
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);


        return null;
    }


    public List<ApiSummaryWSDTO> apiGetOperationSummaryService(long agentId) {
        return operationHelper.getApiOperationSummary(agentId);
    }


}
