package com.faas.core.api.framework.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.SipCallRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.channel.ChannelHelpers;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationSipFramework {


    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    ChannelHelpers channelHelpers;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSipChannelWSDTO apiGetOperationSipChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelpers.getApiOperationSipChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public ApiOperationSipAccountWSDTO apiGetOperationSipAccountService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return channelHelpers.getApiOperationSipAccountWSDTO(agentId,operationDBModels.get(0).getCampaignId());
        }
        return null;
    }


    public List<ApiOperationSipCallWSDTO> apiGetOperationSipCallsService(long agentId, String operationId) {

        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();
        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationSipCallDBModel operationSipCallDBModel : operationSipCallDBModels) {
            operationSipCallWSDTOS.add(new ApiOperationSipCallWSDTO(operationSipCallDBModel));
        }
        return operationSipCallWSDTOS;
    }

    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            return new ApiOperationSipCallWSDTO(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiCreateOperationSipCallService(long agentId,String operationId,String numberId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return channelHelpers.createOperationSipCallHelper(operationDBModels.get(0),numberId);
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiStartOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationSipCallDBModels.isEmpty()) {
            return channelHelpers.startOperationSipCallHelper(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiCancelOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationSipCallDBModels.isEmpty()) {
            return channelHelpers.cancelOperationSipCallHelper(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiHangupOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByIdAndOperationIdAndAgentId(callId,operationId,agentId);
        if (!operationSipCallDBModels.isEmpty()) {
            return channelHelpers.hangUpOperationSipCallHelper(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiUpdateOperationSipCallService(long agentId,String operationId,String callId,String callState) {

        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            operationSipCallDBModels.get(0).setCallState(callState);
            operationSipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationSipCallWSDTO(sipCallRepository.save(operationSipCallDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiRemoveOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = sipCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            sipCallRepository.delete(operationSipCallDBModels.get(0));
            return new ApiOperationSipCallWSDTO(operationSipCallDBModels.get(0));
        }
        return null;
    }


}
