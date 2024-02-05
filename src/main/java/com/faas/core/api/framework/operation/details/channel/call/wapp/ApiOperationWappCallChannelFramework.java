package com.faas.core.api.framework.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.base.repo.operation.details.channel.OperationWappCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationWappCallChannelFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappCallChannelWSDTO apiGetOperationWappCallChannelService(long agentId, String operationId) {

        return null;
    }


    public ApiOperationWappCallWSDTO apiGetOperationGetWappCallsService(long agentId,long sessionId,String campaignId,String processId) {


        return null;
    }


    public ApiOperationWappCallWSDTO apiGetOperationWappCallService(long agentId,long sessionId,long clientId ,long callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (operationWappCallDBModels.size()>0){
        }
        return operationWappCallWSDTO;
    }


    public ApiOperationWappCallWSDTO apiCreateOperationWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;
    }


    public ApiOperationWappCallWSDTO apiMakeOperationWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;
    }


    public ApiOperationWappCallWSDTO apiEndOperationWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;

    }


    public ApiOperationWappCallWSDTO apiFinishOperationWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;

    }


    public ApiOperationWappCallWSDTO apiUpdateOperationWappCallService(long agentId,long sessionId,long clientId,long callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();
        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (!operationWappCallDBModels.isEmpty()){
        }
        return operationWappCallWSDTO;
    }


    public ApiOperationWappCallWSDTO apiRemoveOperationWappCallService(long agentId,long sessionId,long clientId, long callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndSessionId(callId,sessionId);
        if (!operationWappCallDBModels.isEmpty()){

            operationWappCallRepository.delete(operationWappCallDBModels.get(0));
            ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();

            return operationWappCallWSDTO;
        }
        return null;
    }



}
