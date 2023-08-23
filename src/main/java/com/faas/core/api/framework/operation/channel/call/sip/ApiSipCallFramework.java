package com.faas.core.api.framework.operation.channel.call.sip;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipCallWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SipCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiSipCallFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId,long sessionId,long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientIdAndAgentId(sessionId,clientId,agentId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.getApiOperationSipCallWSDTO(agentId,sessionId,clientId,sessionDBModels.get(0).getProcessId());
        }
        return null;
    }


    public List<ApiSipCallWSDTO> apiGetSipCallsService(long agentId,long sessionId,long clientId) {

        List<ApiSipCallWSDTO> sipCallWSDTOS = new ArrayList<>();
        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findBySessionIdAndClientId(sessionId,clientId);
        for (SipCallDBModel sipCallDBModel : sipCallDBModels) {
            sipCallWSDTOS.add(new ApiSipCallWSDTO(sipCallDBModel));
        }
        return sipCallWSDTOS;
    }


    public ApiSipCallWSDTO apiGetSipCallService(long agentId,long sessionId,long clientId,long callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionIdAndAgentIdAndClientId(callId,sessionId,agentId,clientId);
        if (!sipCallDBModels.isEmpty()) {
            return new ApiSipCallWSDTO(sipCallDBModels.get(0));
        }
        return null;
    }


    public ApiSipCallWSDTO apiCreateSipCallService(long agentId,long sessionId,long clientId,long numberId) {

        List<SessionDBModel> sessionModel = sessionRepository.findByIdAndClientIdAndAgentId(sessionId,clientId,agentId);
        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        ApiSipAccountWSDTO sipAccountWSDTO = channelHelper.getApiSipAccountWSDTO(agentId, sessionModel.get(0).getProcessId());

        if (!sipCallRepository.existsBySessionIdAndCallState(sessionId,AppConstant.READY_CALL) && !sipCallRepository.existsBySessionIdAndCallState(sessionId,AppConstant.ACTIVE_CALL) && !sessionModel.isEmpty() && clientPhoneDBModel.isPresent() && sipAccountWSDTO != null) {

            SipCallDBModel sipCallDBModel = new SipCallDBModel();
            sipCallDBModel.setSessionId(sessionModel.get(0).getId());
            sipCallDBModel.setClientId(sessionModel.get(0).getClientId());
            sipCallDBModel.setAgentId(sessionModel.get(0).getAgentId());
            sipCallDBModel.setCampaignId(sessionModel.get(0).getCampaignId());
            sipCallDBModel.setProcessId(sessionModel.get(0).getProcessId());
            sipCallDBModel.setNumberId(clientPhoneDBModel.get().getId());
            sipCallDBModel.setPhoneNumber(clientPhoneDBModel.get().getPhoneNumber());
            sipCallDBModel.setAccountId(sipAccountWSDTO.getAccountId());
            sipCallDBModel.setCallerId(sipAccountWSDTO.getCallerId());
            sipCallDBModel.setProvider(sipAccountWSDTO.getProvider());
            sipCallDBModel.setConnectionId("");
            sipCallDBModel.setCallState(AppConstant.READY_CALL);
            sipCallDBModel.setsDate(0);
            sipCallDBModel.setfDate(0);
            sipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
            sipCallDBModel.setcDate(appUtils.getCurrentTimeStamp());
            sipCallDBModel.setStatus(1);

            return new ApiSipCallWSDTO(sipCallRepository.save(sipCallDBModel));
        }
        return null;
    }


    public ApiSipCallWSDTO apiStartSipCallService(long agentId,long sessionId,long clientId,long callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionIdAndAgentIdAndClientId(callId,sessionId,agentId,clientId);
        if (!sipCallDBModels.isEmpty() && sipCallDBModels.get(0).getCallState().equalsIgnoreCase(AppConstant.READY_CALL)) {
            sipCallDBModels.get(0).setCallState(AppConstant.ACTIVE_CALL);
            sipCallDBModels.get(0).setsDate(appUtils.getCurrentTimeStamp());
            sipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ApiSipCallWSDTO(sipCallRepository.save(sipCallDBModels.get(0)));
        }
        return null;
    }


    public ApiSipCallWSDTO apiFinishSipCallService(long agentId,long sessionId,long clientId,long callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionIdAndAgentIdAndClientId(callId,sessionId,agentId,clientId);
        if (!sipCallDBModels.isEmpty()) {
            if (sipCallDBModels.get(0).getCallState().equalsIgnoreCase(AppConstant.READY_CALL)){
                sipCallRepository.delete(sipCallDBModels.get(0));
                return new ApiSipCallWSDTO(sipCallDBModels.get(0));
            }
            if (sipCallDBModels.get(0).getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)){
                sipCallDBModels.get(0).setCallState(AppConstant.FINISHED_CALL);
                sipCallDBModels.get(0).setfDate(appUtils.getCurrentTimeStamp());
                sipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

                return new ApiSipCallWSDTO(sipCallRepository.save(sipCallDBModels.get(0)));
            }
        }
        return null;
    }



    public ApiSipCallWSDTO apiUpdateSipCallService(long agentId,long sessionId,long clientId,long callId,String callState) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionIdAndAgentIdAndClientId(callId,sessionId,agentId,clientId);
        if (!sipCallDBModels.isEmpty()) {
            sipCallDBModels.get(0).setCallState(callState);
            if (callState.equalsIgnoreCase(AppConstant.FINISHED_CALL)) {
                sipCallDBModels.get(0).setfDate(appUtils.getCurrentTimeStamp());
            }
            sipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ApiSipCallWSDTO(sipCallRepository.save(sipCallDBModels.get(0)));
        }
        return null;
    }



    public ApiSipCallWSDTO apiRemoveSipCallService(long agentId,long sessionId,long clientId,long callId) {

        List<SipCallDBModel> sipCallDBModels = sipCallRepository.findByIdAndSessionIdAndAgentIdAndClientId(callId,sessionId,agentId,clientId);
        if (!sipCallDBModels.isEmpty()) {
            sipCallRepository.delete(sipCallDBModels.get(0));
            return new ApiSipCallWSDTO(sipCallDBModels.get(0));
        }
        return null;
    }



}
