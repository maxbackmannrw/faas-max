package com.faas.core.api.framework.operation.channel.message.sms;

import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsMessageWSDTO;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSmsChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.rest.service.channel.sms.SmsMessageRestService;
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
    SmsMessageRestService smsMessageRestService;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

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
        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findBySessionIdAndCampaignIdAndProcessId(sessionId,campaignId,processId);
        for (SmsMessageDBModel smsMessageDBModel : smsMessageDBModels) {
            smsMessageWSDTOS.add(new ApiSmsMessageWSDTO(smsMessageDBModel));
        }
        return smsMessageWSDTOS;
    }


    public ApiSmsMessageWSDTO apiGetSmsMessageService(long agentId,long sessionId,String campaignId, String processId,String messageId) {

        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!smsMessageDBModels.isEmpty()) {
            return new ApiSmsMessageWSDTO(smsMessageDBModels.get(0));
        }
        return null;
    }


    public ApiSmsMessageWSDTO apiSendSmsMessageService(long agentId,long sessionId,String campaignId,String processId,String tempId,long numberId) throws IOException {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        List<SmsMessageTempDBModel>smsMessageTempDBModels = smsMessageTempRepository.findByIdAndProcessId(tempId,processId);
        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);

        if (!sessionDBModels.isEmpty() && !smsMessageTempDBModels.isEmpty() && clientPhoneDBModel.isPresent() && !processSmsChannelDBModels.isEmpty()){

            SmsMessageDBModel smsMessageDBModel = new SmsMessageDBModel();
            smsMessageDBModel.setSessionId(sessionId);
            smsMessageDBModel.setClientId(sessionDBModels.get(0).getClientId());
            smsMessageDBModel.setNumberId(numberId);
            smsMessageDBModel.setPhoneNumber(clientPhoneDBModel.get().getPhoneNumber());
            smsMessageDBModel.setAgentId(agentId);
            smsMessageDBModel.setCampaignId(campaignId);
            smsMessageDBModel.setProcessId(processId);
            smsMessageDBModel.setSmsMessage(channelHelper.getSmsMessageDAO(smsMessageTempDBModels.get(0),processSmsChannelDBModels.get(0)));
            smsMessageDBModel.setMessageSentId("");
            smsMessageDBModel.setMessageState(AppConstant.MESSAGE_READY);
            smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
            smsMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
            smsMessageDBModel.setStatus(1);

            SmsMessageDBModel operationSmsMessage = smsMessageRepository.save(smsMessageDBModel);
            smsMessageRestService.sendSmsMessageService(sessionDBModels.get(0),operationSmsMessage);

            return new ApiSmsMessageWSDTO(operationSmsMessage);
        }
        return null;
    }


    public ApiSmsMessageWSDTO apiUpdateSmsMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!smsMessageDBModels.isEmpty()) {
            return new ApiSmsMessageWSDTO(smsMessageDBModels.get(0));
        }
        return null;
    }


    public ApiSmsMessageWSDTO apiRemoveSmsMessageService(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        List<SmsMessageDBModel> smsMessageDBModels = smsMessageRepository.findByIdAndSessionIdAndCampaignIdAndProcessId(messageId,sessionId,campaignId,processId);
        if (!smsMessageDBModels.isEmpty()) {
            smsMessageRepository.delete(smsMessageDBModels.get(0));
            return new ApiSmsMessageWSDTO(smsMessageDBModels.get(0));
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
