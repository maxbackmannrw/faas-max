package com.faas.core.api.framework.operation.details.channel.content;

import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiOperationChannelFramework {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationCallChannelWSDTO apiGetOperationCallChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationCallChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationMessageChannelWSDTO apiGetOperationMessageChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationMessageChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }



}
