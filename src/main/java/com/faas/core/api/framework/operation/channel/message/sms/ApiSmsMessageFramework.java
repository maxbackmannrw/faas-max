package com.faas.core.api.framework.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.details.channel.OperationSmsMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSmsChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.rest.service.channel.sms.SmsRestService;
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
public class ApiSmsMessageFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SmsRestService smsRestService;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsMessageWSDTO apiGetOperationSmsMessageService(long agentId,long sessionId) {

        List<SessionDBModel>sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.mapApiOperationSmsMessageWSDTO(sessionDBModels.get(0),clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
        }
        return null;
    }


    public List<ApiSmsMessageWSDTO> apiGetSmsMessagesService(long agentId,long sessionId,String campaignId,String processId) {

        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = new ArrayList<>();
        List<OperationSmsMessageDBModel> operationSmsMessageDBModels = operationSmsMessageRepository.findBySessionIdAndCampaignIdAndProcessId(sessionId,campaignId,processId);
        for (OperationSmsMessageDBModel operationSmsMessageDBModel : operationSmsMessageDBModels) {
            smsMessageWSDTOS.add(new ApiSmsMessageWSDTO(operationSmsMessageDBModel));
        }
        return smsMessageWSDTOS;
    }


    public ApiSmsMessageWSDTO apiGetSmsMessageService(long agentId,long sessionId,String campaignId, String processId,String messageId) {

        List<OperationSmsMessageDBModel> operationSmsMessageDBModels = operationSmsMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!operationSmsMessageDBModels.isEmpty()) {
            return new ApiSmsMessageWSDTO(operationSmsMessageDBModels.get(0));
        }
        return null;
    }


    public ApiSmsMessageWSDTO apiSendSmsMessageService(long agentId,long sessionId,String campaignId,String processId,String tempId,long numberId) throws IOException {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        List<SmsMessageTempDBModel>smsMessageTempDBModels = smsMessageTempRepository.findByIdAndProcessId(tempId,processId);
        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);

        if (!sessionDBModels.isEmpty() && !smsMessageTempDBModels.isEmpty() && clientPhoneDBModel.isPresent() && !processSmsChannelDBModels.isEmpty()){

            OperationSmsMessageDBModel operationSmsMessageDBModel = new OperationSmsMessageDBModel();
            operationSmsMessageDBModel.setSessionId(sessionId);
            operationSmsMessageDBModel.setClientId(sessionDBModels.get(0).getClientId());
            operationSmsMessageDBModel.setNumberId(numberId);
            operationSmsMessageDBModel.setPhoneNumber(clientPhoneDBModel.get().getPhoneNumber());
            operationSmsMessageDBModel.setAgentId(agentId);
            operationSmsMessageDBModel.setCampaignId(campaignId);
            operationSmsMessageDBModel.setProcessId(processId);
            operationSmsMessageDBModel.setSmsMessage(channelHelper.createSmsMessageDAO(smsMessageTempDBModels.get(0),processSmsChannelDBModels.get(0)));
            operationSmsMessageDBModel.setMessageSentId("");
            operationSmsMessageDBModel.setMessageState(AppConstant.MESSAGE_READY);
            operationSmsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationSmsMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationSmsMessageDBModel.setStatus(1);

            OperationSmsMessageDBModel operationSmsMessage = operationSmsMessageRepository.save(operationSmsMessageDBModel);
            smsRestService.sendSmsMessageService(sessionDBModels.get(0),operationSmsMessage);

            return new ApiSmsMessageWSDTO(operationSmsMessage);
        }
        return null;
    }


    public ApiSmsMessageWSDTO apiUpdateSmsMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<OperationSmsMessageDBModel> operationSmsMessageDBModels = operationSmsMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!operationSmsMessageDBModels.isEmpty()) {
            return new ApiSmsMessageWSDTO(operationSmsMessageDBModels.get(0));
        }
        return null;
    }


    public ApiSmsMessageWSDTO apiRemoveSmsMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<OperationSmsMessageDBModel> operationSmsMessageDBModels = operationSmsMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!operationSmsMessageDBModels.isEmpty()) {
            operationSmsMessageRepository.delete(operationSmsMessageDBModels.get(0));
            return new ApiSmsMessageWSDTO(operationSmsMessageDBModels.get(0));
        }
        return null;
    }



    public ApiSmsMessageTempWSDTO apiGetSmsMessageTempsService(long agentId,long sessionId,String campaignId,String processId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            ApiSmsMessageTempWSDTO smsMessageTempWSDTO = new ApiSmsMessageTempWSDTO();
            ApiSmsAccountWSDTO smsAccountWSDTO = channelHelper.getApiSmsAccountWSDTO(processId);
            if (smsAccountWSDTO != null){
                smsMessageTempWSDTO.setSmsAccount(smsAccountWSDTO);
            }
            smsMessageTempWSDTO.setPhones(clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
            smsMessageTempWSDTO.setSmsTemps(smsMessageTempRepository.findByProcessId(processId));

            return smsMessageTempWSDTO;
        }
        return null;
    }


    public ApiSmsMessageTempWSDTO apiGetSmsMessageTempService(long agentId,long sessionId,String campaignId,String processId,String tempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
            ApiSmsMessageTempWSDTO smsMessageTempWSDTO = new ApiSmsMessageTempWSDTO();
            ApiSmsAccountWSDTO smsAccountWSDTO = channelHelper.getApiSmsAccountWSDTO(processId);
            if (smsAccountWSDTO != null){
                smsMessageTempWSDTO.setSmsAccount(smsAccountWSDTO);
            }
            smsMessageTempWSDTO.setPhones(clientPhoneRepository.findByClientId(sessionDBModels.get(0).getClientId()));
            smsMessageTempWSDTO.setSmsTemps(smsMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return smsMessageTempWSDTO;
        }
        return null;
    }



}
