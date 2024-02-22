package com.faas.core.api.framework.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.repo.operation.details.channel.OperationWappCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationWappCallChannelFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappCallWSDTO apiGetOperationGetWappCallsService(long agentId,long sessionId,String campaignId,String processId) {

        return null;
    }

    public ApiOperationWappCallWSDTO apiGetOperationWappCallService(long agentId,long sessionId,long clientId ,long callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();

        return operationWappCallWSDTO;
    }

    public ApiOperationWappCallWSDTO apiCreateOperationWappCallService(long agentId,long sessionId,long clientId,String processId,long numberId) {

        return null;
    }

    public ApiOperationWappCallWSDTO apiUpdateOperationWappCallService(long agentId,long sessionId,long clientId,long callId) {

        ApiOperationWappCallWSDTO operationWappCallWSDTO = new ApiOperationWappCallWSDTO();

        return operationWappCallWSDTO;
    }

    public ApiOperationWappCallWSDTO apiRemoveOperationWappCallService(long agentId,long sessionId,long clientId, long callId) {


        return null;
    }


    public ApiOperationWappCallWSDTO apiGetOperationWappCallAccountService(long agentId,long sessionId,long clientId, long callId) {


        return null;
    }


}
