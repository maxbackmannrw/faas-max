package com.faas.core.api.framework.operation.channel.call;

import com.faas.core.api.model.ws.operation.channel.call.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.OperationSipCallRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.channel.ChannelHelper;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationSipFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSipChannelWSDTO apiGetOperationSipChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelper.getApiOperationSipChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public ApiOperationSipAccountWSDTO apiGetOperationSipAccountService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return channelHelper.getApiOperationSipAccountWSDTO(agentId, operationDBModels.get(0).getCampaignId());
        }
        return null;
    }


    public List<ApiOperationSipCallWSDTO> apiGetOperationSipCallsService(long agentId, String operationId) {

        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();
        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByOperationIdAndAgentId(operationId, agentId);
        for (OperationSipCallDBModel operationSipCallDBModel : operationSipCallDBModels) {
            operationSipCallWSDTOS.add(new ApiOperationSipCallWSDTO(operationSipCallDBModel));
        }
        return operationSipCallWSDTOS;
    }

    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId, String operationId, String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationId(callId, operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            return new ApiOperationSipCallWSDTO(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiCreateOperationSipCallService(long agentId, String operationId, String numberId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return channelHelper.createOperationSipCallHelper(operationDBModels.get(0), numberId);
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiStartOperationSipCallService(long agentId, String operationId, String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationIdAndAgentId(callId, operationId, agentId);
        if (!operationSipCallDBModels.isEmpty()) {
            return channelHelper.startOperationSipCallHelper(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiCancelOperationSipCallService(long agentId, String operationId, String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationIdAndAgentId(callId, operationId, agentId);
        if (!operationSipCallDBModels.isEmpty()) {
            return channelHelper.cancelOperationSipCallHelper(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiHangupOperationSipCallService(long agentId, String operationId, String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationIdAndAgentId(callId, operationId, agentId);
        if (!operationSipCallDBModels.isEmpty()) {
            return channelHelper.hangUpOperationSipCallHelper(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiUpdateOperationSipCallService(long agentId, String operationId, String callId, String callState) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationId(callId, operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            operationSipCallDBModels.get(0).setCallState(callState);
            operationSipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationSipCallWSDTO(operationSipCallRepository.save(operationSipCallDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiRemoveOperationSipCallService(long agentId, String operationId, String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationId(callId, operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            operationSipCallRepository.delete(operationSipCallDBModels.get(0));
            return new ApiOperationSipCallWSDTO(operationSipCallDBModels.get(0));
        }
        return null;
    }


}
