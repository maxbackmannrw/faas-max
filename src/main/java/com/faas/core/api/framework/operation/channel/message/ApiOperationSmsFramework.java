package com.faas.core.api.framework.operation.channel.message;

import com.faas.core.api.model.ws.operation.channel.message.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.dto.ApiOperationSmsWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationSmsDBModel;
import com.faas.core.data.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.OperationSmsRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.handler.channel.sms.SmsChannelHandler;
import com.faas.core.misc.helpers.channel.ChannelHelper;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationSmsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    SmsChannelHandler smsChannelHandler;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsChannelWSDTO apiGetOperationSmsChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelper.getApiOperationSmsChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationSmsAccountWSDTO apiGetOperationSmsAccountService(long agentId, String operationId) {


        return null;
    }

    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempsService(long agentId, String operationId) {


        return null;
    }


    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempService(long agentId, String operationId, String tempId) {


        return null;
    }


    public List<ApiOperationSmsWSDTO> apiGetOperationSmssService(long agentId, String operationId) {

        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();
        List<OperationSmsDBModel> operationSmsMessages = OperationSmsRepository.findByOperationIdAndAgentId(operationId, agentId);
        for (OperationSmsDBModel operationSmsMessage : operationSmsMessages) {
            operationSmsWSDTOS.add(new ApiOperationSmsWSDTO(operationSmsMessage));
        }
        return operationSmsWSDTOS;
    }

    public ApiOperationSmsWSDTO apiGetOperationSmsService(long agentId, String operationId, String smsId) {

        List<OperationSmsDBModel> operationSmsMessages = OperationSmsRepository.findByIdAndOperationId(smsId, operationId);
        if (!operationSmsMessages.isEmpty()) {
            return new ApiOperationSmsWSDTO(operationSmsMessages.get(0));
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiSendOperationSmsService(long agentId, String operationId, String tempId, String numberId) throws IOException {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            ClientPhoneDAO clientPhoneDAO = channelHelper.fetchClientPhoneDAO(operationDBModels.get(0).getClientId(), numberId);

        }
        return null;
    }

    public ApiOperationSmsWSDTO apiUpdateOperationSmsService(long agentId, String operationId, String smsId, String smsState) {

        List<OperationSmsDBModel> operationSmsMessages = OperationSmsRepository.findByIdAndOperationId(smsId, operationId);
        if (!operationSmsMessages.isEmpty()) {
            operationSmsMessages.get(0).setSmsState(smsState);
            operationSmsMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationSmsWSDTO(OperationSmsRepository.save(operationSmsMessages.get(0)));
        }
        return null;
    }

    public ApiOperationSmsWSDTO apiRemoveOperationSmsService(long agentId, String operationId, String smsId) {

        List<OperationSmsDBModel> operationSmsMessages = OperationSmsRepository.findByIdAndOperationId(smsId, operationId);
        if (!operationSmsMessages.isEmpty()) {
            OperationSmsRepository.delete(operationSmsMessages.get(0));
            return new ApiOperationSmsWSDTO(operationSmsMessages.get(0));
        }
        return null;
    }


}
