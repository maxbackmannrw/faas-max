package com.faas.core.base.framework.channel.account;

import com.faas.core.base.model.db.channel.account.*;
import com.faas.core.base.model.db.channel.settings.WappServerDBModel;
import com.faas.core.base.model.ws.channel.account.dto.*;
import com.faas.core.base.repo.channel.account.*;
import com.faas.core.base.repo.channel.settings.WappServerRepository;
import com.faas.core.utils.service.channel.wapp.WappChannelService;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ChannelAccountFramework {

    @Autowired
    WappChannelService wappChannelService;

    @Autowired
    SipAccountRepository sipAccountRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    WappServerRepository wappServerRepository;

    @Autowired
    EmailAccountRepository emailAccountRepository;

    @Autowired
    PushAccountRepository pushAccountRepository;

    @Autowired
    AppUtils appUtils;


    public ChannelAccountWSDTO getAllChannelAccountsService(long userId) {

        ChannelAccountWSDTO channelAccountWSDTO = new ChannelAccountWSDTO();
        List<SipAccountWSDTO>sipAccountWSDTOS = new ArrayList<>();
        List<SmsAccountWSDTO>smsAccountWSDTOS = new ArrayList<>();
        List<WappAccountWSDTO>wappAccountWSDTOS = new ArrayList<>();
        List<EmailAccountWSDTO>emailAccountWSDTOS = new ArrayList<>();
        List<PushAccountWSDTO>pushAccountWSDTOS = new ArrayList<>();

        List<SipAccountDBModel> sipAccountDBModels = sipAccountRepository.findByStatus(1);
        for (SipAccountDBModel sipAccountDBModel : sipAccountDBModels) {
            sipAccountWSDTOS.add(fillSipAccountWSDTO(sipAccountDBModel));
        }
        channelAccountWSDTO.setSipAccounts(sipAccountWSDTOS);

        List<SmsAccountDBModel> smsAccountDBModels = smsAccountRepository.findByStatus(1);
        for (SmsAccountDBModel smsAccountDBModel : smsAccountDBModels) {
            smsAccountWSDTOS.add(fillSmsAccountWSDTO(smsAccountDBModel));
        }
        channelAccountWSDTO.setSmsAccounts(smsAccountWSDTOS);

        List<WappAccountDBModel> wappAccountDBModels = wappAccountRepository.findByStatus(1);
        for (WappAccountDBModel wappAccountDBModel : wappAccountDBModels) {
            wappAccountWSDTOS.add(fillWappAccountWSDTO(wappAccountDBModel));
        }
        channelAccountWSDTO.setWappAccounts(wappAccountWSDTOS);

        List<EmailAccountDBModel> emailAccountDBModels = emailAccountRepository.findByStatus(1);
        for (EmailAccountDBModel emailAccountDBModel : emailAccountDBModels) {
            emailAccountWSDTOS.add(fillEmailAccountWSDTO(emailAccountDBModel));
        }
        channelAccountWSDTO.setEmailAccounts(emailAccountWSDTOS);

        List<PushAccountDBModel>pushAccountDBModels = pushAccountRepository.findByStatus(1);
        for (PushAccountDBModel pushAccountDBModel : pushAccountDBModels) {
            pushAccountWSDTOS.add(fillPushAccountWSDTO(pushAccountDBModel));
        }
        channelAccountWSDTO.setPushAccounts(pushAccountWSDTOS);

        return channelAccountWSDTO;
    }


    public SipAccountWSDTO fillSipAccountWSDTO(SipAccountDBModel sipAccountDBModel) {

        SipAccountWSDTO sipAccountWSDTO = new SipAccountWSDTO();
        sipAccountWSDTO.setSipAccount(sipAccountDBModel);
        return sipAccountWSDTO;
    }

    public SipAccountDBModel createSipAccountService(String account,String userName,String authUser,String password,String sipUrl,String provider) {

        SipAccountDBModel sipAccountDBModel = new SipAccountDBModel();
        sipAccountDBModel.setAccount(account);
        sipAccountDBModel.setUserName(userName);
        sipAccountDBModel.setAuthUser(authUser);
        sipAccountDBModel.setPassword(password);
        sipAccountDBModel.setSipUrl(sipUrl);
        sipAccountDBModel.setAccountDatas(new ArrayList<>());
        sipAccountDBModel.setProvider(provider);
        sipAccountDBModel.setuDate(appUtils.getCurrentTimeStamp());
        sipAccountDBModel.setcDate(appUtils.getCurrentTimeStamp());
        sipAccountDBModel.setStatus(1);

        return sipAccountRepository.save(sipAccountDBModel);
    }

    public SipAccountDBModel updateSipAccountService(String accountId,String account,String userName,String authUser,String password,String sipUrl,String provider) {

        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipAccountDBModel.isPresent()){

            sipAccountDBModel.get().setAccount(account);
            sipAccountDBModel.get().setUserName(userName);
            sipAccountDBModel.get().setAuthUser(authUser);
            sipAccountDBModel.get().setPassword(password);
            sipAccountDBModel.get().setSipUrl(sipUrl);
            sipAccountDBModel.get().setProvider(provider);
            sipAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            sipAccountDBModel.get().setStatus(1);

            return sipAccountRepository.save(sipAccountDBModel.get());
        }
        return null;
    }

    public SipAccountDBModel removeSipAccountService(String accountId) {

        Optional<SipAccountDBModel> sipAccountDBModel = sipAccountRepository.findById(accountId);
        if (sipAccountDBModel.isPresent()){
            sipAccountRepository.delete(sipAccountDBModel.get());
            return sipAccountDBModel.get();
        }
        return null;
    }


    public SmsAccountWSDTO fillSmsAccountWSDTO(SmsAccountDBModel smsAccountDBModel) {

        SmsAccountWSDTO smsAccountWSDTO = new SmsAccountWSDTO();
        smsAccountWSDTO.setSmsAccount(smsAccountDBModel);
        return smsAccountWSDTO;
    }


    public SmsAccountDBModel createSmsAccountService(String account,String userName,String password,String apiToken,String apiUrl,String provider) {

        SmsAccountDBModel smsAccountDBModel = new SmsAccountDBModel();
        smsAccountDBModel.setAccount(account);
        smsAccountDBModel.setUserName(userName);
        smsAccountDBModel.setPassword(password);
        smsAccountDBModel.setApiToken(apiToken);
        smsAccountDBModel.setApiUrl(apiUrl);
        smsAccountDBModel.setAccountDatas(new ArrayList<>());
        smsAccountDBModel.setProvider(provider);
        smsAccountDBModel.setuDate(appUtils.getCurrentTimeStamp());
        smsAccountDBModel.setcDate(appUtils.getCurrentTimeStamp());
        smsAccountDBModel.setStatus(1);

        return smsAccountRepository.save(smsAccountDBModel);
    }

    public SmsAccountDBModel updateSmsAccountService(String accountId,String account,String userName,String password,String apiToken,String apiUrl,String provider) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){
            smsAccountDBModel.get().setAccount(account);
            smsAccountDBModel.get().setUserName(userName);
            smsAccountDBModel.get().setPassword(password);
            smsAccountDBModel.get().setApiToken(apiToken);
            smsAccountDBModel.get().setApiUrl(apiUrl);
            smsAccountDBModel.get().setProvider(provider);
            smsAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            smsAccountDBModel.get().setStatus(1);

            return smsAccountRepository.save(smsAccountDBModel.get());
        }
        return null;
    }

    public SmsAccountDBModel removeSmsAccountService(String accountId) {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(accountId);
        if (smsAccountDBModel.isPresent()){
            smsAccountRepository.delete(smsAccountDBModel.get());
            return smsAccountDBModel.get();
        }
        return null;
    }


    public WappAccountWSDTO fillWappAccountWSDTO(WappAccountDBModel wappAccountDBModel) {

        WappAccountWSDTO wappAccountWSDTO = new WappAccountWSDTO();
        wappAccountWSDTO.setWappAccount(wappAccountDBModel);
        return wappAccountWSDTO;
    }


    public WappQRCodeWSDTO getWappAccountQRCodeService(String accountId) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            String qrCodeInBase64 = wappChannelService.getWappQRCodeInBase64Service(wappAccountDBModel.get().getServerUrl(),wappAccountDBModel.get().getInstanceKey());
            if (qrCodeInBase64 != null){
                WappQRCodeWSDTO wappQRCodeWSDTO = new WappQRCodeWSDTO();
                wappQRCodeWSDTO.setQrCodeStatus(AppConstant.GENERAL_SUCCESS_STATUS);
                wappQRCodeWSDTO.setQrCodeInBase64(qrCodeInBase64);
                return wappQRCodeWSDTO;
            }
        }
        return null;
    }


    public WappAccountDBModel createWappAccountService(String account,String phoneNumber, long serverId) throws IOException {

        Optional<WappServerDBModel> wappServerDBModel = wappServerRepository.findById(serverId);
        if (wappServerDBModel.isPresent()){
            String instanceKey = wappChannelService.initWappChannelService(wappServerDBModel.get().getServerUrl());
            if (instanceKey != null){

                WappAccountDBModel wappAccountDBModel = new WappAccountDBModel();
                wappAccountDBModel.setAccount(account);
                wappAccountDBModel.setInstanceKey(instanceKey);
                wappAccountDBModel.setPhoneNumber(phoneNumber);
                wappAccountDBModel.setAccountDatas(new ArrayList<>());
                wappAccountDBModel.setServerId(wappServerDBModel.get().getId());
                wappAccountDBModel.setWappServer(wappServerDBModel.get().getWappServer());
                wappAccountDBModel.setServerUrl(wappServerDBModel.get().getServerUrl());
                wappAccountDBModel.setServerType(wappServerDBModel.get().getServerType());
                wappAccountDBModel.setuDate(appUtils.getCurrentTimeStamp());
                wappAccountDBModel.setcDate(appUtils.getCurrentTimeStamp());
                wappAccountDBModel.setStatus(1);

                return wappAccountRepository.save(wappAccountDBModel);
            }

        }
        return null;
    }

    public WappAccountDBModel updateWappAccountService(String accountId,String account,String instanceKey,String phoneNumber,String serverUrl) {

        Optional<WappAccountDBModel> whatsappAccountDBModel = wappAccountRepository.findById(accountId);
        if (whatsappAccountDBModel.isPresent()){

            whatsappAccountDBModel.get().setAccount(account);
            whatsappAccountDBModel.get().setInstanceKey(instanceKey);
            whatsappAccountDBModel.get().setPhoneNumber(phoneNumber);
            whatsappAccountDBModel.get().setServerUrl(serverUrl);
            whatsappAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            whatsappAccountDBModel.get().setStatus(1);

            return wappAccountRepository.save(whatsappAccountDBModel.get());
        }
        return null;
    }


    public WappAccountDBModel removeWappAccountService(String accountId) {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(accountId);
        if (wappAccountDBModel.isPresent()){
            wappAccountRepository.delete(wappAccountDBModel.get());
            return wappAccountDBModel.get();
        }
        return null;
    }


    public EmailAccountWSDTO fillEmailAccountWSDTO(EmailAccountDBModel emailAccountDBModel) {

        EmailAccountWSDTO emailAccountWSDTO = new EmailAccountWSDTO();
        emailAccountWSDTO.setEmailAccount(emailAccountDBModel);
        return emailAccountWSDTO;
    }


    public EmailAccountDBModel createEmailAccountService(String account,String provider) {

        EmailAccountDBModel emailAccountDBModel = new EmailAccountDBModel();

        emailAccountDBModel.setAccount(account);
        emailAccountDBModel.setAccountDatas(new ArrayList<>());
        emailAccountDBModel.setProvider(provider);
        emailAccountDBModel.setuDate(appUtils.getCurrentTimeStamp());
        emailAccountDBModel.setcDate(appUtils.getCurrentTimeStamp());
        emailAccountDBModel.setStatus(1);

        return emailAccountRepository.save(emailAccountDBModel);
    }

    public EmailAccountDBModel updateEmailAccountService(String accountId,String account,String provider) {

        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()){

            emailAccountDBModel.get().setAccount(account);
            emailAccountDBModel.get().setProvider(provider);
            emailAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            emailAccountDBModel.get().setStatus(1);

            return emailAccountRepository.save(emailAccountDBModel.get());
        }
        return null;
    }


    public EmailAccountDBModel removeEmailAccountService(String accountId) {

        Optional<EmailAccountDBModel> emailAccountDBModel = emailAccountRepository.findById(accountId);
        if (emailAccountDBModel.isPresent()){
            emailAccountRepository.delete(emailAccountDBModel.get());
            return emailAccountDBModel.get();
        }
        return null;
    }


    public PushAccountWSDTO fillPushAccountWSDTO(PushAccountDBModel pushAccountDBModel) {

        PushAccountWSDTO pushAccountWSDTO = new PushAccountWSDTO();
        pushAccountWSDTO.setPushAccount(pushAccountDBModel);
        return pushAccountWSDTO;
    }

    public PushAccountDBModel createPushAccountService(String account, String provider) {

        PushAccountDBModel pushAccountDBModel =  new PushAccountDBModel();

        pushAccountDBModel.setAccount(account);
        pushAccountDBModel.setAccountDatas(new ArrayList<>());
        pushAccountDBModel.setProvider(provider);
        pushAccountDBModel.setuDate(appUtils.getCurrentTimeStamp());
        pushAccountDBModel.setcDate(appUtils.getCurrentTimeStamp());
        pushAccountDBModel.setStatus(1);

        return pushAccountRepository.save(pushAccountDBModel);
    }

    public PushAccountDBModel updatePushAccountService(String accountId, String account, String provider) {

        Optional<PushAccountDBModel> pushAccountDBModel =  pushAccountRepository.findById(accountId);
        if (pushAccountDBModel.isPresent()){

            pushAccountDBModel.get().setAccount(account);
            pushAccountDBModel.get().setProvider(provider);
            pushAccountDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            pushAccountDBModel.get().setStatus(1);

            return pushAccountRepository.save(pushAccountDBModel.get());
        }
        return null;
    }

    public PushAccountDBModel removePushAccountService(String accountId) {

        Optional<PushAccountDBModel> pushAccountDBModel =  pushAccountRepository.findById(accountId);
        if (pushAccountDBModel.isPresent()){
            pushAccountRepository.delete(pushAccountDBModel.get());
            return pushAccountDBModel.get();
        }
        return null;
    }



}
