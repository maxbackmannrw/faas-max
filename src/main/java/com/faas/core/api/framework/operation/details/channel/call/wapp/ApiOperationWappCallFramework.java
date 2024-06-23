package com.faas.core.api.framework.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.WappCallRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.channel.ChannelHelper;
import com.faas.core.utility.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappCallFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappCallChannelWSDTO apiGetOperationWappCallChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationWappCallChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public ApiOperationWappCallAccountWSDTO apiGetOperationWappCallAccountService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return channelHelper.getApiOperationWappCallAccountWSDTO(agentId,operationDBModels.get(0).getProcessId());
        }
        return null;
    }


    public List<ApiOperationWappCallWSDTO> apiGetOperationWappCallsService(long agentId, String operationId) {

        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();
        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationWappCallDBModel operationWappCallDBModel : operationWappCallDBModels) {
            operationWappCallWSDTOS.add(new ApiOperationWappCallWSDTO(operationWappCallDBModel));
        }
        return operationWappCallWSDTOS;
    }

    public ApiOperationWappCallWSDTO apiGetOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationWappCallDBModels.isEmpty()) {
            return new ApiOperationWappCallWSDTO(operationWappCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiCreateOperationWappCallService(long agentId,String operationId,String numberId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return channelHelper.createOperationWappCallHelper(operationDBModels.get(0),numberId);
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiStartOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationWappCallDBModels.isEmpty()) {
            return channelHelper.startOperationWappCallHelper(operationWappCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiCancelOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationWappCallDBModels.isEmpty()) {
            return channelHelper.cancelOperationWappCallHelper(operationWappCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiHangUpOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationWappCallDBModels.isEmpty()) {
            return channelHelper.hangUpOperationWappCallHelper(operationWappCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiUpdateOperationWappCallService(long agentId,String operationId,String callId,String callState) {

        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationWappCallDBModels.isEmpty()) {
            operationWappCallDBModels.get(0).setCallState(callState);
            operationWappCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationWappCallWSDTO(wappCallRepository.save(operationWappCallDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiRemoveOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationWappCallDBModels.isEmpty()) {
            wappCallRepository.delete(operationWappCallDBModels.get(0));
            return new ApiOperationWappCallWSDTO(operationWappCallDBModels.get(0));
        }
        return null;
    }



}
