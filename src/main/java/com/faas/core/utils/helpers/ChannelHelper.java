package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiOperationPushMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiPushAccountWSDTO;
import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import com.faas.core.base.model.db.operation.channel.WappCallDBModel;
import com.faas.core.base.model.db.operation.channel.dao.SmsMessageDAO;
import com.faas.core.base.model.db.operation.channel.dao.WappMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.content.dao.EmailAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.PushAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.SmsAccountDAO;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.rest.service.channel.sms.SmsRestService;
import com.faas.core.utils.config.AppConstant;
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
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushMessageRepository pushMessageRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    SmsRestService smsRestService;

    @Autowired
    AppUtils appUtils;


    public SmsMessageDAO createSmsMessageDAO( SmsMessageTempDBModel smsMessageTempDBModel, ProcessSmsChannelDBModel processSmsChannelDBModel){

        SmsMessageDAO smsMessageDAO = new SmsMessageDAO();

        smsMessageDAO.setTempId(smsMessageTempDBModel.getId());
        smsMessageDAO.setAccountId(processSmsChannelDBModel.getAccountId());
        smsMessageDAO.setSmsTitle(smsMessageTempDBModel.getSmsTitle());
        smsMessageDAO.setSmsBody(smsMessageTempDBModel.getSmsBody());
        smsMessageDAO.setSenderId(smsMessageTempDBModel.getSenderId());
        smsMessageDAO.setMessageMaps(new HashMap<>());
        smsMessageDAO.setMessageType(smsMessageTempDBModel.getMessageType());
        smsMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return smsMessageDAO;
    }


    public WappMessageDAO createWappMessageDAO(WappMessageTempDBModel wappMessageTempDBModel, UserDetailsDBModel agentDetails){


        WappMessageDAO wappMessageDAO = new WappMessageDAO();
        wappMessageDAO.setTempId(wappMessageTempDBModel.getId());
        wappMessageDAO.setAccountId(agentDetails.getWappChannel().getAccountId());
        wappMessageDAO.setWappTitle(wappMessageTempDBModel.getWappTitle());
        wappMessageDAO.setWappBody(wappMessageTempDBModel.getWappBody());
        wappMessageDAO.setMessageMaps(new HashMap<>());
        wappMessageDAO.setMessageType(wappMessageTempDBModel.getMessageType());
        wappMessageDAO.setcDate(appUtils.getCurrentTimeStamp());

        return wappMessageDAO;
    }


    public ApiOperationSipCallWSDTO getApiOperationSipCallWSDTO(long agentId, long sessionId,long clientId,String processId){

        ApiOperationSipCallWSDTO operationSipCallWSDTO = new ApiOperationSipCallWSDTO();
        operationSipCallWSDTO.setSipAccount(getApiSipAccountWSDTO(agentId, processId));
        operationSipCallWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
        List<SipCallDBModel> readySipCalls = sipCallRepository.findBySessionIdAndCallState(sessionId, AppConstant.READY_CALL);
        if (!readySipCalls.isEmpty()) {
            operationSipCallWSDTO.setCurrentSipCall(readySipCalls.get(0));
        }
        List<SipCallDBModel> activeSipCalls = sipCallRepository.findBySessionIdAndCallState(sessionId, AppConstant.ACTIVE_CALL);
        if (!activeSipCalls.isEmpty()) {
            operationSipCallWSDTO.setCurrentSipCall(activeSipCalls.get(0));
        }
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


    public ApiOperationSipCallWSDTO mapApiOperationSipCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiSipAccountWSDTO sipAccountWSDTO = getApiSipAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (sipAccountWSDTO != null) {

            ApiOperationSipCallWSDTO operationSipCall = new ApiOperationSipCallWSDTO();
            operationSipCall.setSipAccount(sipAccountWSDTO);
            operationSipCall.setClientPhones(clientPhones);
            List<SipCallDBModel> readySipCalls = sipCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.READY_CALL);
            if (!readySipCalls.isEmpty()) {
                operationSipCall.setCurrentSipCall(readySipCalls.get(0));
            }
            List<SipCallDBModel> activeSipCall = sipCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.ACTIVE_CALL);
            if (!activeSipCall.isEmpty()) {
                operationSipCall.setCurrentSipCall(activeSipCall.get(0));
            }
            operationSipCall.setRecentSipCalls(sipCallRepository.findBySessionId(sessionDBModel.getId()));

            return operationSipCall;
        }
        return null;
    }


    public ApiWappAccountWSDTO getApiWappAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<ProcessWappChannelDBModel> wappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null && !wappChannels.isEmpty()) {

            ApiWappAccountWSDTO wappAccountWSDTO = new ApiWappAccountWSDTO();

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


    public ApiOperationWappCallWSDTO mapApiOperationWappCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiWappAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(), sessionDBModel.getProcessId());
        if (wappAccountWSDTO != null) {
            ApiOperationWappCallWSDTO operationWappCall = new ApiOperationWappCallWSDTO();
            operationWappCall.setWappAccount(wappAccountWSDTO);
            operationWappCall.setClientPhones(clientPhones);
            List<WappCallDBModel> readyWappCalls = wappCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.READY_CALL);
            if (!readyWappCalls.isEmpty()) {
                operationWappCall.setCurrentWappCall(readyWappCalls.get(0));
            }
            List<WappCallDBModel> activeWappCalls = wappCallRepository.findBySessionIdAndCallState(sessionDBModel.getId(), AppConstant.ACTIVE_CALL);
            if (!activeWappCalls.isEmpty()) {
                operationWappCall.setCurrentWappCall(activeWappCalls.get(0));
            }
            operationWappCall.setRecentWappCalls(wappCallRepository.findBySessionId(sessionDBModel.getId()));

            return operationWappCall;
        }
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


    public ApiOperationSmsMessageWSDTO mapApiOperationSmsMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiOperationSmsMessageWSDTO operationSmsMessageWSDTO = new ApiOperationSmsMessageWSDTO();
        ApiSmsAccountWSDTO smsAccountWSDTO = getApiSmsAccountWSDTO(sessionDBModel.getProcessId());
        if (smsAccountWSDTO != null){
            operationSmsMessageWSDTO.setSmsAccount(smsAccountWSDTO);
        }
        operationSmsMessageWSDTO.setPhones(clientPhones);
        operationSmsMessageWSDTO.setSmsMessages(smsMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationSmsMessageWSDTO.setSmsTemps(smsMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

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


    public ApiOperationWappMessageWSDTO mapApiOperationWappMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDBModel> clientPhones) {

        ApiOperationWappMessageWSDTO operationWappMessageWSDTO = new ApiOperationWappMessageWSDTO();
        ApiWappAccountWSDTO wappAccountWSDTO = getApiWappAccountWSDTO(sessionDBModel.getAgentId(),sessionDBModel.getProcessId());
        if (wappAccountWSDTO != null){
            operationWappMessageWSDTO.setWappAccount(wappAccountWSDTO);
        }
        operationWappMessageWSDTO.setPhones(clientPhones);
        operationWappMessageWSDTO.setWappMessages(wappMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationWappMessageWSDTO.setWappTemps(wappMessageTempRepository.findByProcessId(sessionDBModel.getProcessId()));

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
        ApiEmailAccountWSDTO emailAccountWSDTO = getApiEmailAccountWSDTO(sessionDBModel.getProcessId());
        if (emailAccountWSDTO != null){
            operationEmailWSDTO.setEmailAccount(emailAccountWSDTO);
        }
        operationEmailWSDTO.setEmails(clientEmailRepository.findByClientId(sessionDBModel.getClientId()));
        operationEmailWSDTO.setEmailMessages(emailMessageRepository.findBySessionId(sessionDBModel.getId()));
        operationEmailWSDTO.setEmailTemps(emailTempRepository.findByProcessId(sessionDBModel.getProcessId()));

        return operationEmailWSDTO;
    }



    public ApiOperationPushMessageWSDTO mapApiOperationPushMessageWSDTO(SessionDBModel sessionDBModel) {

        ApiPushAccountWSDTO pushAccountWSDTO = getApiPushAccountWSDTO(sessionDBModel.getProcessId());
        if (pushAccountWSDTO != null){

            ApiOperationPushMessageWSDTO operationPushMessageWSDTO = new ApiOperationPushMessageWSDTO();
            operationPushMessageWSDTO.setPushAccount(pushAccountWSDTO);
            operationPushMessageWSDTO.setPushMessages(pushMessageRepository.findBySessionId(sessionDBModel.getId()));
            operationPushMessageWSDTO.setPushTemps(pushTempRepository.findByProcessId(sessionDBModel.getProcessId()));

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
