package com.faas.core.api.framework.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationEmailChannelFramework {


    @Autowired
    ChannelHelper channelHelper;

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


    public List<ApiOperationEmailWSDTO> apiGetOperationEmailsService(long agentId,String operationId) {

        return null;
    }

    public ApiOperationEmailWSDTO apiGetOperationEmailService(long agentId,String operationId,String emailId) {

        return null;
    }

    public ApiOperationEmailWSDTO apiSendOperationEmailService() {

        return null;
    }

    public ApiOperationEmailWSDTO apiUpdateOperationEmailService(long agentId,String operationId,String emailId,String emailState) {

        return null;
    }

    public ApiOperationEmailWSDTO apiRemoveOperationEmailService(long agentId,String operationId,String emailId) {

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

    public ApiOperationEmailTempWSDTO apiGetOperationEmailTempService(long agentId,String operationId,String emailTempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            ApiOperationEmailTempWSDTO emailTempWSDTO = new ApiOperationEmailTempWSDTO();
            emailTempWSDTO.setEmailAccount(channelHelper.getApiEmailAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(sessionDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
                emailTempWSDTO.setClientEmails(clientDetailsDBModels.get(0).getClientEmails());
            }
            emailTempWSDTO.setOperationEmailTemps(processEmailTempRepository.findByIdAndProcessId(emailTempId,sessionDBModels.get(0).getProcessId()));

            return emailTempWSDTO;
        }
        return null;
    }



}
