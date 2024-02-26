package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.content.dao.ClientEmailDAO;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.*;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationEmailMessageDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationSipCallDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsMessageDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationWappMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessEmailAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessPushAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessSmsAccountDAO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChannelHelper {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

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
    AppUtils appUtils;


    public ApiOperationSipAccountWSDTO getApiOperationSipAccountWSDTO(long agentId, String processId) {

        List<ProcessSipChannelDBModel> sipChannelDBModels = processSipChannelRepository.findByProcessId(processId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        if (!sipChannelDBModels.isEmpty() && !agentDetails.isEmpty() && agentDetails.get(0).getSipChannel() != null) {

            ApiOperationSipAccountWSDTO operationSipAccountWSDTO = new ApiOperationSipAccountWSDTO();
            operationSipAccountWSDTO.setAccountId(agentDetails.get(0).getSipChannel().getAccountId());
            operationSipAccountWSDTO.setAccount(agentDetails.get(0).getSipChannel().getAccount());
            operationSipAccountWSDTO.setUserName(agentDetails.get(0).getSipChannel().getUserName());
            operationSipAccountWSDTO.setAuthUser(agentDetails.get(0).getSipChannel().getAuthUser());
            operationSipAccountWSDTO.setPassword(agentDetails.get(0).getSipChannel().getPassword());
            operationSipAccountWSDTO.setSipUrl(agentDetails.get(0).getSipChannel().getSipUrl());
            operationSipAccountWSDTO.setAccountDatas(agentDetails.get(0).getSipChannel().getAccountDatas());
            operationSipAccountWSDTO.setProvider(agentDetails.get(0).getSipChannel().getProvider());
            operationSipAccountWSDTO.setCallerId(sipChannelDBModels.get(0).getCallerId());
            operationSipAccountWSDTO.setChannelState(sipChannelDBModels.get(0).getChannelState());
            operationSipAccountWSDTO.setcDate(sipChannelDBModels.get(0).getcDate());
            operationSipAccountWSDTO.setStatus(sipChannelDBModels.get(0).getStatus());

            return operationSipAccountWSDTO;
        }
        return null;
    }

    public ApiOperationSipCallWSDTO createOperationSipCallHelper(OperationDBModel operationDBModel,String numberId){

        OperationSipCallDAO sipCallDAO = createOperationSipCallDAO(operationDBModel,numberId);
        if (sipCallDAO != null && !operationSipCallRepository.existsByOperationIdAndCallState(operationDBModel.getId(),AppConstant.READY_CALL) && !operationSipCallRepository.existsByOperationIdAndCallState(operationDBModel.getId(),AppConstant.ACTIVE_CALL)){

            OperationSipCallDBModel operationSipCallDBModel = new OperationSipCallDBModel();
            operationSipCallDBModel.setClientId(operationDBModel.getClientId());
            operationSipCallDBModel.setSessionId(operationDBModel.getSessionId());
            operationSipCallDBModel.setOperationId(operationDBModel.getId());
            operationSipCallDBModel.setAgentId(operationDBModel.getAgentId());
            operationSipCallDBModel.setCampaignId(operationDBModel.getCampaignId());
            operationSipCallDBModel.setProcessId(operationDBModel.getProcessId());
            operationSipCallDBModel.setSipCall(sipCallDAO);
            operationSipCallDBModel.setCallConnId(AppConstant.NONE);
            operationSipCallDBModel.setCallState(AppConstant.READY_CALL);
            operationSipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationSipCallDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationSipCallDBModel.setStatus(1);

            return new ApiOperationSipCallWSDTO(operationSipCallRepository.save(operationSipCallDBModel));
        }
        return null;
    }

    public OperationSipCallDAO createOperationSipCallDAO(OperationDBModel operationDBModel,String numberId){

        ClientPhoneDAO clientPhoneDAO = fetchClientPhoneDAO(operationDBModel.getClientId(),numberId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(operationDBModel.getAgentId());
        if (clientPhoneDAO != null && !agentDetails.isEmpty() && agentDetails.get(0).getSipChannel() != null){

            OperationSipCallDAO operationSipCallDAO = new OperationSipCallDAO();
            operationSipCallDAO.setNumberId(numberId);
            operationSipCallDAO.setPhoneNumber(clientPhoneDAO.getPhoneNumber());
            operationSipCallDAO.setPhoneCarrier(clientPhoneDAO.getPhoneCarrier());
            operationSipCallDAO.setPhoneType(clientPhoneDAO.getPhoneType());
            operationSipCallDAO.setAccountId(agentDetails.get(0).getSipChannel().getAccountId());
            operationSipCallDAO.setsDate(appUtils.getCurrentTimeStamp());
            operationSipCallDAO.setfDate(appUtils.getCurrentTimeStamp());
            operationSipCallDAO.setStatus(1);

            return operationSipCallDAO;
        }
        return null;
    }

    public OperationSipCallDBModel getApiOperationActiveSipCallHelper(List<OperationSipCallDBModel> operationSipCallDBModels) {

        for (OperationSipCallDBModel operationSipCallDBModel : operationSipCallDBModels) {
            if (operationSipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.READY_CALL) || operationSipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)) {
                return operationSipCallDBModel;
            }
        }
        return null;
    }


    public ApiOperationWappCallAccountWSDTO getApiOperationWappCallAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<ProcessWappChannelDBModel> wappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null && !wappChannels.isEmpty()) {

            ApiOperationWappCallAccountWSDTO wappAccountWSDTO = new ApiOperationWappCallAccountWSDTO();
            wappAccountWSDTO.setAccountId(agentDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setAccount(agentDetails.get(0).getWappChannel().getAccount());
            wappAccountWSDTO.setInstanceKey(agentDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(agentDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(agentDetails.get(0).getWappChannel().getServerUrl());
            wappAccountWSDTO.setAccountDatas(agentDetails.get(0).getWappChannel().getAccountDatas());
            wappAccountWSDTO.setCallState(wappChannels.get(0).getCallState());
            wappAccountWSDTO.setMessageState(wappChannels.get(0).getMessageState());
            wappAccountWSDTO.setcDate(wappChannels.get(0).getcDate());
            wappAccountWSDTO.setStatus(wappChannels.get(0).getStatus());

            return wappAccountWSDTO;
        }
        return null;
    }

    public OperationWappCallDBModel getApiOperationActiveWappCallHelper(List<OperationWappCallDBModel> operationWappCallDBModels) {

        for (OperationWappCallDBModel operationWappCallDBModel : operationWappCallDBModels) {
            if (operationWappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.READY_CALL) || operationWappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)) {
                return operationWappCallDBModel;
            }
        }
        return null;
    }


    public ApiOperationSmsAccountWSDTO getApiOperationSmsAccountWSDTO(String processId) {

        List<ProcessSmsChannelDBModel>smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!smsChannelDBModels.isEmpty() && smsChannelDBModels.get(0).getSmsAccount() != null) {

            ApiOperationSmsAccountWSDTO smsAccountWSDTO = new ApiOperationSmsAccountWSDTO();
            smsAccountWSDTO.setAccountId(smsChannelDBModels.get(0).getSmsAccount().getAccountId());
            smsAccountWSDTO.setAccount(smsChannelDBModels.get(0).getSmsAccount().getAccount());
            smsAccountWSDTO.setUserName(smsChannelDBModels.get(0).getSmsAccount().getUserName());
            smsAccountWSDTO.setPassword(smsChannelDBModels.get(0).getSmsAccount().getPassword());
            smsAccountWSDTO.setApiToken(smsChannelDBModels.get(0).getSmsAccount().getApiToken());
            smsAccountWSDTO.setApiUrl(smsChannelDBModels.get(0).getSmsAccount().getApiUrl());
            smsAccountWSDTO.setAccountDatas(smsChannelDBModels.get(0).getSmsAccount().getAccountDatas());
            smsAccountWSDTO.setProvider(smsChannelDBModels.get(0).getSmsAccount().getProvider());
            smsAccountWSDTO.setChannelState(smsChannelDBModels.get(0).getChannelState());
            smsAccountWSDTO.setcDate(smsChannelDBModels.get(0).getcDate());
            smsAccountWSDTO.setStatus(smsChannelDBModels.get(0).getStatus());

            return smsAccountWSDTO;
        }
        return null;
    }

    public ProcessSmsAccountDAO mapProcessSmsAccountDAO(SmsAccountDBModel smsAccountDBModel) {

        ProcessSmsAccountDAO processSmsAccountDAO = new ProcessSmsAccountDAO();
        processSmsAccountDAO.setAccountId(smsAccountDBModel.getId());
        processSmsAccountDAO.setAccount(smsAccountDBModel.getAccount());
        processSmsAccountDAO.setUserName(smsAccountDBModel.getUserName());
        processSmsAccountDAO.setPassword(smsAccountDBModel.getPassword());
        processSmsAccountDAO.setApiToken(smsAccountDBModel.getApiToken());
        processSmsAccountDAO.setApiUrl(smsAccountDBModel.getApiUrl());
        if (smsAccountDBModel.getAccountDatas() !=null){
            processSmsAccountDAO.setAccountDatas(smsAccountDBModel.getAccountDatas());
        }else{
            processSmsAccountDAO.setAccountDatas(new ArrayList<>());
        }
        processSmsAccountDAO.setProvider(smsAccountDBModel.getProvider());
        processSmsAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        processSmsAccountDAO.setStatus(1);

        return processSmsAccountDAO;
    }

    public OperationSmsMessageDBModel createOperationSmsMessageDBModel(SessionDBModel sessionDBModel,ClientPhoneDAO clientPhoneDAO,ProcessSmsMessageTempDBModel smsMessageTempDBModel,ProcessSmsChannelDBModel smsChannelDBModel){

        OperationSmsMessageDBModel smsMessageDBModel = new OperationSmsMessageDBModel();
        smsMessageDBModel.setClientId(sessionDBModel.getClientId());
        smsMessageDBModel.setSessionId(sessionDBModel.getId());
        smsMessageDBModel.setOperationId(sessionDBModel.getOperationId());
        smsMessageDBModel.setAgentId(sessionDBModel.getAgentId());
        smsMessageDBModel.setCampaignId(sessionDBModel.getCampaignId());
        smsMessageDBModel.setProcessId(sessionDBModel.getProcessId());
        smsMessageDBModel.setClientPhone(clientPhoneDAO);
        smsMessageDBModel.setSmsMessage(createOperationSmsMessageDAO(sessionDBModel,smsMessageTempDBModel,smsChannelDBModel));
        smsMessageDBModel.setSmsSentId(AppConstant.NONE);
        smsMessageDBModel.setSmsState(AppConstant.NEW_STATE);
        smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        smsMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
        smsMessageDBModel.setStatus(1);

        return operationSmsMessageRepository.save(smsMessageDBModel);
    }

    public OperationSmsMessageDAO createOperationSmsMessageDAO(SessionDBModel sessionDBModel,ProcessSmsMessageTempDBModel smsMessageTempDBModel, ProcessSmsChannelDBModel smsChannelDBModel){

        OperationSmsMessageDAO operationSmsMessageDAO = new OperationSmsMessageDAO();
        operationSmsMessageDAO.setTempId(smsMessageTempDBModel.getId());
        operationSmsMessageDAO.setAccountId(smsChannelDBModel.getSmsAccount().getAccountId());
        operationSmsMessageDAO.setSmsTitle(smsMessageTempDBModel.getSmsTitle());
        operationSmsMessageDAO.setSmsBody(smsMessageTempDBModel.getSmsBody());
        operationSmsMessageDAO.setSenderId(smsMessageTempDBModel.getSenderId());
        operationSmsMessageDAO.setSmsDatas(new ArrayList<>());
        operationSmsMessageDAO.setSmsType(smsMessageTempDBModel.getMessageType());
        operationSmsMessageDAO.setStatus(1);

        return operationSmsMessageDAO;
    }


    public ApiOperationWappMessageAccountWSDTO getApiWappMessageAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        List<ProcessWappChannelDBModel> wappChannels = processWappChannelRepository.findByProcessId(processId);
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null && !wappChannels.isEmpty()) {

            ApiOperationWappMessageAccountWSDTO wappAccountWSDTO = new ApiOperationWappMessageAccountWSDTO();
            wappAccountWSDTO.setAccountId(agentDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setAccount(agentDetails.get(0).getWappChannel().getAccount());
            wappAccountWSDTO.setInstanceKey(agentDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(agentDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(agentDetails.get(0).getWappChannel().getServerUrl());
            wappAccountWSDTO.setAccountDatas(agentDetails.get(0).getWappChannel().getAccountDatas());
            wappAccountWSDTO.setCallState(wappChannels.get(0).getMessageState());
            wappAccountWSDTO.setMessageState(wappChannels.get(0).getMessageState());
            wappAccountWSDTO.setcDate(wappChannels.get(0).getcDate());
            wappAccountWSDTO.setStatus(wappChannels.get(0).getStatus());

            return wappAccountWSDTO;
        }
        return null;
    }

    public OperationWappMessageDBModel createOperationWappMessageDBModel(UserDetailsDBModel agentDetails,SessionDBModel sessionDBModel, ClientPhoneDAO clientPhoneDAO, ProcessWappMessageTempDBModel wappMessageTempDBModel){

        OperationWappMessageDBModel wappMessageDBModel = new OperationWappMessageDBModel();
        wappMessageDBModel.setClientId(sessionDBModel.getClientId());
        wappMessageDBModel.setSessionId(sessionDBModel.getId());
        wappMessageDBModel.setOperationId(sessionDBModel.getOperationId());
        wappMessageDBModel.setAgentId(sessionDBModel.getAgentId());
        wappMessageDBModel.setCampaignId(sessionDBModel.getCampaignId());
        wappMessageDBModel.setProcessId(sessionDBModel.getProcessId());
        wappMessageDBModel.setClientPhone(clientPhoneDAO);
        wappMessageDBModel.setWappMessage(createOperationWappMessageDAO(agentDetails,wappMessageTempDBModel));
        wappMessageDBModel.setMessageSentId(AppConstant.NONE);
        wappMessageDBModel.setMessageState(AppConstant.NEW_STATE);
        wappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        wappMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
        wappMessageDBModel.setStatus(1);

        return operationWappMessageRepository.save(wappMessageDBModel);
    }

    public OperationWappMessageDAO createOperationWappMessageDAO(UserDetailsDBModel agentDetails,ProcessWappMessageTempDBModel wappMessageTempDBModel){

        OperationWappMessageDAO operationWappMessageDAO = new OperationWappMessageDAO();
        operationWappMessageDAO.setAccountId(agentDetails.getWappChannel().getAccountId());
        operationWappMessageDAO.setTempId(wappMessageTempDBModel.getId());
        operationWappMessageDAO.setWappTitle(wappMessageTempDBModel.getWappTitle());
        operationWappMessageDAO.setWappBody(wappMessageTempDBModel.getWappBody());
        operationWappMessageDAO.setMessageDatas(new ArrayList<>());
        operationWappMessageDAO.setMessageType(wappMessageTempDBModel.getMessageType());
        operationWappMessageDAO.setStatus(1);

        return operationWappMessageDAO;
    }

    public ClientPhoneDAO fetchClientPhoneDAO(long clientId,String numberId){

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
            List<ClientPhoneDAO> clientPhoneDAOS = clientDetailsDBModels.get(0).getClientPhones();
            for (ClientPhoneDAO clientPhoneDAO : clientPhoneDAOS) {
                if (clientPhoneDAO.getId().equalsIgnoreCase(numberId)) {
                    return clientPhoneDAO;
                }
            }
        }
        return null;
    }


    public ApiOperationEmailAccountWSDTO getApiEmailAccountWSDTO(String processId) {

        List<ProcessEmailChannelDBModel>emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!emailChannelDBModels.isEmpty() && emailChannelDBModels.get(0).getEmailAccount() != null) {

            ApiOperationEmailAccountWSDTO emailAccountWSDTO = new ApiOperationEmailAccountWSDTO();
            emailAccountWSDTO.setAccountId(emailChannelDBModels.get(0).getEmailAccount().getAccountId());
            emailAccountWSDTO.setAccount(emailChannelDBModels.get(0).getEmailAccount().getAccount());
            emailAccountWSDTO.setAccountDatas(emailChannelDBModels.get(0).getEmailAccount().getAccountDatas());
            emailAccountWSDTO.setProvider(emailChannelDBModels.get(0).getEmailAccount().getProvider());
            emailAccountWSDTO.setChannelState(emailChannelDBModels.get(0).getChannelState());
            emailAccountWSDTO.setcDate(emailChannelDBModels.get(0).getcDate());
            emailAccountWSDTO.setStatus(emailChannelDBModels.get(0).getStatus());

            return emailAccountWSDTO;
        }
        return null;
    }
    public ProcessEmailAccountDAO mapProcessEmailAccountDAO(EmailAccountDBModel emailAccountDBModel) {

        ProcessEmailAccountDAO processEmailAccountDAO = new ProcessEmailAccountDAO();
        processEmailAccountDAO.setAccountId(emailAccountDBModel.getId());
        processEmailAccountDAO.setAccount(emailAccountDBModel.getAccount());
        if (emailAccountDBModel.getAccountDatas() != null){
            processEmailAccountDAO.setAccountDatas(emailAccountDBModel.getAccountDatas());
        }else {
            processEmailAccountDAO.setAccountDatas(new ArrayList<>());
        }
        processEmailAccountDAO.setProvider(emailAccountDBModel.getProvider());
        processEmailAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        processEmailAccountDAO.setStatus(1);

        return processEmailAccountDAO;
    }
    public OperationEmailMessageDBModel createOperationEmailMessageDBModel(SessionDBModel sessionDBModel, ClientEmailDAO clientEmailDAO, ProcessEmailTempDBModel emailTempDBModel,ProcessEmailChannelDBModel emailChannelDBModel){

        OperationEmailMessageDBModel emailMessageDBModel = new OperationEmailMessageDBModel();
        emailMessageDBModel.setClientId(sessionDBModel.getClientId());
        emailMessageDBModel.setSessionId(sessionDBModel.getId());
        emailMessageDBModel.setOperationId(sessionDBModel.getOperationId());
        emailMessageDBModel.setAgentId(sessionDBModel.getAgentId());
        emailMessageDBModel.setCampaignId(sessionDBModel.getCampaignId());
        emailMessageDBModel.setProcessId(sessionDBModel.getProcessId());
        emailMessageDBModel.setClientEmail(clientEmailDAO);
        emailMessageDBModel.setEmailMessage(createOperationEmailMessageDAO(emailChannelDBModel,emailTempDBModel));
        emailMessageDBModel.setEmailSentId(AppConstant.NONE);
        emailMessageDBModel.setEmailState(AppConstant.NEW_STATE);
        emailMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        emailMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
        emailMessageDBModel.setStatus(1);

        return operationEmailMessageRepository.save(emailMessageDBModel);
    }

    public OperationEmailMessageDAO createOperationEmailMessageDAO(ProcessEmailChannelDBModel emailChannelDBModel,ProcessEmailTempDBModel emailTempDBModel){

        OperationEmailMessageDAO emailMessageDAO = new OperationEmailMessageDAO();
        emailMessageDAO.setAccountId(emailChannelDBModel.getEmailAccount().getAccountId());
        emailMessageDAO.setTempId(emailTempDBModel.getId());
        emailMessageDAO.setEmailSubject(emailTempDBModel.getEmailSubject());
        emailMessageDAO.setEmailBody(emailTempDBModel.getEmailBody());
        emailMessageDAO.setEmailFooter(emailTempDBModel.getEmailFooter());
        emailMessageDAO.setEmailSender(emailTempDBModel.getEmailSender());
        emailMessageDAO.setEmailType(emailTempDBModel.getEmailType());
        emailMessageDAO.setStatus(1);

        return emailMessageDAO;
    }

    public ClientEmailDAO fetchClientEmailDAO(long clientId, String emailAddressId){

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
            List<ClientEmailDAO> clientEmailDAOS = clientDetailsDBModels.get(0).getClientEmails();
            for (ClientEmailDAO clientEmailDAO : clientEmailDAOS) {
                if (clientEmailDAO.getId().equalsIgnoreCase(emailAddressId)) {
                    return clientEmailDAO;
                }
            }
        }
        return null;
    }



    public ApiOperationPushAccountWSDTO getApiPushAccountWSDTO(String processId) {

        List<ProcessPushChannelDBModel>pushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!pushChannelDBModels.isEmpty() && pushChannelDBModels.get(0).getPushAccount() != null) {

            ApiOperationPushAccountWSDTO pushAccountWSDTO = new ApiOperationPushAccountWSDTO();
            pushAccountWSDTO.setAccountId(pushChannelDBModels.get(0).getPushAccount().getAccountId());
            pushAccountWSDTO.setAccount(pushChannelDBModels.get(0).getPushAccount().getAccount());
            pushAccountWSDTO.setAccountDatas(pushChannelDBModels.get(0).getPushAccount().getAccountDatas());
            pushAccountWSDTO.setProvider(pushChannelDBModels.get(0).getPushAccount().getProvider());
            pushAccountWSDTO.setChannelState(pushChannelDBModels.get(0).getChannelState());
            pushAccountWSDTO.setcDate(pushChannelDBModels.get(0).getcDate());
            pushAccountWSDTO.setStatus(pushChannelDBModels.get(0).getStatus());

            return pushAccountWSDTO;
        }
        return null;
    }

    public ProcessPushAccountDAO mapProcessPushAccountDAO(PushAccountDBModel pushAccountDBModel) {

        ProcessPushAccountDAO processPushAccountDAO = new ProcessPushAccountDAO();
        processPushAccountDAO.setAccountId(pushAccountDBModel.getId());
        processPushAccountDAO.setAccount(pushAccountDBModel.getAccount());
        if (pushAccountDBModel.getAccountDatas() != null){
            processPushAccountDAO.setAccountDatas(pushAccountDBModel.getAccountDatas());
        }else {
            processPushAccountDAO.setAccountDatas(new ArrayList<>());
        }
        processPushAccountDAO.setProvider(pushAccountDBModel.getProvider());
        processPushAccountDAO.setcDate(appUtils.getCurrentTimeStamp());
        processPushAccountDAO.setStatus(1);

        return processPushAccountDAO;
    }

}
