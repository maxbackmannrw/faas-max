package com.faas.core.api.framework.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiOperationPushChannelFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationPushWSDTO apiGetPushMessagesService() {

        return null;
    }


    public ApiOperationPushWSDTO apiGetPushMessageService() {

        return null;
    }


    public ApiOperationPushWSDTO apiSendPushMessageService() {

        return null;
    }


    public ApiOperationPushWSDTO apiUpdatePushMessageService() {

        return null;
    }

    public ApiOperationPushWSDTO apiRemovePushMessageService() {

        return null;
    }


    public ApiOperationPushTempWSDTO apiGetOperationPushTempsService(long agentId,String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationPushTempWSDTO pushTempWSDTO = new ApiOperationPushTempWSDTO();
            pushTempWSDTO.setPushAccount(channelHelper.getApiPushAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            pushTempWSDTO.setOperationPushTemps(processPushTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));

            return pushTempWSDTO;
        }
        return null;
    }

    public ApiOperationPushTempWSDTO apiGetOperationPushTempService(long agentId,String operationId,String pushTempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationPushTempWSDTO pushTempWSDTO = new ApiOperationPushTempWSDTO();
            pushTempWSDTO.setPushAccount(channelHelper.getApiPushAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            pushTempWSDTO.setOperationPushTemps(processPushTempRepository.findByIdAndProcessId(pushTempId,sessionDBModels.get(0).getProcessId()));

            return pushTempWSDTO;
        }
        return null;
    }

}
