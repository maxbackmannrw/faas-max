package com.faas.core.api.framework.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
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
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsChannelWSDTO apiGetOperationSmsChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationSmsChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public List<ApiOperationSmsWSDTO> apiGetOperationSmssService(long agentId,String operationId) {

        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();
        List<OperationSmsMessageDBModel> operationSmsMessages = operationSmsMessageRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationSmsMessageDBModel operationSmsMessage : operationSmsMessages) {
            operationSmsWSDTOS.add(new ApiOperationSmsWSDTO(operationSmsMessage));
        }
        return operationSmsWSDTOS;
    }

    public ApiOperationSmsWSDTO apiGetOperationSmsService(long agentId,String operationId,String smsId) {

        List<OperationSmsMessageDBModel> operationSmsMessages = operationSmsMessageRepository.findByIdAndOperationId(smsId,operationId);
        if (!operationSmsMessages.isEmpty()){
            return new ApiOperationSmsWSDTO(operationSmsMessages.get(0));
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiSendOperationSmsService(long agentId,String operationId,String tempId,String numberId) throws IOException {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ClientPhoneDAO clientPhoneDAO = channelHelper.fetchClientPhoneDAO(sessionDBModels.get(0).getClientId(),numberId);
            List<ProcessSmsMessageTempDBModel> smsMessageTempDBModels = processSmsMessageTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId());
            List<ProcessSmsChannelDBModel> smsChannelDBModels = processSmsChannelRepository.findByProcessId(sessionDBModels.get(0).getProcessId());
            if (clientPhoneDAO != null && !smsMessageTempDBModels.isEmpty() && !smsChannelDBModels.isEmpty() ){

                OperationSmsMessageDBModel smsMessageDBModel = channelHelper.createOperationSmsMessageDBModel(sessionDBModels.get(0),clientPhoneDAO,smsMessageTempDBModels.get(0),smsChannelDBModels.get(0));

                return new ApiOperationSmsWSDTO(smsMessageDBModel);           }
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiUpdateOperationSmsService(long agentId,String operationId,String smsId,String smsState) {

        List<OperationSmsMessageDBModel> operationSmsMessages = operationSmsMessageRepository.findByIdAndOperationId(smsId,operationId);
        if (!operationSmsMessages.isEmpty()){
            operationSmsMessages.get(0).setSmsState(smsState);
            operationSmsMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationSmsWSDTO(operationSmsMessageRepository.save(operationSmsMessages.get(0)));
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiRemoveOperationSmsService(long agentId,String operationId,String smsId) {

        List<OperationSmsMessageDBModel> operationSmsMessages = operationSmsMessageRepository.findByIdAndOperationId(smsId,operationId);
        if (!operationSmsMessages.isEmpty()){
            operationSmsMessageRepository.delete(operationSmsMessages.get(0));
            return new ApiOperationSmsWSDTO(operationSmsMessages.get(0));
        }
        return null;
    }


    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempsService(long agentId,String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationSmsTempWSDTO smsTempWSDTO = new ApiOperationSmsTempWSDTO();
            smsTempWSDTO.setSmsAccount(channelHelper.getApiOperationSmsAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                smsTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            smsTempWSDTO.setOperationSmsTemps(processSmsMessageTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));

            return smsTempWSDTO;
        }
        return null;
    }


    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempService(long agentId,String operationId,String tempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationSmsTempWSDTO smsTempWSDTO = new ApiOperationSmsTempWSDTO();
            smsTempWSDTO.setSmsAccount(channelHelper.getApiOperationSmsAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
                smsTempWSDTO.setClientPhones(clientDetailsDBModels.get(0).getClientPhones());
            }
            smsTempWSDTO.setOperationSmsTemps(processSmsMessageTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId()));

            return smsTempWSDTO;
        }
        return null;
    }

    public ApiOperationSmsAccountWSDTO apiGetOperationSmsAccountService(long agentId, String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.getApiOperationSmsAccountWSDTO(sessionDBModels.get(0).getProcessId());
        }
        return null;
    }


}
