package com.faas.core.api.framework.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationCurrentSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.OperationSipCallRepository;
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
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationSipCallWSDTO> apiGetOperationSipCallsService(long agentId, String operationId) {

        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();
        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationSipCallDBModel operationSipCallDBModel : operationSipCallDBModels) {
            operationSipCallWSDTOS.add(new ApiOperationSipCallWSDTO(operationSipCallDBModel));
        }
        return operationSipCallWSDTOS;
    }

    public ApiOperationSipCallWSDTO apiGetOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            return new ApiOperationSipCallWSDTO(operationSipCallDBModels.get(0));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiCreateOperationSipCallService(long agentId,String operationId,String numberId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return channelHelper.createOperationSipCallHelper(operationDBModels.get(0),numberId);
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiStartOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);

        return null;
    }

    public ApiOperationSipCallWSDTO apiHangUpOperationSipCallService(long agentId,String operationId,String callId) {


        return null;
    }

    public ApiOperationSipCallWSDTO apiUpdateOperationSipCallService(long agentId,String operationId,String callId,String callState) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            operationSipCallDBModels.get(0).setCallState(callState);
            operationSipCallDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationSipCallWSDTO(operationSipCallRepository.save(operationSipCallDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO apiRemoveOperationSipCallService(long agentId,String operationId,String callId) {

        List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByIdAndOperationId(callId,operationId);
        if (!operationSipCallDBModels.isEmpty()) {
            operationSipCallRepository.delete(operationSipCallDBModels.get(0));
            return new ApiOperationSipCallWSDTO(operationSipCallDBModels.get(0));
        }
        return null;
    }


    public ApiOperationCurrentSipCallWSDTO apiGetOperationCurrentSipCallService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){

            ApiOperationSipAccountWSDTO sipAccountWSDTO = channelHelper.getApiOperationSipAccountWSDTO(agentId,operationDBModels.get(0).getProcessId());
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (sipAccountWSDTO != null && !clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){

                ApiOperationCurrentSipCallWSDTO operationCurrentSipCallWSDTO = new ApiOperationCurrentSipCallWSDTO();
                operationCurrentSipCallWSDTO.setSipAccount(sipAccountWSDTO);
                operationCurrentSipCallWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());

                return operationCurrentSipCallWSDTO;
            }
        }
        return null;
    }


    public ApiOperationSipAccountWSDTO apiGetOperationSipAccountService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return channelHelper.getApiOperationSipAccountWSDTO(agentId,operationDBModels.get(0).getProcessId());
        }
        return null;
    }



}
