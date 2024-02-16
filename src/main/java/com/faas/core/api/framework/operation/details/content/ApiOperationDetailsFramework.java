package com.faas.core.api.framework.operation.details.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationDetailsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationDetailsWSDTO apiGetOperationDetailsService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return operationHelper.getApiOperationDetailsWSDTO(operationDBModels.get(0));
        }
        return null;
    }


    public ApiOperationWSDTO apiOperationStartService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!operationDBModels.isEmpty() && !sessionDBModels.isEmpty()) {

            if (operationDBModels.get(0).getOperationType().equalsIgnoreCase(AppConstant.MANUAL_OPERATION)){
                if (operationDBModels.get(0).getOperationState().equalsIgnoreCase(AppConstant.READY_STATE)){
                    return operationHelper.startManualOperationHelper(sessionDBModels.get(0),operationDBModels.get(0));
                }
            }

            if (operationDBModels.get(0).getOperationType().equalsIgnoreCase(AppConstant.INQUIRY_OPERATION)){
                if (operationDBModels.get(0).getOperationState().equalsIgnoreCase(AppConstant.READY_STATE)
                        && operationDBModels.get(0).getOperationInquiryState().equalsIgnoreCase(AppConstant.READY_STATE)){
                    return operationHelper.startInquiryOperationHelper(sessionDBModels.get(0),operationDBModels.get(0));
                }
            }

            if (operationDBModels.get(0).getOperationType().equalsIgnoreCase(AppConstant.AUTOMATIC_OPERATION)){
                if (operationDBModels.get(0).getOperationState().equalsIgnoreCase(AppConstant.READY_STATE)
                        && operationDBModels.get(0).getOperationFlowState().equalsIgnoreCase(AppConstant.READY_STATE)){
                    return operationHelper.startAutomaticOperationHelper(sessionDBModels.get(0),operationDBModels.get(0));
                }
            }
        }
        return null;
    }


    public ApiOperationWSDTO apiOperationFinishService(long agentId,String operationId,String operationState) {

       /* Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(sessionId, clientId, agentId, campaignId, AppConstant.ACTIVE_STATE);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(sessionId, clientId, agentId, campaignId, AppConstant.ACTIVE_STATE);

        if (clientDBModel.isPresent() && clientDBModel.get().getClientState().equalsIgnoreCase(AppConstant.BUSY_CLIENT) && !sessionDBModels.isEmpty() && !operationDBModels.isEmpty()) {

            ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();

            clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            sessionDBModels.get(0).setSessionState(AppConstant.FINISHED_STATE);
            sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            operationWSDTO.setOperationSession(sessionRepository.save(sessionDBModels.get(0)));

            operationDBModels.get(0).setOperationState(AppConstant.FINISHED_STATE);
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
        */
        return null;
    }


    public List<ApiOperationWSDTO> apiGetSwichtableOperationsService(long agentId,String operationId) {


        return null;
    }


    public ApiOperationWSDTO apiOperationSwitchService(long agentId,String operationId,String selectedId) {

        return null;
    }


    public ApiCampaignDetailsWSDTO apiGetOperationCampaignService(long agentId, String operationId) {


        return null;
    }


}
