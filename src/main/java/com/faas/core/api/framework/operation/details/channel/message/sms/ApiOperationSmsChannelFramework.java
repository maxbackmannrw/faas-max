package com.faas.core.api.framework.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsMessageWSDTO;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.channel.OperationSmsMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSmsChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
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


@Component
public class ApiOperationSmsChannelFramework {


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
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsMessageWSDTO apiGetOperationSmsMessageService(long agentId,long sessionId) {

        List<SessionDBModel>sessionDBModels = sessionRepository.findByIdAndAgentId(sessionId,agentId);
        if (!sessionDBModels.isEmpty()){
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
        List<ProcessSmsMessageTempDBModel> processSmsMessageTempDBModels = processSmsMessageTempRepository.findByIdAndProcessId(tempId,processId);
        List<ProcessSmsChannelDBModel> processSmsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);

        if (!sessionDBModels.isEmpty() && !processSmsMessageTempDBModels.isEmpty()  && !processSmsChannelDBModels.isEmpty()){

            OperationSmsMessageDBModel operationSmsMessageDBModel = new OperationSmsMessageDBModel();
            operationSmsMessageDBModel.setSessionId(sessionId);
            operationSmsMessageDBModel.setClientId(sessionDBModels.get(0).getClientId());
            operationSmsMessageDBModel.setNumberId(numberId);
            operationSmsMessageDBModel.setAgentId(agentId);
            operationSmsMessageDBModel.setCampaignId(campaignId);
            operationSmsMessageDBModel.setProcessId(processId);
            operationSmsMessageDBModel.setSmsMessage(channelHelper.createSmsMessageDAO(processSmsMessageTempDBModels.get(0),processSmsChannelDBModels.get(0)));
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
            smsMessageTempWSDTO.setSmsTemps(processSmsMessageTempRepository.findByProcessId(processId));

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
            smsMessageTempWSDTO.setSmsTemps(processSmsMessageTempRepository.findByIdAndProcessId(tempId,processId));

            return smsMessageTempWSDTO;
        }
        return null;
    }



}
