package com.faas.core.api.framework.operation.details.channel.message.wapp;

import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;
import com.faas.core.data.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.data.repo.user.details.UserDetailsRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.handler.channel.wapp.WappChannelHandler;
import com.faas.core.misc.helpers.channel.ChannelHelpers;
import com.faas.core.misc.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappMessageFramework {


    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    ChannelHelpers channelHelpers;

    @Autowired
    WappChannelHandler wappChannelHandler;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappMessageChannelWSDTO apiGetOperationWappMessageChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelpers.getApiOperationWappMessageChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationWappMessageAccountWSDTO apiGetOperationWappMessageAccountService(long agentId, String operationId) {

        return null;
    }


    public ApiOperationWappMessageTempWSDTO apiGetOperationWappMessageTempsService(long agentId, String operationId) {


        return null;
    }


    public ApiOperationWappMessageTempWSDTO apiGetOperationWappMessageTempService(long agentId, String operationId, String tempId) {

        return null;
    }


    public List<ApiOperationWappMessageWSDTO> apiGetOperationWappMessagesService(long agentId, String operationId) {

        List<ApiOperationWappMessageWSDTO> operationWappMessageWSDTOS = new ArrayList<>();
        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByOperationIdAndAgentId(operationId, agentId);
        for (OperationWappMessageDBModel operationWappMessage : operationWappMessages) {
            operationWappMessageWSDTOS.add(new ApiOperationWappMessageWSDTO(operationWappMessage));
        }
        return operationWappMessageWSDTOS;
    }


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessageService(long agentId, String operationId, String messageId) {

        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByIdAndOperationId(messageId, operationId);
        if (!operationWappMessages.isEmpty()) {
            return new ApiOperationWappMessageWSDTO(operationWappMessages.get(0));
        }
        return null;
    }


    public ApiOperationWappMessageWSDTO apiSendOperationWappMessageService(long agentId, String operationId, String tempId, String numberId) throws IOException {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
            ClientPhoneDAO clientPhoneDAO = channelHelpers.fetchClientPhoneDAO(operationDBModels.get(0).getClientId(), numberId);

        }
        return null;
    }


    public ApiOperationWappMessageWSDTO apiUpdateOperationWappMessageService(long agentId, String operationId, String messageId, String messageState) {

        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByIdAndOperationId(messageId, operationId);
        if (!operationWappMessages.isEmpty()) {
            operationWappMessages.get(0).setMessageState(messageState);
            operationWappMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationWappMessageWSDTO(operationWappMessageRepository.save(operationWappMessages.get(0)));
        }
        return null;
    }


    public ApiOperationWappMessageWSDTO apiRemoveOperationWappMessageService(long agentId, String operationId, String messageId) {

        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByIdAndOperationId(messageId, operationId);
        if (!operationWappMessages.isEmpty()) {
            operationWappMessageRepository.delete(operationWappMessages.get(0));
            return new ApiOperationWappMessageWSDTO(operationWappMessages.get(0));
        }
        return null;
    }


}
