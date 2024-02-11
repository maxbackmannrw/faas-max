package com.faas.core.api.framework.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.OperationSmsMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSmsChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.rest.service.channel.sms.SmsRestService;
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
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationSmsWSDTO> apiGetOperationSmssService(long agentId,String operationId) {

        List<ApiOperationSmsWSDTO> smsMessageWSDTOS = new ArrayList<>();

        return smsMessageWSDTOS;
    }


    public ApiOperationSmsWSDTO apiGetOperationSmsService(long agentId,String operationId,String smsId) {


        return null;
    }


    public ApiOperationSmsWSDTO apiSendOperationSmsService(long agentId,String operationId,String smsTempId,String numberId) throws IOException {

        return null;
    }


    public ApiOperationSmsWSDTO apiUpdateOperationSmsService(long agentId,String operationId,String smsId,String smsState) {


        return null;
    }


    public ApiOperationSmsWSDTO apiRemoveOperationSmsService(long agentId,String operationId,String smsId) {

        return null;
    }



    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempsService(long agentId,String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationSmsTempWSDTO smsTempWSDTO = new ApiOperationSmsTempWSDTO();
            smsTempWSDTO.setSmsAccount(channelHelper.getApiSmsAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                smsTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            smsTempWSDTO.setOperationSmsTemps(processSmsMessageTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));
            return smsTempWSDTO;
        }
        return null;
    }


    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempService(long agentId,String operationId,String smsTempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationSmsTempWSDTO smsTempWSDTO = new ApiOperationSmsTempWSDTO();
            smsTempWSDTO.setSmsAccount(channelHelper.getApiSmsAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                smsTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            smsTempWSDTO.setOperationSmsTemps(processSmsMessageTempRepository.findByIdAndProcessId(smsTempId,sessionDBModels.get(0).getProcessId()));
            return smsTempWSDTO;
        }
        return null;
    }



}
