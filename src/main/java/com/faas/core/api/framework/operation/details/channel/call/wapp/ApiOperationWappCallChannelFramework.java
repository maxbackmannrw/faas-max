package com.faas.core.api.framework.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappCallRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationWappCallChannelFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationWappCallWSDTO> apiGetOperationWappCallsService(long agentId, String operationId) {

        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();
        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationWappCallDBModel operationWappCallDBModel : operationWappCallDBModels) {
            operationWappCallWSDTOS.add(new ApiOperationWappCallWSDTO(operationWappCallDBModel));
        }
        return operationWappCallWSDTOS;
    }

    public ApiOperationWappCallWSDTO apiGetOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationWappCallDBModels.isEmpty()) {
            new ApiOperationWappCallWSDTO(operationWappCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiCreateOperationWappCallService(long agentId,String operationId,String numberId) {

        return null;
    }

    public ApiOperationWappCallWSDTO apiStartOperationWappCallService(long agentId,String operationId,String callId) {

        return null;
    }

    public ApiOperationWappCallWSDTO apiHangUpOperationWappCallService(long agentId,String operationId,String callId) {

        return null;
    }

    public ApiOperationWappCallWSDTO apiUpdateOperationWappCallService(long agentId,String operationId,String callId,String callState) {

        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationWappCallDBModels.isEmpty()) {
            operationWappCallDBModels.get(0).setCallState(callState);
            operationWappCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationWappCallWSDTO(operationWappCallRepository.save(operationWappCallDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO apiRemoveOperationWappCallService(long agentId,String operationId,String callId) {

        List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationWappCallDBModels.isEmpty()) {
            operationWappCallRepository.delete(operationWappCallDBModels.get(0));
            new ApiOperationWappCallWSDTO(operationWappCallDBModels.get(0));
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


}
