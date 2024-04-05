package com.faas.core.api.framework.operation.details.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
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
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationDetailsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationDetailsWSDTO apiGetOperationDetailsService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return operationHelper.getApiOperationDetailsWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWSDTO apiStartOperationService(long agentId,String operationId) {

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

    public ApiOperationWSDTO apiCompleteOperationService(long agentId,String operationId,String operationResult) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentIdAndOperationState(operationId,agentId,AppConstant.ACTIVE_STATE);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationIdAndSessionState(agentId,operationId,AppConstant.ACTIVE_STATE);
        if (!operationDBModels.isEmpty() && !sessionDBModels.isEmpty()) {

            Optional<ClientDBModel> clientDBModel = clientRepository.findById(operationDBModels.get(0).getClientId());
            if (clientDBModel.isPresent()){

                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());

                sessionDBModels.get(0).setSessionState(AppConstant.COMPLETED_STATE);
                sessionDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                sessionRepository.save(sessionDBModels.get(0));

                operationDBModels.get(0).setOperationState(AppConstant.COMPLETED_STATE);
                operationDBModels.get(0).setOperationResult(operationResult);
                operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                operationRepository.save(operationDBModels.get(0));

                return new ApiOperationWSDTO(operationDBModels.get(0),sessionDBModels.get(0));
            }
        }
        return null;
    }

    public List<ApiOperationWSDTO> apiGetSwitchOperationsService(long agentId,String operationId) {

        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE);
        for (OperationDBModel operationDBModel : operationDBModels) {
            if (!operationDBModel.getId().equalsIgnoreCase(operationId)) {
                operationWSDTOS.add(operationHelper.getApiOperationWSDTO(operationDBModel));
            }
        }
        return operationWSDTOS;
    }

    public ApiOperationWSDTO apiSwitchOperationService(long agentId,String operationId,String selectedId) {

        List<OperationDBModel> currentOperations = operationRepository.findByIdAndAgentId(operationId,agentId);
        List<OperationDBModel> selectedOperations = operationRepository.findByIdAndAgentId(selectedId,agentId);
        if (!currentOperations.isEmpty() && !selectedOperations.isEmpty() && selectedOperations.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
            return operationHelper.getApiOperationWSDTO(selectedOperations.get(0));
        }
        return null;
    }

    public ApiCampaignDetailsWSDTO apiGetOperationCampaignService(long agentId, String operationId) {

        return null;
    }


    public List<ApiOperationActivityWSDTO> apiGetOperationActivitiesService(long agentId, String operationId) {

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationActivities() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationActivities().size();i++){
                operationActivityWSDTOS.add(new ApiOperationActivityWSDTO(operationDBModels.get(0).getOperationActivities().get(i)));
            }
        }
        return operationActivityWSDTOS;
    }

    public ApiOperationActivityWSDTO apiGetOperationActivityService(long agentId,String operationId,String activityId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationActivities() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationActivities().size();i++){
                if (operationDBModels.get(0).getOperationActivities().get(i).getId().equalsIgnoreCase(activityId)){
                    return new ApiOperationActivityWSDTO(operationDBModels.get(0).getOperationActivities().get(i));
                }
            }
        }
        return null;
    }


}
