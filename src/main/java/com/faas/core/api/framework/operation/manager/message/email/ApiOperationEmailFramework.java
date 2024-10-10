package com.faas.core.api.framework.operation.manager.message.email;

import com.faas.core.api.model.ws.operation.manager.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.manager.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.api.model.ws.operation.manager.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationEmailDBModel;
import com.faas.core.data.repo.campaign.details.temp.EmailTempRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.OperationEmailRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.handler.channel.email.EmailChannelHandler;
import com.faas.core.misc.helpers.channel.ChannelHelper;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationEmailFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    EmailChannelHandler emailChannelHandler;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationEmailChannelWSDTO apiGetOperationEmailChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {

            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelper.getApiOperationEmailChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


    public ApiOperationEmailAccountWSDTO apiGetOperationEmailAccountService(long agentId, String operationId) {


        return null;
    }


    public ApiOperationEmailTempWSDTO apiGetOperationEmailTempsService(long agentId, String operationId) {


        return null;
    }

    public ApiOperationEmailTempWSDTO apiGetOperationEmailTempService(long agentId, String operationId, String tempId) {


        return null;
    }


    public List<ApiOperationEmailWSDTO> apiGetOperationEmailsService(long agentId, String operationId) {

        List<ApiOperationEmailWSDTO> operationEmailWSDTOS = new ArrayList<>();
        List<OperationEmailDBModel> operationEmailMessages = operationEmailRepository.findByOperationIdAndAgentId(operationId, agentId);
        for (OperationEmailDBModel operationEmailMessage : operationEmailMessages) {
            operationEmailWSDTOS.add(new ApiOperationEmailWSDTO(operationEmailMessage));
        }
        return operationEmailWSDTOS;
    }

    public ApiOperationEmailWSDTO apiGetOperationEmailService(long agentId, String operationId, String emailId) {

        List<OperationEmailDBModel> operationEmailMessages = operationEmailRepository.findByIdAndOperationId(emailId, operationId);
        if (!operationEmailMessages.isEmpty()) {
            return new ApiOperationEmailWSDTO(operationEmailMessages.get(0));
        }
        return null;
    }

    public ApiOperationEmailWSDTO apiSendOperationEmailService(long agentId, String operationId, String tempId, String emailAddressId) throws IOException {


        return null;
    }

    public ApiOperationEmailWSDTO apiUpdateOperationEmailService(long agentId, String operationId, String emailId, String emailState) {

        List<OperationEmailDBModel> operationEmailMessages = operationEmailRepository.findByIdAndOperationId(emailId, operationId);
        if (!operationEmailMessages.isEmpty()) {

            operationEmailMessages.get(0).setEmailState(emailState);
            operationEmailMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationEmailWSDTO(operationEmailRepository.save(operationEmailMessages.get(0)));
        }
        return null;
    }

    public ApiOperationEmailWSDTO apiRemoveOperationEmailService(long agentId, String operationId, String emailId) {

        List<OperationEmailDBModel> operationEmailMessages = operationEmailRepository.findByIdAndOperationId(emailId, operationId);
        if (!operationEmailMessages.isEmpty()) {
            operationEmailRepository.delete(operationEmailMessages.get(0));
            return new ApiOperationEmailWSDTO(operationEmailMessages.get(0));
        }
        return null;
    }


}
