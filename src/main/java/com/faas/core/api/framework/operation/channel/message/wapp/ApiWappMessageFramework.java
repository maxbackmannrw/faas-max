package com.faas.core.api.framework.operation.channel.message.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageWSDTO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessWappChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.rest.service.channel.wapp.WappRestService;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiWappMessageFramework {

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
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessagesService(long agentId, long sessionId) {

        List<SessionDBModel>sessionDBModels =  sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            return null;
        }
        return null;
    }


    public List<ApiWappMessageWSDTO> apiGetWappMessagesService(long agentId,long sessionId,String campaignId, String processId){

        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();
        List<OperationWappMessageDBModel> operationWappMessageDBModels = operationWappMessageRepository.findBySessionIdAndCampaignIdAndProcessId(sessionId,campaignId,processId);
        for (OperationWappMessageDBModel operationWappMessageDBModel : operationWappMessageDBModels) {
            wappMessageWSDTOS.add(new ApiWappMessageWSDTO(operationWappMessageDBModel));
        }
        return wappMessageWSDTOS;
    }


    public ApiWappMessageWSDTO apiGetWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<OperationWappMessageDBModel> operationWappMessageDBModels = operationWappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!operationWappMessageDBModels.isEmpty()){
            return new ApiWappMessageWSDTO(operationWappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageWSDTO apiSendWappMessageService(long agentId,long sessionId,String campaignId,String processId,String tempId,long numberId) throws IOException {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<ProcessWappMessageTempDBModel> processWappMessageTempDBModels = processWappMessageTempRepository.findByIdAndProcessId(tempId,processId);
        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);

        if (!sessionDBModels.isEmpty() && !processWappMessageTempDBModels.isEmpty()  && !agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null
                && !processWappChannelDBModels.isEmpty() && processWappChannelDBModels.get(0).getMessageStatus().equalsIgnoreCase(AppConstant.ACTIVE_STATUS)){

            OperationWappMessageDBModel operationWappMessageDBModel = new OperationWappMessageDBModel();

            operationWappMessageDBModel.setSessionId(sessionId);
            operationWappMessageDBModel.setClientId(sessionDBModels.get(0).getClientId());
            operationWappMessageDBModel.setNumberId(numberId);
            operationWappMessageDBModel.setAgentId(agentId);
            operationWappMessageDBModel.setCampaignId(campaignId);
            operationWappMessageDBModel.setProcessId(processId);
            operationWappMessageDBModel.setWappMessage(channelHelper.createWappMessageDAO(processWappMessageTempDBModels.get(0),agentDetails.get(0)));
            operationWappMessageDBModel.setMessageSentId("");
            operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_READY);
            operationWappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationWappMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationWappMessageDBModel.setStatus(1);

            OperationWappMessageDBModel operationWappMessage = operationWappMessageRepository.save(operationWappMessageDBModel);
            wappRestService.sendWappMessageService(sessionDBModels.get(0),operationWappMessage);

            return new ApiWappMessageWSDTO(operationWappMessage);
        }
        return null;
    }


    public ApiWappMessageWSDTO apiUpdateWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId){

        List<OperationWappMessageDBModel> operationWappMessageDBModels = operationWappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!operationWappMessageDBModels.isEmpty()){
            return new ApiWappMessageWSDTO(operationWappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageWSDTO apiRemoveWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId){

        List<OperationWappMessageDBModel> operationWappMessageDBModels = operationWappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!operationWappMessageDBModels.isEmpty()){
            operationWappMessageRepository.delete(operationWappMessageDBModels.get(0));
            return new ApiWappMessageWSDTO(operationWappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageTempWSDTO apiGetWappMessageTempsService(long agentId,long sessionId,String campaignId,String processId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            ApiWappMessageTempWSDTO wappMessageTempWSDTO = new ApiWappMessageTempWSDTO();
            ApiWappAccountWSDTO wappAccountWSDTO = channelHelper.getApiWappAccountWSDTO(agentId,processId);
            if (wappAccountWSDTO != null){
                wappMessageTempWSDTO.setWappAccount(wappAccountWSDTO);
            }
            wappMessageTempWSDTO.setWappTemps(processWappMessageTempRepository.findByProcessId(processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }


    public ApiWappMessageTempWSDTO apiGetWappMessageTempService(long agentId,long sessionId,String campaignId,String processId,String tempId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            ApiWappMessageTempWSDTO wappMessageTempWSDTO = new ApiWappMessageTempWSDTO();
            ApiWappAccountWSDTO wappAccountWSDTO = channelHelper.getApiWappAccountWSDTO(agentId,processId);
            if (wappAccountWSDTO != null){
                wappMessageTempWSDTO.setWappAccount(wappAccountWSDTO);
            }
            wappMessageTempWSDTO.setWappTemps(processWappMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }


}
