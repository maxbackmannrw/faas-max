package com.faas.core.api.framework.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationPushDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.PushRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.PushTempRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.channel.ChannelHelpers;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import com.faas.core.utility.handler.channel.push.PushChannelHandler;
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
    PushRepository pushRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationPushChannelWSDTO apiGetOperationPushChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelpers.getApiOperationPushChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationPushAccountWSDTO apiGetOperationPushAccountService(long agentId, String operationId) {


        return null;
    }


    public ApiOperationPushTempWSDTO apiGetOperationPushTempsService(long agentId,String operationId) {

        return null;
    }

    public ApiOperationPushTempWSDTO apiGetOperationPushTempService(long agentId,String operationId,String tempId) {


        return null;
    }


    public List<ApiOperationPushWSDTO> apiGetOperationPushesService(long agentId,String operationId) {

        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();
        List<OperationPushDBModel> operationPushDBModels = pushRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationPushDBModel operationPushDBModel : operationPushDBModels) {
            operationPushWSDTOS.add(new ApiOperationPushWSDTO(operationPushDBModel));
        }
        return operationPushWSDTOS;
    }

    public ApiOperationPushWSDTO apiGetOperationPushService(long agentId,String operationId,String pushId) {

        List<OperationPushDBModel> operationPushDBModels = pushRepository.findByIdAndOperationId(pushId,operationId);
        if (!operationPushDBModels.isEmpty()){

            return new ApiOperationPushWSDTO(operationPushDBModels.get(0));
        }
        return null;
    }

    public ApiOperationPushWSDTO apiSendOperationPushService(long agentId,String operationId,String tempId,String remoteAppId) {


        return null;
    }

    public ApiOperationPushWSDTO apiUpdateOperationPushService(long agentId,String operationId,String pushId,String pushState) {

        List<OperationPushDBModel> operationPushDBModels = pushRepository.findByIdAndOperationId(pushId,operationId);
        if (!operationPushDBModels.isEmpty()){

            operationPushDBModels.get(0).setPushState(pushState);
            operationPushDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationPushWSDTO(pushRepository.save(operationPushDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationPushWSDTO apiRemoveOperationPushService(long agentId,String operationId,String pushId) {

        List<OperationPushDBModel> operationPushDBModels = pushRepository.findByIdAndOperationId(pushId,operationId);
        if (!operationPushDBModels.isEmpty()){

            pushRepository.delete(operationPushDBModels.get(0));
            return new ApiOperationPushWSDTO(operationPushDBModels.get(0));
        }
        return null;
    }


}
