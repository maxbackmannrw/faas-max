package com.faas.core.base.framework.campaign.details.client.flow;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionWSDTO;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionRequest;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionRequestDTO;
import com.faas.core.base.model.ws.manager.automatic.operation.dto.OperationFlowSessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.FlowHelper;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignFlowSessionFramework {


    @Autowired
    FlowHelper flowHelper;

    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    OperationFlowRepository operationFlowRepository;

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
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignFlowSessionWSDTO searchCampaignFlowSessionsService(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionDBModelPage = sessionRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,city,country, PageRequest.of(reqPage,reqSize));
        if (sessionDBModelPage != null) {
            CampaignFlowSessionWSDTO campaignFlowSessionWSDTO = new CampaignFlowSessionWSDTO();
            campaignFlowSessionWSDTO.setPagination(flowHelper.createFlowSessionPagination(sessionDBModelPage));
            campaignFlowSessionWSDTO.setFlowSessions(flowHelper.createFlowSessionWSDTOS(sessionDBModelPage.getContent()));

            return campaignFlowSessionWSDTO;
        }
        return null;
    }


    public CampaignFlowSessionWSDTO getCampaignFlowSessionsService(long userId, String campaignId, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionDBModelPage = sessionRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (sessionDBModelPage != null) {
            CampaignFlowSessionWSDTO campaignFlowSessionWSDTO = new CampaignFlowSessionWSDTO();
            campaignFlowSessionWSDTO.setFlowSessions(flowHelper.createFlowSessionWSDTOS(sessionDBModelPage.getContent()));
            campaignFlowSessionWSDTO.setPagination(flowHelper.createFlowSessionPagination(sessionDBModelPage));

            return campaignFlowSessionWSDTO;
        }
        return null;
    }


    public OperationFlowSessionWSDTO getCampaignFlowSessionService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return flowHelper.createFlowSessionWSDTO(sessionDBModel.get());
        }
        return null;
    }


    public List<OperationFlowSessionWSDTO> createCampaignFlowSessionService(CampaignFlowSessionRequest flowSessionRequest) {

        List<OperationFlowSessionWSDTO> operationFlowSessionWSDTOS = new ArrayList<>();
        for (int i = 0; i< flowSessionRequest.getSessionRequests().size(); i++){
            OperationFlowSessionWSDTO operationFlowSessionWSDTO = createCampaignFlowSession(flowSessionRequest.getSessionRequests().get(i));
            if (operationFlowSessionWSDTO != null){
                operationFlowSessionWSDTOS.add(operationFlowSessionWSDTO);
            }
        }
        return operationFlowSessionWSDTOS;
    }


    public OperationFlowSessionWSDTO createCampaignFlowSession(CampaignFlowSessionRequestDTO flowSessionRequest){

        if (!operationFlowRepository.existsByClientIdAndCampaignId(flowSessionRequest.getClientId(),flowSessionRequest.getCampaignId())){

            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(flowSessionRequest.getCampaignId());
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(flowSessionRequest.getClientId());
            Optional<UserDBModel> agentDBModel = userRepository.findById(flowSessionRequest.getAgentId());

            if (clientDBModel.isPresent() && agentDBModel.isPresent() && campaignDBModel.isPresent()) {

                clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                ClientDBModel updatedClient = clientRepository.save(clientDBModel.get());

                SessionDBModel sessionDBModel = sessionRepository.save(flowHelper.mapFlowSession(updatedClient,agentDBModel.get(),campaignDBModel.get()));
                OperationDBModel operationDBModel = operationRepository.save(flowHelper.mapFlowOperation(sessionDBModel));
                operationFlowRepository.save(flowHelper.mapOperationFlowDBModel(sessionDBModel));

                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.SESSION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.SESSION_TYPE);
                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.OPERATION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.OPERATION_TYPE);

                return flowHelper.createFlowSessionWSDTO(sessionDBModel);
            }
        }
        return null;
    }


    public OperationFlowSessionWSDTO updateCampaignFlowSessionService(long userId, long sessionId, long agentId, String campaignId, String flowState) {

    /*    List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (flowDBModels.size() > 0) {
            flowDBModels.get(0).setFlowState(flowState);
            flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new FlowWSDTO(flowRepository.save(flowDBModels.get(0)));
        }
     */
        return null;
    }


    public OperationFlowSessionWSDTO removeCampaignFlowSessionService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()) {
            OperationFlowSessionWSDTO campaignFlowSession = flowHelper.createFlowSessionWSDTO(sessionDBModel.get());
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.get().getClientId());
            if (clientDBModel.isPresent()) {
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
            if (!operationDBModels.isEmpty()){
                operationRepository.delete(operationDBModels.get(0));
            }
            List<OperationFlowDBModel> operationFlowDBModels = operationFlowRepository.findBySessionId(sessionId);
            if (!operationFlowDBModels.isEmpty()){
                operationFlowRepository.delete(operationFlowDBModels.get(0));
            }
            sessionRepository.delete(sessionDBModel.get());
            return campaignFlowSession;
        }
        return null;
    }


}
