package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiPushAccountWSDTO;
import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsMessageDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationWappMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.content.dao.EmailAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.PushAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.SmsAccountDAO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.rest.service.channel.sms.SmsRestService;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ChannelHelper {


    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    OperationEmailMessageRepository operationEmailMessageRepository;

    @Autowired
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    SmsRestService smsRestService;

    @Autowired
    AppUtils appUtils;


    public OperationSmsMessageDAO createSmsMessageDAO(ProcessSmsMessageTempDBModel processSmsMessageTempDBModel, ProcessSmsChannelDBModel processSmsChannelDBModel){

        OperationSmsMessageDAO operationSmsMessageDAO = new OperationSmsMessageDAO();

        operationSmsMessageDAO.setTempId(processSmsMessageTempDBModel.getId());
        operationSmsMessageDAO.setAccountId(processSmsChannelDBModel.getAccountId());
        operationSmsMessageDAO.setSmsTitle(processSmsMessageTempDBModel.getSmsTitle());
        operationSmsMessageDAO.setSmsBody(processSmsMessageTempDBModel.getSmsBody());
        operationSmsMessageDAO.setSenderId(processSmsMessageTempDBModel.getSenderId());
        operationSmsMessageDAO.setMessageMaps(new HashMap<>());
        operationSmsMessageDAO.setMessageType(processSmsMessageTempDBModel.getMessageType());
        operationSmsMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return operationSmsMessageDAO;
    }


    public OperationWappMessageDAO createWappMessageDAO(ProcessWappMessageTempDBModel processWappMessageTempDBModel, UserDetailsDBModel agentDetails){

        OperationWappMessageDAO operationWappMessageDAO = new OperationWappMessageDAO();
        operationWappMessageDAO.setTempId(processWappMessageTempDBModel.getId());
        operationWappMessageDAO.setAccountId(agentDetails.getWappChannel().getAccountId());
        operationWappMessageDAO.setWappTitle(processWappMessageTempDBModel.getWappTitle());
        operationWappMessageDAO.setWappBody(processWappMessageTempDBModel.getWappBody());
        operationWappMessageDAO.setMessageMaps(new HashMap<>());
        operationWappMessageDAO.setMessageType(processWappMessageTempDBModel.getMessageType());
        operationWappMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return operationWappMessageDAO;
    }


    public ApiOperationSipCallWSDTO getApiOperationSipCallWSDTO(long agentId, long sessionId,long clientId,String processId){

        ApiOperationSipCallWSDTO operationSipCallWSDTO = new ApiOperationSipCallWSDTO();

        return operationSipCallWSDTO;
    }


    public ApiSipAccountWSDTO getApiSipAccountWSDTO(long agentId, String processId) {

        List<ProcessSipChannelDBModel> sipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        if (!sipChannelDBModels.isEmpty() && !agentDetails.isEmpty() && agentDetails.get(0).getSipChannel() != null) {

            ApiSipAccountWSDTO sipAccountWSDTO = new ApiSipAccountWSDTO();

            sipAccountWSDTO.setAccountId(agentDetails.get(0).getSipChannel().getAccountId());
            sipAccountWSDTO.setAccount(agentDetails.get(0).getSipChannel().getAccount());
            sipAccountWSDTO.setUserName(agentDetails.get(0).getSipChannel().getUserName());
            sipAccountWSDTO.setAuthUser(agentDetails.get(0).getSipChannel().getAuthUser());
            sipAccountWSDTO.setPassword(agentDetails.get(0).getSipChannel().getPassword());
            sipAccountWSDTO.setSipUrl(agentDetails.get(0).getSipChannel().getSipUrl());
            sipAccountWSDTO.setAccountDatas(agentDetails.get(0).getSipChannel().getAccountDatas());
            sipAccountWSDTO.setProvider(agentDetails.get(0).getSipChannel().getProvider());
            sipAccountWSDTO.setCallerId(sipChannelDBModels.get(0).getCallerId());
            sipAccountWSDTO.setSipStatus(sipChannelDBModels.get(0).getSipStatus());
            sipAccountWSDTO.setcDate(sipChannelDBModels.get(0).getcDate());
            sipAccountWSDTO.setStatus(sipChannelDBModels.get(0).getStatus());

            return sipAccountWSDTO;
        }
        return null;
    }


    public ApiOperationSipCallWSDTO mapApiOperationSipCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {

        ApiSipAccountWSDTO sipAccountWSDTO = getApiSipAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (sipAccountWSDTO != null) {

            ApiOperationSipCallWSDTO operationSipCall = new ApiOperationSipCallWSDTO();

            return operationSipCall;
        }
        return null;
    }


    public ApiWappCallAccountWSDTO getApiWappAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<ProcessWappChannelDBModel> wappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null && !wappChannels.isEmpty()) {

            ApiWappCallAccountWSDTO wappAccountWSDTO = new ApiWappCallAccountWSDTO();

            wappAccountWSDTO.setAccountId(agentDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setAccount(agentDetails.get(0).getWappChannel().getAccount());
            wappAccountWSDTO.setInstanceKey(agentDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(agentDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(agentDetails.get(0).getWappChannel().getServerUrl());
            wappAccountWSDTO.setAccountDatas(agentDetails.get(0).getWappChannel().getAccountDatas());
            wappAccountWSDTO.setCallStatus(wappChannels.get(0).getCallStatus());
            wappAccountWSDTO.setMessageStatus(wappChannels.get(0).getMessageStatus());
            wappAccountWSDTO.setcDate(wappChannels.get(0).getcDate());
            wappAccountWSDTO.setStatus(wappChannels.get(0).getStatus());

            return wappAccountWSDTO;
        }
        return null;
    }


    public ApiOperationWappCallWSDTO mapApiOperationWappCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {

        ApiWappCallAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());

        return null;
    }

    

    public SmsAccountDAO mapProcessSmsAccountDAO(SmsAccountDBModel smsAccountDBModel) {

        SmsAccountDAO smsAccountDAO = new SmsAccountDAO();
        smsAccountDAO.setAccountId(smsAccountDBModel.getId());
        smsAccountDAO.setAccount(smsAccountDBModel.getAccount());
        smsAccountDAO.setUserName(smsAccountDBModel.getUserName());
        smsAccountDAO.setPassword(smsAccountDBModel.getPassword());
        smsAccountDAO.setApiToken(smsAccountDBModel.getApiToken());
        smsAccountDAO.setApiUrl(smsAccountDBModel.getApiUrl());
        if (smsAccountDBModel.getAccountDatas() !=null){
            smsAccountDAO.setAccountDatas(smsAccountDBModel.getAccountDatas());
        }else{
            smsAccountDAO.setAccountDatas(new ArrayList<>());
        }
        smsAccountDAO.setProvider(smsAccountDBModel.getProvider());
        smsAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        smsAccountDAO.setStatus(1);

        return smsAccountDAO;
    }


    public EmailAccountDAO mapProcessEmailAccountDAO(EmailAccountDBModel emailAccountDBModel) {

        EmailAccountDAO emailAccountDAO = new EmailAccountDAO();
        emailAccountDAO.setAccountId(emailAccountDBModel.getId());
        emailAccountDAO.setAccount(emailAccountDBModel.getAccount());
        if (emailAccountDBModel.getAccountDatas() != null){
            emailAccountDAO.setAccountDatas(emailAccountDBModel.getAccountDatas());
        }else {
            emailAccountDAO.setAccountDatas(new ArrayList<>());
        }
        emailAccountDAO.setProvider(emailAccountDBModel.getProvider());
        emailAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        emailAccountDAO.setStatus(1);

        return emailAccountDAO;
    }


    public PushAccountDAO mapProcessPushAccountDAO(PushAccountDBModel pushAccountDBModel) {

        PushAccountDAO pushAccountDAO = new PushAccountDAO();
        pushAccountDAO.setAccountId(pushAccountDBModel.getId());
        pushAccountDAO.setAccount(pushAccountDBModel.getAccount());
        if (pushAccountDBModel.getAccountDatas() != null){
            pushAccountDAO.setAccountDatas(pushAccountDBModel.getAccountDatas());
        }else {
            pushAccountDAO.setAccountDatas(new ArrayList<>());
        }
        pushAccountDAO.setProvider(pushAccountDBModel.getProvider());
        pushAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        pushAccountDAO.setStatus(1);

        return pushAccountDAO;
    }


    public ApiOperationSmsChannelWSDTO mapApiOperationSmsMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {

        ApiOperationSmsChannelWSDTO operationSmsMessageWSDTO = new ApiOperationSmsChannelWSDTO();
        ApiSmsAccountWSDTO smsAccountWSDTO = getApiSmsAccountWSDTO(sessionDBModel.getProcessId());
        if (smsAccountWSDTO != null){
            operationSmsMessageWSDTO.setSmsAccount(smsAccountWSDTO);
        }
        operationSmsMessageWSDTO.setSmsMessages(operationSmsMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationSmsMessageWSDTO.setSmsTemps(processSmsMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

        return operationSmsMessageWSDTO;
    }


    public ApiSmsAccountWSDTO getApiSmsAccountWSDTO(String processId) {

        List<ProcessSmsChannelDBModel>smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!smsChannelDBModels.isEmpty() && smsChannelDBModels.get(0).getSmsAccount() != null) {

            ApiSmsAccountWSDTO smsAccountWSDTO = new ApiSmsAccountWSDTO();
            smsAccountWSDTO.setAccountId(smsChannelDBModels.get(0).getAccountId());
            smsAccountWSDTO.setAccount(smsChannelDBModels.get(0).getSmsAccount().getAccount());
            smsAccountWSDTO.setUserName(smsChannelDBModels.get(0).getSmsAccount().getUserName());
            smsAccountWSDTO.setPassword(smsChannelDBModels.get(0).getSmsAccount().getPassword());
            smsAccountWSDTO.setApiToken(smsChannelDBModels.get(0).getSmsAccount().getApiToken());
            smsAccountWSDTO.setApiUrl(smsChannelDBModels.get(0).getSmsAccount().getApiUrl());
            smsAccountWSDTO.setAccountDatas(smsChannelDBModels.get(0).getSmsAccount().getAccountDatas());
            smsAccountWSDTO.setProvider(smsChannelDBModels.get(0).getSmsAccount().getProvider());
            smsAccountWSDTO.setSmsStatus(smsChannelDBModels.get(0).getSmsStatus());
            smsAccountWSDTO.setcDate(smsChannelDBModels.get(0).getcDate());
            smsAccountWSDTO.setStatus(smsChannelDBModels.get(0).getStatus());

            return smsAccountWSDTO;
        }
        return null;
    }


    public ApiOperationWappMessageChannelWSDTO mapApiOperationWappMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {

        ApiOperationWappMessageChannelWSDTO operationWappMessageWSDTO = new ApiOperationWappMessageChannelWSDTO();
        ApiWappCallAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(),sessionDBModel.getProcessId());

        return operationWappMessageWSDTO;
    }


    public ApiEmailAccountWSDTO getApiEmailAccountWSDTO(String processId) {

        List<ProcessEmailChannelDBModel>emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!emailChannelDBModels.isEmpty() && emailChannelDBModels.get(0).getEmailAccount() != null) {

            ApiEmailAccountWSDTO emailAccountWSDTO = new ApiEmailAccountWSDTO();
            emailAccountWSDTO.setAccountId(emailChannelDBModels.get(0).getAccountId());
            emailAccountWSDTO.setAccount(emailChannelDBModels.get(0).getEmailAccount().getAccount());
            emailAccountWSDTO.setAccountDatas(emailChannelDBModels.get(0).getEmailAccount().getAccountDatas());
            emailAccountWSDTO.setProvider(emailChannelDBModels.get(0).getEmailAccount().getProvider());
            emailAccountWSDTO.setEmailStatus(emailChannelDBModels.get(0).getEmailStatus());
            emailAccountWSDTO.setcDate(emailChannelDBModels.get(0).getcDate());
            emailAccountWSDTO.setStatus(emailChannelDBModels.get(0).getStatus());

            return emailAccountWSDTO;
        }
        return null;
    }


    public ApiOperationEmailWSDTO mapApiOperationEmailWSDTO(SessionDBModel sessionDBModel) {

        ApiOperationEmailWSDTO operationEmailWSDTO = new ApiOperationEmailWSDTO();

        return operationEmailWSDTO;
    }



    public ApiOperationPushChannelWSDTO mapApiOperationPushMessageWSDTO(SessionDBModel sessionDBModel) {

        ApiPushAccountWSDTO pushAccountWSDTO = getApiPushAccountWSDTO(sessionDBModel.getProcessId());
        if (pushAccountWSDTO != null){

            ApiOperationPushChannelWSDTO operationPushMessageWSDTO = new ApiOperationPushChannelWSDTO();
            operationPushMessageWSDTO.setPushAccount(pushAccountWSDTO);
            operationPushMessageWSDTO.setPushMessages(operationPushMessageRepository.findBySessionId(sessionDBModel.getId()));
            operationPushMessageWSDTO.setPushTemps(processPushTempRepository.findByProcessId(sessionDBModel.getProcessId()));

            return operationPushMessageWSDTO;
        }
        return null;
    }


    public ApiPushAccountWSDTO getApiPushAccountWSDTO(String processId) {

        List<ProcessPushChannelDBModel>pushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!pushChannelDBModels.isEmpty() && pushChannelDBModels.get(0).getPushAccount() != null) {

            ApiPushAccountWSDTO pushAccountWSDTO = new ApiPushAccountWSDTO();
            pushAccountWSDTO.setAccountId(pushChannelDBModels.get(0).getAccountId());
            pushAccountWSDTO.setAccount(pushChannelDBModels.get(0).getPushAccount().getAccount());
            pushAccountWSDTO.setAccountDatas(pushChannelDBModels.get(0).getPushAccount().getAccountDatas());
            pushAccountWSDTO.setProvider(pushChannelDBModels.get(0).getPushAccount().getProvider());
            pushAccountWSDTO.setPushStatus(pushChannelDBModels.get(0).getPushStatus());
            pushAccountWSDTO.setcDate(pushChannelDBModels.get(0).getcDate());
            pushAccountWSDTO.setStatus(pushChannelDBModels.get(0).getStatus());

            return pushAccountWSDTO;
        }
        return null;
    }


}
