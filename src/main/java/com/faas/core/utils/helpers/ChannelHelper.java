package com.faas.core.utils.helpers;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import com.faas.core.base.model.db.channel.account.PushAccountDBModel;
import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.content.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationSmsMessageDAO;
import com.faas.core.base.model.db.operation.details.channel.dao.OperationWappMessageDAO;
import com.faas.core.base.model.db.process.details.channel.content.*;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessEmailAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessPushAccountDAO;
import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessSmsAccountDAO;
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
        operationSmsMessageDAO.setAccountId(smsChannelDBModel.getAccountId());
        operationSmsMessageDAO.setSmsTitle(smsMessageTempDBModel.getSmsTitle());
        operationSmsMessageDAO.setSmsBody(smsMessageTempDBModel.getSmsBody());
        operationSmsMessageDAO.setSenderId(smsMessageTempDBModel.getSenderId());
        operationSmsMessageDAO.setSmsDatas(new ArrayList<>());
        operationSmsMessageDAO.setSmsType(smsMessageTempDBModel.getMessageType());
        operationSmsMessageDAO.setStatus(1);

        return operationSmsMessageDAO;
    }



    public OperationWappMessageDBModel createOperationWappMessageDBModel(SessionDBModel sessionDBModel, ClientPhoneDAO clientPhoneDAO, ProcessWappMessageTempDBModel wappMessageTempDBModel, String numberId){

        OperationWappMessageDBModel wappMessageDBModel = new OperationWappMessageDBModel();
        wappMessageDBModel.setClientId(sessionDBModel.getClientId());
        wappMessageDBModel.setSessionId(sessionDBModel.getId());
        wappMessageDBModel.setOperationId(sessionDBModel.getOperationId());
        wappMessageDBModel.setAgentId(sessionDBModel.getAgentId());
        wappMessageDBModel.setCampaignId(sessionDBModel.getCampaignId());
        wappMessageDBModel.setProcessId(sessionDBModel.getProcessId());

        wappMessageDBModel.setMessageSentId(AppConstant.NONE);
        wappMessageDBModel.setMessageState(AppConstant.NEW_STATE);
        wappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        wappMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
        wappMessageDBModel.setStatus(1);

        return operationWappMessageRepository.save(wappMessageDBModel);
    }


    public OperationWappMessageDAO createOperationWappMessageDAO(ProcessWappMessageTempDBModel wappMessageTempDBModel, UserDetailsDBModel agentDetails){

        OperationWappMessageDAO operationWappMessageDAO = new OperationWappMessageDAO();

        operationWappMessageDAO.setStatus(1);

        return operationWappMessageDAO;
    }


    public ApiOperationSipCallWSDTO getApiOperationSipCallWSDTO(long agentId, long sessionId,long clientId,String processId){

        ApiOperationSipCallWSDTO operationSipCallWSDTO = new ApiOperationSipCallWSDTO();

        return operationSipCallWSDTO;
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


    public ApiSipAccountWSDTO getApiSipAccountWSDTO(long agentId,String processId) {

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
            sipAccountWSDTO.setChannelState(sipChannelDBModels.get(0).getChannelState());
            sipAccountWSDTO.setcDate(sipChannelDBModels.get(0).getcDate());
            sipAccountWSDTO.setStatus(sipChannelDBModels.get(0).getStatus());

            return sipAccountWSDTO;
        }
        return null;
    }


    public ApiOperationSipCallWSDTO mapApiOperationSipCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {


        return null;
    }


    public ApiWappCallAccountWSDTO getApiWappCallAccountWSDTO(long agentId, String processId) {

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
            wappAccountWSDTO.setCallState(wappChannels.get(0).getCallState());
            wappAccountWSDTO.setMessageState(wappChannels.get(0).getMessageState());
            wappAccountWSDTO.setcDate(wappChannels.get(0).getcDate());
            wappAccountWSDTO.setStatus(wappChannels.get(0).getStatus());

            return wappAccountWSDTO;
        }
        return null;
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


    public ApiOperationWappCallWSDTO mapApiOperationWappCallWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {


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


    public ApiOperationSmsChannelWSDTO mapApiOperationSmsMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {

        ApiOperationSmsChannelWSDTO operationSmsMessageWSDTO = new ApiOperationSmsChannelWSDTO();
        ApiOperationSmsAccountWSDTO smsAccountWSDTO = getApiSmsAccountWSDTO(sessionDBModel.getProcessId());
        if (smsAccountWSDTO != null){
            operationSmsMessageWSDTO.setSmsAccount(smsAccountWSDTO);
        }

        return operationSmsMessageWSDTO;
    }


    public ApiOperationSmsAccountWSDTO getApiSmsAccountWSDTO(String processId) {

        List<ProcessSmsChannelDBModel>smsChannelDBModels = processSmsChannelRepository.findByProcessId(processId);
        if (!smsChannelDBModels.isEmpty() && smsChannelDBModels.get(0).getSmsAccount() != null) {

            ApiOperationSmsAccountWSDTO smsAccountWSDTO = new ApiOperationSmsAccountWSDTO();
            smsAccountWSDTO.setAccountId(smsChannelDBModels.get(0).getAccountId());
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


    public ApiOperationWappMessageChannelWSDTO mapApiOperationWappMessageWSDTO(SessionDBModel sessionDBModel, List<ClientPhoneDAO> clientPhones) {

        ApiOperationWappMessageChannelWSDTO operationWappMessageWSDTO = new ApiOperationWappMessageChannelWSDTO();

        return operationWappMessageWSDTO;
    }


    public ApiOperationEmailAccountWSDTO getApiEmailAccountWSDTO(String processId) {

        List<ProcessEmailChannelDBModel>emailChannelDBModels = processEmailChannelRepository.findByProcessId(processId);
        if (!emailChannelDBModels.isEmpty() && emailChannelDBModels.get(0).getEmailAccount() != null) {

            ApiOperationEmailAccountWSDTO emailAccountWSDTO = new ApiOperationEmailAccountWSDTO();
            emailAccountWSDTO.setAccountId(emailChannelDBModels.get(0).getAccountId());
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


    public ApiOperationEmailWSDTO mapApiOperationEmailWSDTO(SessionDBModel sessionDBModel) {

        ApiOperationEmailWSDTO operationEmailWSDTO = new ApiOperationEmailWSDTO();

        return operationEmailWSDTO;
    }



    public ApiOperationPushChannelWSDTO mapApiOperationPushMessageWSDTO(SessionDBModel sessionDBModel) {

        ApiOperationPushAccountWSDTO pushAccountWSDTO = getApiPushAccountWSDTO(sessionDBModel.getProcessId());
        if (pushAccountWSDTO != null){

            ApiOperationPushChannelWSDTO operationPushMessageWSDTO = new ApiOperationPushChannelWSDTO();
            operationPushMessageWSDTO.setPushAccount(pushAccountWSDTO);

            return operationPushMessageWSDTO;
        }
        return null;
    }


    public ApiOperationPushAccountWSDTO getApiPushAccountWSDTO(String processId) {

        List<ProcessPushChannelDBModel>pushChannelDBModels = processPushChannelRepository.findByProcessId(processId);
        if (!pushChannelDBModels.isEmpty() && pushChannelDBModels.get(0).getPushAccount() != null) {

            ApiOperationPushAccountWSDTO pushAccountWSDTO = new ApiOperationPushAccountWSDTO();
            pushAccountWSDTO.setAccountId(pushChannelDBModels.get(0).getAccountId());
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



}
