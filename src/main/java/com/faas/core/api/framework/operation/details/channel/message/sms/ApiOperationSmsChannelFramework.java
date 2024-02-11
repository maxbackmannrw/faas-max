package com.faas.core.api.framework.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessSmsChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
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
    ClientRepository clientRepository;

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


    public ApiOperationSmsChannelWSDTO apiGetOperationSmsChannelService(long agentId,String operationId) {


        return null;
    }


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



    public List<ApiOperationSmsTempWSDTO> apiGetOperationSmsTempsService(long agentId,String operationId) {

        List<ApiOperationSmsTempWSDTO>smsTempWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ProcessSmsMessageTempDBModel> smsMessageTempDBModels = processSmsMessageTempRepository.findByProcessId(operationDBModels.get(0).getId());
            for (ProcessSmsMessageTempDBModel smsMessageTempDBModel : smsMessageTempDBModels) {
                smsTempWSDTOS.add(new ApiOperationSmsTempWSDTO(smsMessageTempDBModel));
            }
        }
        return smsTempWSDTOS;
    }


    public ApiOperationSmsTempWSDTO apiGetOperationSmsTempService(long agentId,String operationId,String smsTempId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ProcessSmsMessageTempDBModel> smsMessageTempDBModels = processSmsMessageTempRepository.findByIdAndProcessId(smsTempId,operationDBModels.get(0).getProcessId());
            if (!smsMessageTempDBModels.isEmpty()){
                return new ApiOperationSmsTempWSDTO(smsMessageTempDBModels.get(0));
            }
        }
        return null;
    }



}
