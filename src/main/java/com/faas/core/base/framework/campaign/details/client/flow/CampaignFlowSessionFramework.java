package com.faas.core.base.framework.campaign.details.client.flow;

import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionWSDTO;
import com.faas.core.base.model.ws.campaign.details.client.flow.CampaignFlowSessionRequest;
import com.faas.core.base.model.ws.campaign.details.client.flow.dto.CampaignFlowSessionRequestDTO;
import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.client.flow.dto.FlowSessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.flow.ClientFlowRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.FlowHelper;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignFlowSessionFramework {


    @Autowired
    ActivityHelper activityHelper;

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    FlowHelper flowHelper;

    @Autowired
    ClientFlowRepository clientFlowRepository;

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

       /* Page<FlowDBModel> flowDBModelPage = flowRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId, city, country, PageRequest.of(reqPage, reqSize));
        if (flowDBModelPage != null) {
            CampaignFlowWSDTO campaignFlowWSDTO = new CampaignFlowWSDTO();
            campaignFlowWSDTO.setPagination(flowHelper.createFlowPagination(flowDBModelPage));
            campaignFlowWSDTO.setFlows(flowHelper.createFlowWSDTOS(flowDBModelPage.getContent()));
            return campaignFlowWSDTO;
        }

        */
        return null;
    }

    public CampaignFlowSessionWSDTO getCampaignFlowSessionsService(long userId, String campaignId, int reqPage, int reqSize) {

        /*  Page<FlowDBModel> flowDBModelPage = flowRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage, reqSize));
        if (flowDBModelPage != null) {
            CampaignFlowWSDTO campaignFlowWSDTO = new CampaignFlowWSDTO();
            campaignFlowWSDTO.setPagination(flowHelper.createFlowPagination(flowDBModelPage));
            campaignFlowWSDTO.setFlows(flowHelper.createFlowWSDTOS(flowDBModelPage.getContent()));
            return campaignFlowWSDTO;
        }

         */
        return null;
    }

    public FlowSessionWSDTO getCampaignFlowSessionService(long userId,long sessionId) {

   /*     List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (!flowDBModels.isEmpty()) {
            return new FlowWSDTO(flowDBModels.get(0));
        }
    */
        return null;
    }

    public List<FlowSessionWSDTO> createCampaignFlowSessionService(CampaignFlowSessionRequest flowSessionRequest) {

        List<FlowSessionWSDTO> flowSessionWSDTOS = new ArrayList<>();
        for (int i = 0; i< flowSessionRequest.getSessionRequests().size(); i++){
            FlowSessionWSDTO flowSessionWSDTO = createCampaignFlowSession(flowSessionRequest.getSessionRequests().get(i));
            if (flowSessionWSDTO != null){
                flowSessionWSDTOS.add(flowSessionWSDTO);
            }
        }
        return flowSessionWSDTOS;
    }

    public FlowSessionWSDTO createCampaignFlowSession(CampaignFlowSessionRequestDTO flowSessionRequest){

    /*    if (!flowRepository.existsByClientIdAndCampaignId(flowRequestDTO.getClientId(),flowRequestDTO.getCampaignId())){
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(flowRequestDTO.getCampaignId());
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(flowRequestDTO.getClientId());
            Optional<UserDBModel> agentDBModel = userRepository.findById(flowRequestDTO.getAgentId());
            if (clientDBModel.isPresent() && agentDBModel.isPresent() && campaignDBModel.isPresent() ) {

                clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());

                SessionDBModel sessionDBModel = flowHelper.mapFlowSession(clientDBModel.get(),agentDBModel.get(),campaignDBModel.get());
                OperationDBModel operationDBModel = operationRepository.save(flowHelper.mapFlowOperation(sessionDBModel));

                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.SESSION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.SESSION_TYPE);
                activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.OPERATION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.OPERATION_TYPE);

                return new FlowWSDTO(flowRepository.save(flowHelper.mapFlowDBModel(sessionDBModel)));
            }
        }

     */
        return null;
    }

    public FlowSessionWSDTO updateCampaignFlowSessionService(long userId,long sessionId,long agentId,String campaignId,String flowState) {

    /*    List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (flowDBModels.size() > 0) {
            flowDBModels.get(0).setFlowState(flowState);
            flowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new FlowWSDTO(flowRepository.save(flowDBModels.get(0)));
        }

     */
        return null;
    }

    public FlowSessionWSDTO removeCampaignFlowSessionService(long userId,long sessionId) {

   /*     List<FlowDBModel> flowDBModels = flowRepository.findByIdAndClientId(flowId, clientId);
        if (flowDBModels.size() > 0) {
            flowRepository.delete(flowDBModels.get(0));
            Optional<SessionDBModel>sessionDBModel = sessionRepository.findById(flowDBModels.get(0).getSessionId());
            if(sessionDBModel.isPresent()){
                sessionRepository.delete(sessionDBModel.get());
                operationRepository.deleteAll(operationRepository.findBySessionIdAndClientId(sessionDBModel.get().getId(),clientId));
            }
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            return new FlowWSDTO(flowDBModels.get(0));
        }
    */
        return null;
    }


}