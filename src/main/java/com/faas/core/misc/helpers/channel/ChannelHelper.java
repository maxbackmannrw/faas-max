package com.faas.core.misc.helpers.channel;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.data.db.campaign.details.channel.dao.CampaignEmailChannelDAO;
import com.faas.core.data.db.campaign.details.channel.dao.CampaignPushChannelDAO;
import com.faas.core.data.db.campaign.details.channel.dao.CampaignSmsChannelDAO;
import com.faas.core.data.db.campaign.details.temp.EmailTempDBModel;
import com.faas.core.data.db.campaign.details.temp.SmsTempDBModel;
import com.faas.core.data.db.campaign.details.temp.WappMessageTempDBModel;
import com.faas.core.data.db.channel.account.EmailAccountDBModel;
import com.faas.core.data.db.channel.account.PushAccountDBModel;
import com.faas.core.data.db.channel.account.SmsAccountDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.details.dao.ClientEmailDAO;
import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.*;
import com.faas.core.data.db.operation.details.channel.dao.*;
import com.faas.core.data.db.user.details.UserDetailsDBModel;
import com.faas.core.data.repo.campaign.details.channel.CampaignChannelRepository;
import com.faas.core.data.repo.campaign.details.temp.EmailTempRepository;
import com.faas.core.data.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.data.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.data.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.details.channel.*;
import com.faas.core.data.repo.user.details.UserDetailsRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.handler.channel.email.EmailChannelHandler;
import com.faas.core.misc.handler.channel.push.PushChannelHandler;
import com.faas.core.misc.handler.channel.sip.SipChannelHandler;
import com.faas.core.misc.handler.channel.sms.SmsChannelHandler;
import com.faas.core.misc.handler.channel.wapp.WappChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChannelHelper {

    @Autowired
    SipChannelHandler sipChannelHandler;

    @Autowired
    WappChannelHandler wappChannelHandler;

    @Autowired
    SmsChannelHandler smsChannelHandler;

    @Autowired
    EmailChannelHandler emailChannelHandler;

    @Autowired
    PushChannelHandler pushChannelHandler;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    CampaignChannelRepository campaignChannelRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    com.faas.core.data.repo.operation.details.channel.OperationSmsRepository OperationSmsRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationSipAccountWSDTO getApiOperationSipAccountWSDTO(long agentId, String processId) {


        return null;
    }

    public ApiOperationSipCallWSDTO createOperationSipCallHelper(OperationDBModel operationDBModel, String numberId) {

        OperationSipCallDAO operationSipCallDAO = createOperationSipCallDAO(operationDBModel, numberId);
        if (operationSipCallDAO != null && !operationSipCallRepository.existsByOperationIdAndCallState(operationDBModel.getId(), AppConstant.READY_CALL)
                && !operationSipCallRepository.existsByOperationIdAndCallState(operationDBModel.getId(), AppConstant.ACTIVE_CALL)) {

            OperationSipCallDBModel operationSipCallDBModel = new OperationSipCallDBModel();
            operationSipCallDBModel.setClientId(operationDBModel.getClientId());
            operationSipCallDBModel.setOperationId(operationDBModel.getId());
            operationSipCallDBModel.setAgentId(operationDBModel.getAgentId());
            operationSipCallDBModel.setCampaignId(operationDBModel.getCampaignId());
            operationSipCallDBModel.setSipCall(operationSipCallDAO);
            operationSipCallDBModel.setCallConnId(AppConstant.NONE);
            operationSipCallDBModel.setCallState(AppConstant.READY_CALL);
            operationSipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationSipCallDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationSipCallDBModel.setStatus(1);

            return new ApiOperationSipCallWSDTO(operationSipCallRepository.save(operationSipCallDBModel));
        }
        return null;
    }

    public OperationSipCallDAO createOperationSipCallDAO(OperationDBModel operationDBModel, String numberId) {

        ClientPhoneDAO clientPhoneDAO = fetchClientPhoneDAO(operationDBModel.getClientId(), numberId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(operationDBModel.getAgentId());

        if (clientPhoneDAO != null && !agentDetails.isEmpty() && agentDetails.get(0).getSipChannel() != null) {

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

    public ApiOperationSipCallWSDTO startOperationSipCallHelper(OperationSipCallDBModel operationSipCallDBModel) {

        if (operationSipCallDBModel.getSipCall() != null && operationSipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.READY_CALL)) {

            operationSipCallDBModel.getSipCall().setsDate(appUtils.getCurrentTimeStamp());
            operationSipCallDBModel.setCallState(AppConstant.ACTIVE_CALL);
            operationSipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationSipCallWSDTO(operationSipCallRepository.save(operationSipCallDBModel));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO hangUpOperationSipCallHelper(OperationSipCallDBModel operationSipCallDBModel) {

        if (operationSipCallDBModel.getSipCall() != null && operationSipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)) {

            operationSipCallDBModel.getSipCall().setfDate(appUtils.getCurrentTimeStamp());
            operationSipCallDBModel.setCallState(AppConstant.FINISHED_CALL);
            operationSipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationSipCallWSDTO(operationSipCallRepository.save(operationSipCallDBModel));
        }
        return null;
    }

    public ApiOperationSipCallWSDTO cancelOperationSipCallHelper(OperationSipCallDBModel operationSipCallDBModel) {

        if (operationSipCallDBModel.getSipCall() != null) {
            if (operationSipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.READY_CALL)) {
                operationSipCallRepository.delete(operationSipCallDBModel);
            }
            if (operationSipCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)) {
                operationSipCallDBModel.getSipCall().setfDate(appUtils.getCurrentTimeStamp());
                operationSipCallDBModel.setCallState(AppConstant.FINISHED_CALL);
                operationSipCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
                operationSipCallDBModel = operationSipCallRepository.save(operationSipCallDBModel);
            }
        }
        return new ApiOperationSipCallWSDTO(operationSipCallDBModel);
    }


    public ApiOperationWappCallAccountWSDTO getApiOperationWappCallAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null) {

            ApiOperationWappCallAccountWSDTO wappAccountWSDTO = new ApiOperationWappCallAccountWSDTO();
            wappAccountWSDTO.setAccountId(agentDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setAccount(agentDetails.get(0).getWappChannel().getAccount());
            wappAccountWSDTO.setInstanceKey(agentDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(agentDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(agentDetails.get(0).getWappChannel().getServerUrl());
            wappAccountWSDTO.setAccountDatas(agentDetails.get(0).getWappChannel().getAccountDatas());

            return wappAccountWSDTO;
        }
        return null;
    }


    public ApiOperationWappCallWSDTO createOperationWappCallHelper(OperationDBModel operationDBModel, String numberId) {

        OperationWappCallDAO operationWappCallDAO = createOperationWappCallDAO(operationDBModel, numberId);
        if (operationWappCallDAO != null && !operationWappCallRepository.existsByOperationIdAndCallState(operationDBModel.getId(), AppConstant.READY_CALL) && !operationSipCallRepository.existsByOperationIdAndCallState(operationDBModel.getId(), AppConstant.ACTIVE_CALL)) {

            OperationWappCallDBModel operationWappCallDBModel = new OperationWappCallDBModel();
            operationWappCallDBModel.setClientId(operationDBModel.getClientId());
            operationWappCallDBModel.setOperationId(operationDBModel.getId());
            operationWappCallDBModel.setAgentId(operationDBModel.getAgentId());
            operationWappCallDBModel.setCampaignId(operationDBModel.getCampaignId());
            operationWappCallDBModel.setWappCall(operationWappCallDAO);
            operationWappCallDBModel.setCallConnId(AppConstant.NONE);
            operationWappCallDBModel.setCallState(AppConstant.READY_CALL);
            operationWappCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
            operationWappCallDBModel.setcDate(appUtils.getCurrentTimeStamp());
            operationWappCallDBModel.setStatus(1);

            return new ApiOperationWappCallWSDTO(operationWappCallRepository.save(operationWappCallDBModel));
        }
        return null;
    }

    public OperationWappCallDAO createOperationWappCallDAO(OperationDBModel operationDBModel, String numberId) {

        ClientPhoneDAO clientPhoneDAO = fetchClientPhoneDAO(operationDBModel.getClientId(), numberId);
        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(operationDBModel.getAgentId());
        if (clientPhoneDAO != null && !agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null) {

            OperationWappCallDAO operationWappCallDAO = new OperationWappCallDAO();
            operationWappCallDAO.setNumberId(numberId);
            operationWappCallDAO.setPhoneNumber(clientPhoneDAO.getPhoneNumber());
            operationWappCallDAO.setPhoneCarrier(clientPhoneDAO.getPhoneCarrier());
            operationWappCallDAO.setPhoneType(clientPhoneDAO.getPhoneType());
            operationWappCallDAO.setAccountId(agentDetails.get(0).getSipChannel().getAccountId());
            operationWappCallDAO.setsDate(appUtils.getCurrentTimeStamp());
            operationWappCallDAO.setfDate(appUtils.getCurrentTimeStamp());
            operationWappCallDAO.setStatus(1);

            return operationWappCallDAO;
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

    public ApiOperationWappCallWSDTO startOperationWappCallHelper(OperationWappCallDBModel operationWappCallDBModel) {

        if (operationWappCallDBModel.getWappCall() != null && operationWappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.READY_CALL)) {

            operationWappCallDBModel.getWappCall().setsDate(appUtils.getCurrentTimeStamp());
            operationWappCallDBModel.setCallState(AppConstant.ACTIVE_CALL);
            operationWappCallDBModel.setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationWappCallWSDTO(operationWappCallRepository.save(operationWappCallDBModel));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO hangUpOperationWappCallHelper(OperationWappCallDBModel operationWappCallDBModel) {

        if (operationWappCallDBModel.getWappCall() != null && operationWappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)) {

            operationWappCallDBModel.getWappCall().setfDate(appUtils.getCurrentTimeStamp());
            operationWappCallDBModel.setCallState(AppConstant.FINISHED_CALL);
            operationWappCallDBModel.setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationWappCallWSDTO(operationWappCallRepository.save(operationWappCallDBModel));
        }
        return null;
    }

    public ApiOperationWappCallWSDTO cancelOperationWappCallHelper(OperationWappCallDBModel operationWappCallDBModel) {

        if (operationWappCallDBModel.getWappCall() != null) {
            if (operationWappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.READY_CALL)) {
                operationWappCallRepository.delete(operationWappCallDBModel);
            }
            if (operationWappCallDBModel.getCallState().equalsIgnoreCase(AppConstant.ACTIVE_CALL)) {
                operationWappCallDBModel.getWappCall().setfDate(appUtils.getCurrentTimeStamp());
                operationWappCallDBModel.setCallState(AppConstant.FINISHED_CALL);
                operationWappCallDBModel.setuDate(appUtils.getCurrentTimeStamp());
                operationWappCallDBModel = operationWappCallRepository.save(operationWappCallDBModel);
            }
        }
        return new ApiOperationWappCallWSDTO(operationWappCallDBModel);
    }


    public ApiOperationSmsAccountWSDTO getApiOperationSmsAccountWSDTO(String processId) {

        return null;
    }


    public OperationSmsDBModel createOperationSmsModel(OperationDBModel operationDBModel, ClientPhoneDAO clientPhoneDAO, SmsTempDBModel smsTempDBModel, CampaignSmsChannelDAO smsChannelDBModel) {

        OperationSmsDBModel operationSmsDBModel = new OperationSmsDBModel();
        operationSmsDBModel.setClientId(operationDBModel.getClientId());
        operationSmsDBModel.setOperationId(operationDBModel.getId());
        operationSmsDBModel.setAgentId(operationDBModel.getAgentId());
        operationSmsDBModel.setCampaignId(operationDBModel.getCampaignId());
        operationSmsDBModel.setClientPhone(clientPhoneDAO);
        operationSmsDBModel.setOperationSms(createOperationSmsDAO(smsTempDBModel, smsChannelDBModel));
        operationSmsDBModel.setSmsSentId(AppConstant.NONE);
        operationSmsDBModel.setSmsState(AppConstant.MESSAGE_READY);
        operationSmsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationSmsDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationSmsDBModel.setStatus(1);

        return OperationSmsRepository.save(operationSmsDBModel);
    }

    public OperationSmsDAO createOperationSmsDAO(SmsTempDBModel smsTempDBModel, CampaignSmsChannelDAO smsChannelDBModel) {

        OperationSmsDAO operationSmsDAO = new OperationSmsDAO();
        operationSmsDAO.setTempId(smsTempDBModel.getId());
        operationSmsDAO.setSmsTitle(smsTempDBModel.getSmsTitle());
        operationSmsDAO.setSmsBody(smsTempDBModel.getSmsBody());
        operationSmsDAO.setSenderId(smsTempDBModel.getSenderId());
        operationSmsDAO.setSmsDatas(new ArrayList<>());
        operationSmsDAO.setSmsType(smsTempDBModel.getMessageType());
        operationSmsDAO.setStatus(1);

        return operationSmsDAO;
    }


    public ApiOperationWappMessageAccountWSDTO getApiWappMessageAccountWSDTO(long agentId, String processId) {

        List<UserDetailsDBModel> agentDetails = userDetailsRepository.findByUserId(agentId);
        if (!agentDetails.isEmpty() && agentDetails.get(0).getWappChannel() != null && agentDetails.get(0).getWappChannel().getAccountId() != null) {

            ApiOperationWappMessageAccountWSDTO wappAccountWSDTO = new ApiOperationWappMessageAccountWSDTO();
            wappAccountWSDTO.setAccountId(agentDetails.get(0).getWappChannel().getAccountId());
            wappAccountWSDTO.setAccount(agentDetails.get(0).getWappChannel().getAccount());
            wappAccountWSDTO.setInstanceKey(agentDetails.get(0).getWappChannel().getInstanceKey());
            wappAccountWSDTO.setPhoneNumber(agentDetails.get(0).getWappChannel().getPhoneNumber());
            wappAccountWSDTO.setServerUrl(agentDetails.get(0).getWappChannel().getServerUrl());
            wappAccountWSDTO.setAccountDatas(agentDetails.get(0).getWappChannel().getAccountDatas());

            return wappAccountWSDTO;
        }
        return null;
    }

    public OperationWappMessageDBModel createOperationWappMessageModel(UserDetailsDBModel agentDetails, OperationDBModel operationModel, ClientPhoneDAO clientPhoneDAO, WappMessageTempDBModel wappMessageTempModel) {

        OperationWappMessageDBModel operationWappMessageDBModel = new OperationWappMessageDBModel();
        operationWappMessageDBModel.setClientId(operationModel.getClientId());
        operationWappMessageDBModel.setOperationId(operationModel.getId());
        operationWappMessageDBModel.setAgentId(operationModel.getAgentId());
        operationWappMessageDBModel.setCampaignId(operationModel.getCampaignId());
        operationWappMessageDBModel.setClientPhone(clientPhoneDAO);
        operationWappMessageDBModel.setOperationWappMessage(createOperationWappMessageDAO(agentDetails, wappMessageTempModel));
        operationWappMessageDBModel.setMessageSentId(AppConstant.NONE);
        operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_READY);
        operationWappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationWappMessageDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationWappMessageDBModel.setStatus(1);

        return operationWappMessageRepository.save(operationWappMessageDBModel);
    }

    public OperationWappMessageDAO createOperationWappMessageDAO(UserDetailsDBModel agentDetails, WappMessageTempDBModel wappMessageTempDBModel) {

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

    public ClientPhoneDAO fetchClientPhoneDAO(long clientId, String numberId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null) {
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

        return null;
    }

    public OperationEmailDBModel createOperationEmailDBModel(OperationDBModel operationDBModel, ClientEmailDAO clientEmailDAO, EmailTempDBModel emailTempDBModel, CampaignEmailChannelDAO emailChannelDBModel) {

        OperationEmailDBModel operationEmailDBModel = new OperationEmailDBModel();
        operationEmailDBModel.setClientId(operationDBModel.getClientId());
        operationEmailDBModel.setOperationId(operationDBModel.getId());
        operationEmailDBModel.setAgentId(operationDBModel.getAgentId());
        operationEmailDBModel.setCampaignId(operationDBModel.getCampaignId());
        operationEmailDBModel.setClientEmail(clientEmailDAO);
        operationEmailDBModel.setEmailMessage(createOperationEmailDAO(emailChannelDBModel, emailTempDBModel));
        operationEmailDBModel.setEmailSentId(AppConstant.NONE);
        operationEmailDBModel.setEmailState(AppConstant.READY_STATE);
        operationEmailDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationEmailDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationEmailDBModel.setStatus(1);

        return operationEmailRepository.save(operationEmailDBModel);
    }

    public OperationEmailDAO createOperationEmailDAO(CampaignEmailChannelDAO emailChannelDBModel, EmailTempDBModel emailTempDBModel) {

        OperationEmailDAO operationEmailDAO = new OperationEmailDAO();
        operationEmailDAO.setTempId(emailTempDBModel.getId());
        operationEmailDAO.setEmailSubject(emailTempDBModel.getEmailSubject());
        operationEmailDAO.setEmailBody(emailTempDBModel.getEmailBody());
        operationEmailDAO.setEmailSender(emailTempDBModel.getEmailSender());
        operationEmailDAO.setEmailType(emailTempDBModel.getEmailType());
        operationEmailDAO.setStatus(1);

        return operationEmailDAO;
    }

    public ClientEmailDAO fetchClientEmailDAO(long clientId, String emailAddressId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null) {
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


        return null;
    }


    public OperationPushDBModel createOperationPushDBModel() {

        OperationPushDBModel operationPushDBModel = new OperationPushDBModel();

        return operationPushRepository.save(operationPushDBModel);
    }

    public OperationPushDAO createOperationPushDAO(CampaignPushChannelDAO pushChannelDBModel) {

        OperationPushDAO operationPushDAO = new OperationPushDAO();

        return operationPushDAO;
    }


    public CampaignSmsChannelDAO createCampaignSmsChannelDAO(SmsAccountDBModel smsAccountDBModel, String state) {

        CampaignSmsChannelDAO campaignSmsChannelDAO = new CampaignSmsChannelDAO();
        campaignSmsChannelDAO.setId(appUtils.generateUUID());
        campaignSmsChannelDAO.setAccountId(smsAccountDBModel.getId());
        campaignSmsChannelDAO.setAccount(smsAccountDBModel.getAccount());
        campaignSmsChannelDAO.setUserName(smsAccountDBModel.getUserName());
        campaignSmsChannelDAO.setPassword(smsAccountDBModel.getPassword());
        campaignSmsChannelDAO.setApiToken(smsAccountDBModel.getApiToken());
        campaignSmsChannelDAO.setApiUrl(smsAccountDBModel.getApiUrl());
        if (smsAccountDBModel.getAccountDatas() != null) {
            campaignSmsChannelDAO.setAccountDatas(smsAccountDBModel.getAccountDatas());
        } else {
            campaignSmsChannelDAO.setAccountDatas(new ArrayList<>());
        }
        campaignSmsChannelDAO.setProvider(smsAccountDBModel.getProvider());
        campaignSmsChannelDAO.setState(state);
        campaignSmsChannelDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignSmsChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignSmsChannelDAO.setStatus(1);

        return campaignSmsChannelDAO;
    }

    public CampaignEmailChannelDAO createCampaignEmailChannelDAO(EmailAccountDBModel emailAccountDBModel, String state) {

        CampaignEmailChannelDAO campaignEmailChannelDAO = new CampaignEmailChannelDAO();
        campaignEmailChannelDAO.setId(appUtils.generateUUID());
        campaignEmailChannelDAO.setAccountId(emailAccountDBModel.getId());
        campaignEmailChannelDAO.setAccount(emailAccountDBModel.getAccount());
        if (emailAccountDBModel.getAccountDatas() != null) {
            campaignEmailChannelDAO.setAccountDatas(emailAccountDBModel.getAccountDatas());
        } else {
            campaignEmailChannelDAO.setAccountDatas(new ArrayList<>());
        }
        campaignEmailChannelDAO.setProvider(emailAccountDBModel.getProvider());
        campaignEmailChannelDAO.setState(state);
        campaignEmailChannelDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignEmailChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignEmailChannelDAO.setStatus(1);

        return campaignEmailChannelDAO;
    }

    public CampaignPushChannelDAO createCampaignPushChannelDAO(PushAccountDBModel pushAccountDBModel, String state) {

        CampaignPushChannelDAO campaignPushChannelDAO = new CampaignPushChannelDAO();
        campaignPushChannelDAO.setId(appUtils.generateUUID());
        campaignPushChannelDAO.setAccountId(pushAccountDBModel.getId());
        campaignPushChannelDAO.setAccount(pushAccountDBModel.getAccount());
        if (pushAccountDBModel.getAccountDatas() != null) {
            campaignPushChannelDAO.setAccountDatas(pushAccountDBModel.getAccountDatas());
        } else {
            campaignPushChannelDAO.setAccountDatas(new ArrayList<>());
        }
        campaignPushChannelDAO.setProvider(pushAccountDBModel.getProvider());
        campaignPushChannelDAO.setState(state);
        campaignPushChannelDAO.setuDate(appUtils.getCurrentTimeStamp());
        campaignPushChannelDAO.setcDate(appUtils.getCurrentTimeStamp());
        campaignPushChannelDAO.setStatus(1);

        return campaignPushChannelDAO;
    }


}
