package com.faas.core.api.framework.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessWappChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.rest.service.channel.wapp.WappRestService;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationWappMessageChannelFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    WappRestService wappRestService;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;





    public List<ApiOperationWappMessageWSDTO> apiGetOperationWappMessagesService(long agentId,String operationId){

        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        return wappMessageWSDTOS;
    }


    public ApiOperationWappMessageWSDTO apiGetOperationWappMessageService(long agentId,String operationId,String messageId) {


        return null;
    }


    public ApiOperationWappMessageWSDTO apiSendOperationWappMessageService(long agentId,String operationId,String messageTempId,String numberId) throws IOException {

        return null;
    }


    public ApiOperationWappMessageWSDTO apiUpdateOperationWappMessageService(long agentId,String operationId,String messageId,String messageState){


        return null;
    }


    public ApiOperationWappMessageWSDTO apiRemoveOperationWappMessageService(long agentId,String operationId,String messageId){


        return null;
    }


    public List<ApiOperationWappMessageTempWSDTO> apiGetOperationWappMessageTempsService(long agentId,String operationId){

        List<ApiOperationWappMessageTempWSDTO> operationWappTemps = new ArrayList<>();
        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            List<ProcessWappMessageTempDBModel>operationWappMessageTemps =  processWappMessageTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId());
            for (ProcessWappMessageTempDBModel operationWappMessageTemp : operationWappMessageTemps) {
                operationWappTemps.add(new ApiOperationWappMessageTempWSDTO(operationWappMessageTemp));
            }
        }
        return operationWappTemps;
    }


    public ApiOperationWappMessageTempWSDTO apiGetOperationWappMessageTempService(long agentId,String operationId,String messageTempId){

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            List<ProcessWappMessageTempDBModel>operationWappMessageTemps =  processWappMessageTempRepository.findByIdAndProcessId(messageTempId,sessionDBModels.get(0).getProcessId());
           if (!operationWappMessageTemps.isEmpty()){
               return new ApiOperationWappMessageTempWSDTO(operationWappMessageTemps.get(0));
           }
        }
        return null;
    }


}
