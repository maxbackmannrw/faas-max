package com.faas.core.base.framework.campaign.details.client.operation;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.details.client.operation.dto.CampaignOperationRequestDTO;
import com.faas.core.base.model.ws.campaign.details.client.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignOperationFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignOperationWSDTO searchCampaignOperationsService(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,city,country, PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            CampaignOperationWSDTO campaignOperationWSDTO = new CampaignOperationWSDTO();
            campaignOperationWSDTO.setOperations(operationHelper.getOperationWSDTOSBySessionModels(sessionModelPage.getContent()));
            campaignOperationWSDTO.setPagination(operationHelper.mapSessionModelPagination(sessionModelPage));

            return campaignOperationWSDTO;
        }
        return null;
    }


    public CampaignOperationWSDTO getCampaignOperationsService(long userId, String campaignId, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){

            CampaignOperationWSDTO campaignOperationWSDTO = new CampaignOperationWSDTO();
            campaignOperationWSDTO.setOperations(operationHelper.getOperationWSDTOSBySessionModels(sessionModelPage.getContent()));
            campaignOperationWSDTO.setPagination(operationHelper.mapSessionModelPagination(sessionModelPage));

            return campaignOperationWSDTO;
        }
        return null;
    }


     public OperationWSDTO getCampaignOperationService(long userId,long sessionId,String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndCampaignId(sessionId,campaignId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (!sessionDBModels.isEmpty() && !operationDBModels.isEmpty()){
            return operationHelper.getOperationWSDTO(operationDBModels.get(0),sessionDBModels.get(0));
        }
        return null;
    }


    public List<OperationWSDTO> createCampaignOperationService(CampaignOperationRequest operationRequest) {

        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i = 0; i< operationRequest.getOperationRequests().size(); i++){
            OperationWSDTO operationWSDTO = createCampaignOperation(operationRequest.getOperationRequests().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        return operationWSDTOS;
    }


    public OperationWSDTO createCampaignOperation(CampaignOperationRequestDTO operationRequestDTO) {

        List<ClientDBModel> clientDBModels = clientRepository.findByIdAndClientState(operationRequestDTO.getClientId(),AppConstant.READY_CLIENT);
        Optional<UserDBModel> agentDBModel = userRepository.findById(operationRequestDTO.getAgentId());
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(operationRequestDTO.getCampaignId());
        if (!clientDBModels.isEmpty() && agentDBModel.isPresent() && campaignDBModel.isPresent()){

            clientDBModels.get(0).setClientState(AppConstant.BUSY_CLIENT);
            clientDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            ClientDBModel clientDBModel = clientRepository.save(clientDBModels.get(0));

            SessionDBModel sessionDBModel =sessionRepository.save(operationHelper.createSessionDBModel(clientDBModel,agentDBModel.get(),campaignDBModel.get()));
            OperationDBModel operationDBModel = operationRepository.save(operationHelper.createOperationDBModel(sessionDBModel));

            sessionDBModel.setOperationId(operationDBModel.getId());
            sessionDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sessionDBModel = sessionRepository.save(sessionDBModel);

            activityHelper.createOperationActivity(sessionDBModel,operationDBModel);

            return new OperationWSDTO(operationDBModel,sessionDBModel);
        }
        return null;
    }


    public OperationWSDTO updateCampaignOperationService(long userId,long sessionId,long agentId, String operationState) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && agentDBModel.isPresent()){

        }
        return null;
    }


    public OperationWSDTO removeCampaignOperationService(long userId,long sessionId,String campaignId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndCampaignId(sessionId,campaignId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (!sessionDBModels.isEmpty() && !operationDBModels.isEmpty()) {
            OperationWSDTO operationWSDTO = operationHelper.getOperationWSDTO(operationDBModels.get(0), sessionDBModels.get(0));
            operationHelper.removeOperationHelper(sessionId);
            return operationWSDTO;
        }
        return null;
    }


}