package com.faas.core.api.framework.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessEmailChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.OperationEmailMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessEmailChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import com.faas.core.utils.service.channel.email.EmailChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationEmailChannelFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    EmailChannelService emailChannelService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    OperationEmailMessageRepository operationEmailMessageRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationEmailChannelWSDTO apiGetOperationEmailChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationEmailChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public List<ApiOperationEmailWSDTO> apiGetOperationEmailsService(long agentId,String operationId) {

        List<ApiOperationEmailWSDTO>operationEmailWSDTOS = new ArrayList<>();
        List<OperationEmailMessageDBModel> operationEmailMessages = operationEmailMessageRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationEmailMessageDBModel operationEmailMessage : operationEmailMessages) {
            operationEmailWSDTOS.add(new ApiOperationEmailWSDTO(operationEmailMessage));
        }
        return operationEmailWSDTOS;
    }

    public ApiOperationEmailWSDTO apiGetOperationEmailService(long agentId,String operationId,String emailId) {

        List<OperationEmailMessageDBModel> operationEmailMessages = operationEmailMessageRepository.findByIdAndOperationId(emailId,operationId);
        if (!operationEmailMessages.isEmpty()){
            return new ApiOperationEmailWSDTO(operationEmailMessages.get(0));
        }
        return null;
    }

    public ApiOperationEmailWSDTO apiSendOperationEmailService(long agentId, String operationId,String tempId,String emailAddressId) throws IOException {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){

            ClientEmailDAO clientEmailDAO = channelHelper.fetchClientEmailDAO(sessionDBModels.get(0).getClientId(),emailAddressId);
            List<ProcessEmailTempDBModel> emailTempDBModels = processEmailTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId());
            List<ProcessEmailChannelDBModel> emailChannelDBModels = processEmailChannelRepository.findByProcessId(sessionDBModels.get(0).getProcessId());
            if (clientEmailDAO != null && !emailTempDBModels.isEmpty() && !emailChannelDBModels.isEmpty() ){

                OperationEmailMessageDBModel operationEmailMessageDBModel = channelHelper.createOperationEmailMessageDBModel(sessionDBModels.get(0),clientEmailDAO,emailTempDBModels.get(0),emailChannelDBModels.get(0));
                emailChannelService.sendAsyncEmailService(operationEmailMessageDBModel);
                return new ApiOperationEmailWSDTO(operationEmailMessageDBModel);
            }
        }
        return null;
    }

    public ApiOperationEmailWSDTO apiUpdateOperationEmailService(long agentId,String operationId,String emailId,String emailState) {

        List<OperationEmailMessageDBModel> operationEmailMessages = operationEmailMessageRepository.findByIdAndOperationId(emailId,operationId);
        if (!operationEmailMessages.isEmpty()){
            operationEmailMessages.get(0).setEmailState(emailState);
            operationEmailMessages.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationEmailWSDTO(operationEmailMessageRepository.save(operationEmailMessages.get(0)));
        }
        return null;
    }

    public ApiOperationEmailWSDTO apiRemoveOperationEmailService(long agentId,String operationId,String emailId) {

        List<OperationEmailMessageDBModel> operationEmailMessages = operationEmailMessageRepository.findByIdAndOperationId(emailId,operationId);
        if (!operationEmailMessages.isEmpty()){
            operationEmailMessageRepository.delete(operationEmailMessages.get(0));
            return new ApiOperationEmailWSDTO(operationEmailMessages.get(0));
        }
        return null;
    }


    public ApiOperationEmailTempWSDTO apiGetOperationEmailTempsService(long agentId,String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationEmailTempWSDTO emailTempWSDTO = new ApiOperationEmailTempWSDTO();
            emailTempWSDTO.setEmailAccount(channelHelper.getApiEmailAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
                emailTempWSDTO.setClientEmails(clientDetailsDBModels.get(0).getClientEmails());
            }
            emailTempWSDTO.setOperationEmailTemps(processEmailTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));

            return emailTempWSDTO;
        }
        return null;
    }

    public ApiOperationEmailTempWSDTO apiGetOperationEmailTempService(long agentId,String operationId,String tempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationEmailTempWSDTO emailTempWSDTO = new ApiOperationEmailTempWSDTO();
            emailTempWSDTO.setEmailAccount(channelHelper.getApiEmailAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
                emailTempWSDTO.setClientEmails(clientDetailsDBModels.get(0).getClientEmails());
            }
            emailTempWSDTO.setOperationEmailTemps(processEmailTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId()));

            return emailTempWSDTO;
        }
        return null;
    }


    public ApiOperationEmailAccountWSDTO apiGetOperationEmailAccountService(long agentId, String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.getApiEmailAccountWSDTO(sessionDBModels.get(0).getProcessId());
        }
        return null;
    }



}
