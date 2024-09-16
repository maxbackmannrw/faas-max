package com.faas.core.api.framework.operation.details.channel.message.push;

import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationPushDBModel;
import com.faas.core.data.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.OperationPushRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.handler.channel.push.PushChannelHandler;
import com.faas.core.misc.helpers.channel.ChannelHelpers;
import com.faas.core.misc.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationPushFramework {


    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    ChannelHelpers channelHelpers;

    @Autowired
    PushChannelHandler pushChannelHandler;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationPushChannelWSDTO apiGetOperationPushChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelpers.getApiOperationPushChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationPushAccountWSDTO apiGetOperationPushAccountService(long agentId, String operationId) {


        return null;
    }


    public ApiOperationPushTempWSDTO apiGetOperationPushTempsService(long agentId, String operationId) {

        return null;
    }

    public ApiOperationPushTempWSDTO apiGetOperationPushTempService(long agentId, String operationId, String tempId) {


        return null;
    }


    public List<ApiOperationPushWSDTO> apiGetOperationPushesService(long agentId, String operationId) {

        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();
        List<OperationPushDBModel> operationPushDBModels = operationPushRepository.findByOperationIdAndAgentId(operationId, agentId);
        for (OperationPushDBModel operationPushDBModel : operationPushDBModels) {
            operationPushWSDTOS.add(new ApiOperationPushWSDTO(operationPushDBModel));
        }
        return operationPushWSDTOS;
    }

    public ApiOperationPushWSDTO apiGetOperationPushService(long agentId, String operationId, String pushId) {

        List<OperationPushDBModel> operationPushDBModels = operationPushRepository.findByIdAndOperationId(pushId, operationId);
        if (!operationPushDBModels.isEmpty()) {

            return new ApiOperationPushWSDTO(operationPushDBModels.get(0));
        }
        return null;
    }

    public ApiOperationPushWSDTO apiSendOperationPushService(long agentId, String operationId, String tempId, String remoteAppId) {


        return null;
    }

    public ApiOperationPushWSDTO apiUpdateOperationPushService(long agentId, String operationId, String pushId, String pushState) {

        List<OperationPushDBModel> operationPushDBModels = operationPushRepository.findByIdAndOperationId(pushId, operationId);
        if (!operationPushDBModels.isEmpty()) {

            operationPushDBModels.get(0).setPushState(pushState);
            operationPushDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationPushWSDTO(operationPushRepository.save(operationPushDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationPushWSDTO apiRemoveOperationPushService(long agentId, String operationId, String pushId) {

        List<OperationPushDBModel> operationPushDBModels = operationPushRepository.findByIdAndOperationId(pushId, operationId);
        if (!operationPushDBModels.isEmpty()) {

            operationPushRepository.delete(operationPushDBModels.get(0));
            return new ApiOperationPushWSDTO(operationPushDBModels.get(0));
        }
        return null;
    }


}
