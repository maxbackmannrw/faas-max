package com.faas.core.api.framework.operation.channel.call.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiWappCallFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappCallWSDTO apiGetOperationWappCallService(long agentId, long sessionId, long clientId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientId);
        if (sessionDBModels.size()>0){
            return channelHelper.mapApiOperationWappCallWSDTO(sessionDBModels.get(0),clientPhoneDBModels);
        }
        return null;
    }


    public ApiOperationWappCallWSDTO apiGetWappCallsService(long agentId,long sessionId,String campaignId,String processId) {


        return null;
    }


    public ApiOperationWappCallWSDTO apiGetWappCallService(long agentId,long sessionId,long clientId ,long callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
        operationWappCallWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (operationWappCallDBModels.size()>0){
            operationWappCallWSDTO.setCurrentWappCall(operationWappCallDBModels.get(0));
        }
        return operationWappCallWSDTO;
    }


    public ApiOperationWappCallWSDTO apiCreateWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;
    }


    public ApiOperationWappCallWSDTO apiUpdateWappCallService(long agentId,long sessionId,long clientId,long callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
        operationWappCallWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (!operationWappCallDBModels.isEmpty()){
            operationWappCallWSDTO.setCurrentWappCall(operationWappCallDBModels.get(0));
        }
        return operationWappCallWSDTO;
    }


    public ApiOperationWappCallWSDTO apiRemoveWappCallService(long agentId,long sessionId,long clientId, long callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (!operationWappCallDBModels.isEmpty()){

            operationWappCallRepository.delete(operationWappCallDBModels.get(0));
            ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
            operationWappCallWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
            operationWappCallWSDTO.setCurrentWappCall(operationWappCallDBModels.get(0));

            return operationWappCallWSDTO;
        }
        return null;
    }



}
