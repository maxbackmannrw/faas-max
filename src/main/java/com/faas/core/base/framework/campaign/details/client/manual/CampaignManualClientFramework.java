package com.faas.core.base.framework.campaign.details.client.manual;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignSessionWSDTO;
import com.faas.core.base.model.ws.campaign.details.client.manual.ManualClientRequest;
import com.faas.core.base.model.ws.campaign.details.client.manual.dto.ManualClientRequestDTO;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ActivityHelper;
import com.faas.core.utils.helpers.OperationHelper;

import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CampaignManualClientFramework {

    @Autowired
    SessionHelper sessionHelper;

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
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignSessionWSDTO searchCampaignManualClientsService(long userId,String campaignId,String city,String country,int reqPage,int reqSize) {

        Page<SessionDBModel> sessionDBModels = sessionRepository.findAllByCampaignIdAndClientCityAndClientCountry(campaignId,city,country,PageRequest.of(reqPage,reqSize));
        if (sessionDBModels != null){
            CampaignSessionWSDTO campaignSessionWSDTO = new CampaignSessionWSDTO();
            campaignSessionWSDTO.setPagination(sessionHelper.createSessionPaginationWSDTO(sessionDBModels));
            campaignSessionWSDTO.setSessions(sessionHelper.mapSessionWSDTOS(sessionDBModels.getContent()));
            return campaignSessionWSDTO;
        }
        return null;
    }

    public CampaignSessionWSDTO getCampaignManualClientsService(long userId,String campaignId,int reqPage,int reqSize) {

        Page<SessionDBModel> sessionDBModels = sessionRepository.findAllByCampaignId(campaignId, PageRequest.of(reqPage,reqSize));
        if (sessionDBModels != null){
            CampaignSessionWSDTO campaignSessionWSDTO = new CampaignSessionWSDTO();
            campaignSessionWSDTO.setPagination(sessionHelper.createSessionPaginationWSDTO(sessionDBModels));
            campaignSessionWSDTO.setSessions(sessionHelper.mapSessionWSDTOS(sessionDBModels.getContent()));
            return campaignSessionWSDTO;
        }
        return null;
    }

    public SessionWSDTO getCampaignManualClientService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return sessionHelper.mapSessionWSDTO(sessionDBModel.get());
        }
        return null;
    }

    public List<SessionWSDTO> createCampaignManualClientService(ManualClientRequest manualClientRequest) {

        List<SessionWSDTO>sessionWSDTOS = new ArrayList<>();
        for (int i = 0; i< manualClientRequest.getClientRequests().size(); i++){
            SessionWSDTO sessionWSDTO = createCampaignManualClient(manualClientRequest.getClientRequests().get(i));
            if (sessionWSDTO != null){
                sessionWSDTOS.add(sessionWSDTO);
            }
        }
        return sessionWSDTOS;
    }

    public SessionWSDTO createCampaignManualClient(ManualClientRequestDTO manualClientRequestDTO) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(manualClientRequestDTO.getClientId());
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(manualClientRequestDTO.getCampaignId());
        Optional<UserDBModel> agentDBModel = userRepository.findById(manualClientRequestDTO.getAgentId());
        if (clientDBModel.isPresent() && campaignDBModel.isPresent() && agentDBModel.isPresent()){

            clientDBModel.get().setClientState(AppConstant.BUSY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());

            SessionDBModel sessionDBModel = sessionRepository.save(sessionHelper.mapSessionDBModel(campaignDBModel.get(),agentDBModel.get(),clientDBModel.get()));
            OperationDBModel operationDBModel = operationRepository.save(operationHelper.mapOperationDBModel(sessionDBModel));

            activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.SESSION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.SESSION_TYPE);
            activityHelper.createOperationActivity(sessionDBModel.getId(),operationDBModel.getId(),AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.OPERATION_ACTIVITY,String.valueOf(sessionDBModel.getAgentId()),AppConstant.USER_TYPE,String.valueOf(sessionDBModel.getId()),AppConstant.OPERATION_TYPE);

            return sessionHelper.mapSessionWSDTO(sessionDBModel);
        }
        return null;
    }

    public SessionWSDTO updateCampaignManualClientService(long userId,long sessionId,long agentId,String campaignId,String sessionState) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (sessionDBModel.isPresent() && campaignDBModel.isPresent() && agentDBModel.isPresent()){

            sessionDBModel.get().setCampaignId(campaignDBModel.get().getCampaign());
            sessionDBModel.get().setCampaign(campaignDBModel.get().getCampaign());
            sessionDBModel.get().setCampaignType(campaignDBModel.get().getCampaignType());
            sessionDBModel.get().setProcessId(campaignDBModel.get().getProcessId());
            sessionDBModel.get().setProcess(campaignDBModel.get().getProcess());
            sessionDBModel.get().setProcessType(campaignDBModel.get().getProcessType());
            sessionDBModel.get().setProcessCategory(campaignDBModel.get().getProcessCategory());
            sessionDBModel.get().setAgentId(agentDBModel.get().getId());
            sessionDBModel.get().setAgentName(agentDBModel.get().getUserName());
            sessionDBModel.get().setSessionState(sessionState);
            sessionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return sessionHelper.mapSessionWSDTO(sessionRepository.save(sessionDBModel.get()));
        }
        return null;
    }

    public SessionWSDTO removeCampaignManualClientService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            sessionRepository.delete(sessionDBModel.get());
            Optional<ClientDBModel> clientDBModel = clientRepository.findById(sessionDBModel.get().getClientId());
            if (clientDBModel.isPresent()){
                clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
                clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                clientRepository.save(clientDBModel.get());
            }
            List<OperationDBModel> operationDBModels = operationRepository.findBySessionIdAndClientId(sessionId,sessionDBModel.get().getClientId());
            if (!operationDBModels.isEmpty()){
                operationRepository.delete(operationDBModels.get(0));
            }
            return sessionHelper.mapSessionWSDTO(sessionDBModel.get());
        }
        return null;
    }


}
