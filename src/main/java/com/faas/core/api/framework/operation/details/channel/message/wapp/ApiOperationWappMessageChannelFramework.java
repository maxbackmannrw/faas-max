package com.faas.core.api.framework.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessWappChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.rest.service.channel.wapp.WappRestService;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationWappMessageChannelFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    WappRestService wappRestService;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationWappMessageWSDTO> apiGetOperationWappMessagesService(long agentId,String operationId){

        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();
        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationWappMessageDBModel operationWappMessage : operationWappMessages) {
            wappMessageWSDTOS.add(new ApiOperationWappMessageWSDTO(operationWappMessage));
        }
        return wappMessageWSDTOS;
    }


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessageService(long agentId,String operationId,String messageId) {

        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByIdAndOperationId(messageId,operationId);
        if (!operationWappMessages.isEmpty()){
            return new ApiOperationWappMessageWSDTO(operationWappMessages.get(0));
        }
        return null;
    }


    public ApiOperationWappMessageWSDTO apiSendOperationWappMessageService(long agentId,String operationId,String messageTempId,String numberId) throws IOException {

        return null;
    }


    public ApiOperationWappMessageWSDTO apiUpdateOperationWappMessageService(long agentId,String operationId,String messageId,String messageState){

        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByIdAndOperationId(messageId,operationId);
        if (!operationWappMessages.isEmpty()){
            operationWappMessages.get(0).setMessageState(messageState);
            operationWappMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationWappMessageWSDTO(operationWappMessageRepository.save(operationWappMessages.get(0)));
        }
        return null;
    }


    public ApiOperationWappMessageWSDTO apiRemoveOperationWappMessageService(long agentId,String operationId,String messageId){

        List<OperationWappMessageDBModel> operationWappMessages = operationWappMessageRepository.findByIdAndOperationId(messageId,operationId);
        if (!operationWappMessages.isEmpty()){
            operationWappMessageRepository.delete(operationWappMessages.get(0));
            return new ApiOperationWappMessageWSDTO(operationWappMessages.get(0));
        }
        return null;
    }


    public ApiOperationWappMessageTempWSDTO apiGetOperationWappMessageTempsService(long agentId,String operationId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = new ApiOperationWappMessageTempWSDTO();
            wappMessageTempWSDTO.setWappAccount(channelHelper.getApiWappMessageAccountWSDTO(agentId,sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                wappMessageTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            wappMessageTempWSDTO.setOperationWappMessageTemps(processWappMessageTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));

            return wappMessageTempWSDTO;
        }
        return null;
    }


    public ApiOperationWappMessageTempWSDTO apiGetOperationWappMessageTempService(long agentId,String operationId,String messageTempId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = new ApiOperationWappMessageTempWSDTO();
            wappMessageTempWSDTO.setWappAccount(channelHelper.getApiWappMessageAccountWSDTO(agentId,sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                wappMessageTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            wappMessageTempWSDTO.setOperationWappMessageTemps(processWappMessageTempRepository.findByIdAndProcessId(messageTempId,sessionDBModels.get(0).getProcessId()));

           return wappMessageTempWSDTO;
        }
        return null;
    }



}
