package com.faas.core.base.middleware.channel.account;

import com.faas.core.base.framework.channel.account.ChannelAccountFramework;
import com.faas.core.base.model.db.channel.account.*;
import com.faas.core.base.model.ws.channel.account.*;
import com.faas.core.base.model.ws.channel.account.dto.*;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.channel.account.*;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChannelAccountsMiddleware {

    @Autowired
    ChannelAccountFramework channelAccountFramework;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    PushAccountRepository pushAccountRepository;

    @Autowired
    AppUtils appUtils;


    public ChannelAccountWSModel getAllChannelAccounts(long userId) {

        ChannelAccountWSModel response = new ChannelAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ChannelAccountWSDTO channelAccountWSDTO = channelAccountFramework.getAllChannelAccountsService(userId);
        if (channelAccountWSDTO != null){
            response.setChannelAccounts(channelAccountWSDTO);
        }

        general.setOperation("getAllChannelAccounts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SipAccountWSModel getAllSipAccounts(long userId) {

        SipAccountWSModel response = new SipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipAccountWSDTO> sipAccountWSDTOS = new ArrayList<>();

        List<SipAccountDBModel> sipAccountDBModels = sipAccountRepository.findByStatus(1);
        for (SipAccountDBModel sipAccountDBModel : sipAccountDBModels) {
            sipAccountWSDTOS.add(channelAccountFramework.fillSipAccountWSDTO(sipAccountDBModel));
        }

        response.setSipAccounts(sipAccountWSDTOS);
        general.setOperation("getAllSipAccounts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipAccountWSModel getSipAccount(long userId,String accountId) {

        SipAccountWSModel response = new SipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipAccountWSDTO> sipAccountWSDTOS = new ArrayList<>();

        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipAccountDBModel.isPresent()){
            sipAccountWSDTOS.add(channelAccountFramework.fillSipAccountWSDTO(sipAccountDBModel.get()));
        }

        response.setSipAccounts(sipAccountWSDTOS);
        general.setOperation("getSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipAccountWSModel createSipAccount(long userId,String account,String userName,String authUser,String password,String sipUrl,String provider) {

        SipAccountWSModel response = new SipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipAccountWSDTO> sipAccountWSDTOS = new ArrayList<>();

        SipAccountDBModel sipAccountDBModel = channelAccountFramework.createSipAccountService(account,userName,authUser,password,sipUrl,provider);
        if (sipAccountDBModel != null){
            sipAccountWSDTOS.add(channelAccountFramework.fillSipAccountWSDTO(sipAccountDBModel));
        }

        response.setSipAccounts(sipAccountWSDTOS);
        general.setOperation("createSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipAccountWSModel updateSipAccount(long userId,String accountId,String account,String userName,String authUser,String password,String sipUrl,String provider) {

        SipAccountWSModel response = new SipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipAccountWSDTO> sipAccountWSDTOS = new ArrayList<>();

        SipAccountDBModel sipAccountDBModel = channelAccountFramework.updateSipAccountService(accountId,account,userName,authUser,password,sipUrl,provider);
        if (sipAccountDBModel != null){
            sipAccountWSDTOS.add(channelAccountFramework.fillSipAccountWSDTO(sipAccountDBModel));
        }

        response.setSipAccounts(sipAccountWSDTOS);
        general.setOperation("updateSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipAccountWSModel removeSipAccount(long userId,String accountId) {

        SipAccountWSModel response = new SipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipAccountWSDTO> sipAccountWSDTOS = new ArrayList<>();

        SipAccountDBModel sipAccountDBModel = channelAccountFramework.removeSipAccountService(accountId);
        if (sipAccountDBModel != null){
            sipAccountWSDTOS.add(channelAccountFramework.fillSipAccountWSDTO(sipAccountDBModel));
        }

        response.setSipAccounts(sipAccountWSDTOS);
        general.setOperation("removeSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SmsAccountWSModel getAllSmsAccounts(long userId) {

        SmsAccountWSModel response = new SmsAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsAccountWSDTO> smsAccountWSDTOS = new ArrayList<>();

        List<SmsAccountDBModel> smsAccountDBModels = smsAccountRepository.findByStatus(1);
        if (smsAccountDBModels.size()>0){
            for (SmsAccountDBModel smsAccountDBModel : smsAccountDBModels) {
                smsAccountWSDTOS.add(channelAccountFramework.fillSmsAccountWSDTO(smsAccountDBModel));
            }
        }

        response.setSmsAccounts(smsAccountWSDTOS);
        general.setOperation("getAllSmsAccounts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsAccountWSModel getSmsAccount(long userId,String accountId) {

        SmsAccountWSModel response = new SmsAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsAccountWSDTO> smsAccountWSDTOS = new ArrayList<>();

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){
            smsAccountWSDTOS.add(channelAccountFramework.fillSmsAccountWSDTO(smsAccountDBModel.get()));
        }

        response.setSmsAccounts(smsAccountWSDTOS);
        general.setOperation("getSmsAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsAccountWSModel createSmsAccount(long userId,String account,String userName,String password,String apiToken,String apiUrl,String provider) {

        SmsAccountWSModel response = new SmsAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsAccountWSDTO> smsAccountWSDTOS = new ArrayList<>();

        SmsAccountDBModel smsAccountDBModel = channelAccountFramework.createSmsAccountService(account,userName,password,apiToken,apiUrl,provider);
        if (smsAccountDBModel != null){
            smsAccountWSDTOS.add(channelAccountFramework.fillSmsAccountWSDTO(smsAccountDBModel));
        }

        response.setSmsAccounts(smsAccountWSDTOS);
        general.setOperation("createSmsAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsAccountWSModel updateSmsAccount(long userId,String accountId,String account,String userName,String password,String apiToken,String apiUrl,String provider) {

        SmsAccountWSModel response = new SmsAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsAccountWSDTO> smsAccountWSDTOS = new ArrayList<>();

        SmsAccountDBModel smsAccountDBModel = channelAccountFramework.updateSmsAccountService(accountId,account,userName,password,apiToken,apiUrl,provider);
        if (smsAccountDBModel != null){
            smsAccountWSDTOS.add(channelAccountFramework.fillSmsAccountWSDTO(smsAccountDBModel));
        }

        response.setSmsAccounts(smsAccountWSDTOS);
        general.setOperation("updateSmsAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsAccountWSModel removeSmsAccount(long userId,String accountId) {

        SmsAccountWSModel response = new SmsAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsAccountWSDTO> smsAccountWSDTOS = new ArrayList<>();

        SmsAccountDBModel smsAccountDBModel = channelAccountFramework.removeSmsAccountService(accountId);
        if (smsAccountDBModel != null){
            smsAccountWSDTOS.add(channelAccountFramework.fillSmsAccountWSDTO(smsAccountDBModel));
        }

        response.setSmsAccounts(smsAccountWSDTOS);
        general.setOperation("removeSmsAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public WappAccountWSModel getAllWappAccounts(long userId) {

        WappAccountWSModel response = new WappAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappAccountWSDTO> wappAccountWSDTOS = new ArrayList<>();

        List<WappAccountDBModel> wappAccountDBModels = wappAccountRepository.findByStatus(1);
        for (WappAccountDBModel wappAccountDBModel : wappAccountDBModels) {
            wappAccountWSDTOS.add(channelAccountFramework.fillWappAccountWSDTO(wappAccountDBModel));
        }

        response.setWappAccounts(wappAccountWSDTOS);
        general.setOperation("getAllWappAccounts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappAccountWSModel getWappAccount(long userId, String accountId) {

        WappAccountWSModel response = new WappAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappAccountWSDTO> wappAccountWSDTOS = new ArrayList<>();

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            wappAccountWSDTOS.add(channelAccountFramework.fillWappAccountWSDTO(wappAccountDBModel.get()));
        }

        response.setWappAccounts(wappAccountWSDTOS);
        general.setOperation("getWappAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappQRCodeWSModel getWappAccountQRCode(long userId, String accountId) throws IOException {

        WappQRCodeWSModel response = new WappQRCodeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        WappQRCodeWSDTO wappQRCodeWSDTO = channelAccountFramework.getWappAccountQRCodeService(accountId);
        if (wappQRCodeWSDTO != null){
            response.setWappQRCode(wappQRCodeWSDTO);
        }

        general.setOperation("getWappAccountQRCode");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappAccountWSModel createWappAccount(long userId,String account, String phoneNumber, long serverId) throws IOException {

        WappAccountWSModel response = new WappAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappAccountWSDTO> wappAccountWSDTOS = new ArrayList<>();

        WappAccountDBModel wappAccountDBModel = channelAccountFramework.createWappAccountService(account,phoneNumber,serverId);
        if (wappAccountDBModel != null){
            wappAccountWSDTOS.add(channelAccountFramework.fillWappAccountWSDTO(wappAccountDBModel));
        }

        response.setWappAccounts(wappAccountWSDTOS);
        general.setOperation("createWappAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappAccountWSModel updateWappAccount(long userId,String accountId,String account,String instanceKey,String phoneNumber,long serverId) {

        WappAccountWSModel response = new WappAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappAccountWSDTO> wappAccountWSDTOS = new ArrayList<>();

        WappAccountDBModel wappAccountDBModel = channelAccountFramework.updateWappAccountService(accountId,account,instanceKey,phoneNumber,serverId);
        if (wappAccountDBModel != null){
            wappAccountWSDTOS.add(channelAccountFramework.fillWappAccountWSDTO(wappAccountDBModel));
        }

        response.setWappAccounts(wappAccountWSDTOS);
        general.setOperation("updateWappAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappAccountWSModel removeWappAccount(long userId, String accountId) {

        WappAccountWSModel response = new WappAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappAccountWSDTO> wappAccountWSDTOS = new ArrayList<>();

        WappAccountDBModel wappAccountDBModel = channelAccountFramework.removeWappAccountService(accountId);
        if (wappAccountDBModel != null){
            wappAccountWSDTOS.add(channelAccountFramework.fillWappAccountWSDTO(wappAccountDBModel));
        }

        response.setWappAccounts(wappAccountWSDTOS);
        general.setOperation("removeWappAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public EmailAccountWSModel getAllEmailAccounts(long userId) {

        EmailAccountWSModel response = new EmailAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailAccountWSDTO> emailAccountWSDTOS = new ArrayList<>();

        List<EmailAccountDBModel>emailAccountDBModels = emailAccountRepository.findByStatus(1);
        if (!emailAccountDBModels.isEmpty()){
            for (EmailAccountDBModel emailAccountDBModel : emailAccountDBModels) {
                emailAccountWSDTOS.add(channelAccountFramework.fillEmailAccountWSDTO(emailAccountDBModel));
            }
        }

        response.setEmailAccounts(emailAccountWSDTOS);
        general.setOperation("getAllEmailAccounts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailAccountWSModel getEmailAccount(long userId,String accountId) {

        EmailAccountWSModel response = new EmailAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailAccountWSDTO> emailAccountWSDTOS = new ArrayList<>();

        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()){
            emailAccountWSDTOS.add(channelAccountFramework.fillEmailAccountWSDTO(emailAccountDBModel.get()));
        }

        response.setEmailAccounts(emailAccountWSDTOS);
        general.setOperation("getEmailAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailAccountWSModel createEmailAccount(long userId,String account,String provider) {

        EmailAccountWSModel response = new EmailAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailAccountWSDTO> emailAccountWSDTOS = new ArrayList<>();

        EmailAccountDBModel emailAccountDBModel = channelAccountFramework.createEmailAccountService(account,provider);
        if (emailAccountDBModel != null){
            emailAccountWSDTOS.add(channelAccountFramework.fillEmailAccountWSDTO(emailAccountDBModel));
        }

        response.setEmailAccounts(emailAccountWSDTOS);
        general.setOperation("createEmailAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailAccountWSModel updateEmailAccount(long userId,String accountId,String account,String provider) {

        EmailAccountWSModel response = new EmailAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailAccountWSDTO> emailAccountWSDTOS = new ArrayList<>();

        EmailAccountDBModel emailAccountDBModel = channelAccountFramework.updateEmailAccountService(accountId,account,provider);
        if (emailAccountDBModel != null){
            emailAccountWSDTOS.add(channelAccountFramework.fillEmailAccountWSDTO(emailAccountDBModel));
        }

        response.setEmailAccounts(emailAccountWSDTOS);
        general.setOperation("updateEmailAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public EmailAccountWSModel removeEmailAccount(long userId,String accountId) {

        EmailAccountWSModel response = new EmailAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<EmailAccountWSDTO> emailAccountWSDTOS = new ArrayList<>();

        EmailAccountDBModel emailAccountDBModel = channelAccountFramework.removeEmailAccountService(accountId);
        if (emailAccountDBModel != null){
            emailAccountWSDTOS.add(channelAccountFramework.fillEmailAccountWSDTO(emailAccountDBModel));
        }

        response.setEmailAccounts(emailAccountWSDTOS);
        general.setOperation("removeEmailAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public PushAccountWSModel getAllPushAccounts(long userId) {

        PushAccountWSModel response = new PushAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushAccountWSDTO> pushAccountWSDTOS = new ArrayList<>();

        List<PushAccountDBModel> pushAccountDBModels = pushAccountRepository.findByStatus(1);
        for (PushAccountDBModel pushAccountDBModel : pushAccountDBModels) {
            pushAccountWSDTOS.add(channelAccountFramework.fillPushAccountWSDTO(pushAccountDBModel));
        }

        response.setPushAccounts(pushAccountWSDTOS);
        general.setOperation("getAllPushAccounts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public PushAccountWSModel getPushAccount(long userId, String accountId) {

        PushAccountWSModel response = new PushAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushAccountWSDTO> pushAccountWSDTOS = new ArrayList<>();

        Optional<PushAccountDBModel> pushAccountDBModel = pushAccountRepository.findById(accountId);
        if (pushAccountDBModel.isPresent()){
            pushAccountWSDTOS.add(channelAccountFramework.fillPushAccountWSDTO(pushAccountDBModel.get()));
        }

        response.setPushAccounts(pushAccountWSDTOS);
        general.setOperation("getPushAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public PushAccountWSModel createPushAccount(long userId,String account, String provider) {

        PushAccountWSModel response = new PushAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushAccountWSDTO> pushAccountWSDTOS = new ArrayList<>();

        PushAccountDBModel pushAccountDBModel = channelAccountFramework.createPushAccountService(account,provider);
        if (pushAccountDBModel != null){
            pushAccountWSDTOS.add(channelAccountFramework.fillPushAccountWSDTO(pushAccountDBModel));
        }

        response.setPushAccounts(pushAccountWSDTOS);
        general.setOperation("createPushAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public PushAccountWSModel updatePushAccount(long userId,String accountId, String account, String provider) {

        PushAccountWSModel response = new PushAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushAccountWSDTO> pushAccountWSDTOS = new ArrayList<>();

        PushAccountDBModel pushAccountDBModel = channelAccountFramework.updatePushAccountService(accountId,account,provider);
        if (pushAccountDBModel != null){
            pushAccountWSDTOS.add(channelAccountFramework.fillPushAccountWSDTO(pushAccountDBModel));
        }

        response.setPushAccounts(pushAccountWSDTOS);
        general.setOperation("updatePushAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public PushAccountWSModel removePushAccount(long userId, String accountId) {

        PushAccountWSModel response = new PushAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<PushAccountWSDTO> pushAccountWSDTOS = new ArrayList<>();

        PushAccountDBModel pushAccountDBModel = channelAccountFramework.removePushAccountService(accountId);
        if (pushAccountDBModel != null){
            pushAccountWSDTOS.add(channelAccountFramework.fillPushAccountWSDTO(pushAccountDBModel));
        }

        response.setPushAccounts(pushAccountWSDTOS);
        general.setOperation("removePushAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
