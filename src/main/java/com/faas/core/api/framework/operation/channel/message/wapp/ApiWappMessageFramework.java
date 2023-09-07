package com.faas.core.api.framework.operation.channel.message.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessWappChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
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
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessagesService(long agentId, long sessionId) {

        List<SessionDBModel>sessionDBModels =  sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.mapApiOperationWappMessageWSDTO(sessionDBModels.get(0),clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
        }
        return null;
    }


    public List<ApiWappMessageWSDTO> apiGetWappMessagesService(long agentId,long sessionId,String campaignId, String processId){

        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();
        List<WappMessageDBModel>wappMessageDBModels = wappMessageRepository.findBySessionIdAndCampaignIdAndProcessId(sessionId,campaignId,processId);
        for (WappMessageDBModel wappMessageDBModel : wappMessageDBModels) {
            wappMessageWSDTOS.add(new ApiWappMessageWSDTO(wappMessageDBModel));
        }
        return wappMessageWSDTOS;
    }


    public ApiWappMessageWSDTO apiGetWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!wappMessageDBModels.isEmpty()){
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageWSDTO apiSendWappMessageService(long agentId,long sessionId,String campaignId,String processId,String tempId,long numberId) throws IOException {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<WappMessageTempDBModel>wappMessageTempDBModels = wappMessageTempRepository.findByIdAndProcessId(tempId,processId);
        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        List<ProcessWappChannelDBModel> processWappChannelDBModels = processWappChannelRepository.findByProcessId(processId);

        if (!sessionDBModels.isEmpty() && !wappMessageTempDBModels.isEmpty() && clientPhoneDBModel.isPresent() && !agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null
                && !processWappChannelDBModels.isEmpty() && processWappChannelDBModels.get(0).getMessageStatus().equalsIgnoreCase(AppConstant.ACTIVE_STATUS)){

            WappMessageDBModel wappMessageDBModel = new WappMessageDBModel();

            wappMessageDBModel.setSessionId(sessionId);
            wappMessageDBModel.setClientId(sessionDBModels.get(0).getClientId());
            wappMessageDBModel.setNumberId(numberId);
            wappMessageDBModel.setPhoneNumber(clientPhoneDBModel.get().getPhoneNumber());
            wappMessageDBModel.setAgentId(agentId);
            wappMessageDBModel.setCampaignId(campaignId);
            wappMessageDBModel.setProcessId(processId);
            wappMessageDBModel.setWappMessage(channelHelper.createWappMessageDAO(wappMessageTempDBModels.get(0),agentDetails.get(0)));
            wappMessageDBModel.setMessageSentId("");
            wappMessageDBModel.setMessageState(AppConstant.MESSAGE_READY);
            wappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
            wappMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
            wappMessageDBModel.setStatus(1);

            WappMessageDBModel operationWappMessage = wappMessageRepository.save(wappMessageDBModel);
            wappRestService.sendWappMessageService(sessionDBModels.get(0),operationWappMessage);

            return new ApiWappMessageWSDTO(operationWappMessage);
        }
        return null;
    }


    public ApiWappMessageWSDTO apiUpdateWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId){

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!wappMessageDBModels.isEmpty()){
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
        }
        return null;
    }


    public ApiWappMessageWSDTO apiRemoveWappMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId){

        List<WappMessageDBModel> wappMessageDBModels = wappMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!wappMessageDBModels.isEmpty()){
            wappMessageRepository.delete(wappMessageDBModels.get(0));
            return new ApiWappMessageWSDTO(wappMessageDBModels.get(0));
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
            wappMessageTempWSDTO.setPhones(clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
            wappMessageTempWSDTO.setWappTemps(wappMessageTempRepository.findByProcessId(processId));

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
            wappMessageTempWSDTO.setPhones(clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
            wappMessageTempWSDTO.setWappTemps(wappMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return wappMessageTempWSDTO;
        }
        return null;
    }


}
