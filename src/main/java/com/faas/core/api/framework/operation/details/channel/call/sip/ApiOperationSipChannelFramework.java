package com.faas.core.api.framework.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.repo.operation.details.channel.OperationSipCallRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationSipChannelFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationSipCallWSDTO> apiGetOperationSipCallsService(long agentId, String operationId) {

        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        return operationSipCallWSDTOS;
    }


    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId,String operationId,long callId) {


        return null;
    }


    public ApiOperationSipCallWSDTO apiCreateOperationSipCallService(long agentId,String operationId,String numberId) {


        return null;
    }


    public ApiOperationSipCallWSDTO apiMakeOperationSipCallService(long agentId,String operationId,long callId) {


        return null;
    }


    public ApiOperationSipCallWSDTO apiEndOperationSipCallService(long agentId,String operationId,long callId) {


        return null;
    }


    public ApiOperationSipCallWSDTO apiFinishOperationSipCallService(long agentId,String operationId,long callId) {


        return null;
    }



    public ApiOperationSipCallWSDTO apiUpdateOperationSipCallService(long agentId,String operationId,long callId,String callState) {

        return null;
    }



    public ApiOperationSipCallWSDTO apiRemoveOperationSipCallService(long agentId,String operationId,long callId) {


        return null;
    }



}
