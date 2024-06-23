package com.faas.core.api.framework.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.SmsRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessSmsChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.handler.channel.sms.SmsChannelHandler;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.channel.ChannelHelpers;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationSmsFramework {

    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    ChannelHelpers channelHelpers;

    @Autowired
    SmsChannelHandler smsChannelHandler;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    SmsRepository SmsRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsChannelWSDTO apiGetOperationSmsChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelpers.getApiOperationSmsChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationSmsAccountWSDTO apiGetOperationSmsAccountService(long agentId, String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            return channelHelpers.getApiOperationSmsAccountWSDTO(sessionDBModels.get(0).getProcessId());
        }
        return null;
    }

    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempsService(long agentId,String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationSmsTempWSDTO smsTempWSDTO = new ApiOperationSmsTempWSDTO();
            smsTempWSDTO.setSmsAccount(channelHelpers.getApiOperationSmsAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                smsTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            smsTempWSDTO.setOperationSmsTemps(smsTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));

            return smsTempWSDTO;
        }
        return null;
    }


    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempService(long agentId,String operationId,String tempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationSmsTempWSDTO smsTempWSDTO = new ApiOperationSmsTempWSDTO();
            smsTempWSDTO.setSmsAccount(channelHelpers.getApiOperationSmsAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                smsTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            smsTempWSDTO.setOperationSmsTemps(smsTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId()));

            return smsTempWSDTO;
        }
        return null;
    }


    public List<ApiOperationSmsWSDTO> apiGetOperationSmssService(long agentId,String operationId) {

        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();
        List<OperationSmsDBModel> operationSmsMessages = SmsRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationSmsDBModel operationSmsMessage : operationSmsMessages) {
            operationSmsWSDTOS.add(new ApiOperationSmsWSDTO(operationSmsMessage));
        }
        return operationSmsWSDTOS;
    }

    public ApiOperationSmsWSDTO apiGetOperationSmsService(long agentId,String operationId,String smsId) {

        List<OperationSmsDBModel> operationSmsMessages = SmsRepository.findByIdAndOperationId(smsId,operationId);
        if (!operationSmsMessages.isEmpty()){
            return new ApiOperationSmsWSDTO(operationSmsMessages.get(0));
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiSendOperationSmsService(long agentId,String operationId,String tempId,String numberId) throws IOException {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            ClientPhoneDAO clientPhoneDAO = channelHelpers.fetchClientPhoneDAO(operationDBModels.get(0).getClientId(),numberId);
            List<SmsTempDBModel> smsTempDBModels = smsTempRepository.findByIdAndProcessId(tempId,operationDBModels.get(0).getProcessId());
            List<ProcessSmsChannelDBModel> smsChannelDBModels = processSmsChannelRepository.findByProcessId(operationDBModels.get(0).getProcessId());
            if (clientPhoneDAO != null && !smsTempDBModels.isEmpty() && !smsChannelDBModels.isEmpty()){
                OperationSmsDBModel operationSmsDBModel = channelHelpers.createOperationSmsModel(operationDBModels.get(0),clientPhoneDAO,smsTempDBModels.get(0),smsChannelDBModels.get(0));
                if (operationSmsDBModel != null){
                    smsChannelHandler.sendAsyncSmsHandler(operationDBModels.get(0), operationSmsDBModel);
                }
                return new ApiOperationSmsWSDTO(operationSmsDBModel);
            }
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiUpdateOperationSmsService(long agentId,String operationId,String smsId,String smsState) {

        List<OperationSmsDBModel> operationSmsMessages = SmsRepository.findByIdAndOperationId(smsId,operationId);
        if (!operationSmsMessages.isEmpty()){
            operationSmsMessages.get(0).setSmsState(smsState);
            operationSmsMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationSmsWSDTO(SmsRepository.save(operationSmsMessages.get(0)));
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiRemoveOperationSmsService(long agentId,String operationId,String smsId) {

        List<OperationSmsDBModel> operationSmsMessages = SmsRepository.findByIdAndOperationId(smsId,operationId);
        if (!operationSmsMessages.isEmpty()){
            SmsRepository.delete(operationSmsMessages.get(0));
            return new ApiOperationSmsWSDTO(operationSmsMessages.get(0));
        }
        return null;
    }


}
