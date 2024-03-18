package com.faas.core.api.framework.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessWappChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import com.faas.core.utils.service.channel.message.wapp.WappMessageChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappMessageChannelFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    WappMessageChannelService wappMessageChannelService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappMessageChannelWSDTO apiGetOperationWappMessageChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationWappMessageChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

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


    public ApiOperationWappMessageWSDTO apiSendOperationWappMessageService(long agentId,String operationId,String tempId,String numberId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
            ClientPhoneDAO clientPhoneDAO = channelHelper.fetchClientPhoneDAO(sessionDBModels.get(0).getClientId(),numberId);
            List<ProcessWappMessageTempDBModel> wappMessageTempDBModels = processWappMessageTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId());
            List<ProcessWappChannelDBModel> wappChannelDBModels = processWappChannelRepository.findByProcessId(sessionDBModels.get(0).getProcessId());
            if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && clientPhoneDAO != null && !wappMessageTempDBModels.isEmpty() && !wappChannelDBModels.isEmpty() && wappChannelDBModels.get(0).getMessageState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
                OperationWappMessageDBModel operationWappMessageDBModel = channelHelper.createOperationWappMessageDBModel(agentDetails.get(0),sessionDBModels.get(0),clientPhoneDAO,wappMessageTempDBModels.get(0));
                wappMessageChannelService.sendWappMessageService(operationWappMessageDBModel);
                return new ApiOperationWappMessageWSDTO(operationWappMessageDBModel);
            }
        }
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


    public ApiOperationWappMessageTempWSDTO apiGetOperationWappMessageTempService(long agentId,String operationId,String tempId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = new ApiOperationWappMessageTempWSDTO();
            wappMessageTempWSDTO.setWappAccount(channelHelper.getApiWappMessageAccountWSDTO(agentId,sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                wappMessageTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            wappMessageTempWSDTO.setOperationWappMessageTemps(processWappMessageTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId()));

           return wappMessageTempWSDTO;
        }
        return null;
    }


    public ApiOperationWappMessageAccountWSDTO apiGetOperationWappMessageAccountService(long agentId, String operationId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.getApiWappMessageAccountWSDTO(agentId,sessionDBModels.get(0).getProcessId());
        }
        return null;
    }



}
