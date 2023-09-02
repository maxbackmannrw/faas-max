package com.faas.core.rest.service.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.rest.client.channel.sms.SmsMessageRestClient;
import com.faas.core.rest.client.utility.UtilityRestClient;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class SmsMessageRestService {

    @Autowired
    UtilityRestClient utilityRestClient;

    @Autowired
    SmsMessageRestClient smsMessageRestClient;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void sendSmsMessageService(SessionDBModel sessionDBModel,SmsMessageDBModel smsMessageDBModel) throws IOException {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(smsMessageDBModel.getSmsMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (smsAccountDBModel.isPresent() && processDBModel.isPresent()) {
            smsMessageDBModel = populateSmsBodyService(sessionDBModel,smsMessageDBModel,smsAccountDBModel.get(),processDBModel.get());
            smsMessageRestClient.sendSmsMessage(smsMessageDBModel,smsAccountDBModel.get());
        }
    }


    public SmsMessageDBModel populateSmsBodyService(SessionDBModel sessionDBModel,SmsMessageDBModel smsMessageDBModel,SmsAccountDBModel smsAccountDBModel,ProcessDBModel processDBModel) throws IOException {

        String smsMessageBody = smsMessageDBModel.getSmsMessage().getSmsBody();
        if (smsMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            smsMessageBody = smsMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (smsMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.generateOperationUrls(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                String pwaUrlShort = utilityRestClient.urlShortener(pwaUrl);
                if (pwaUrlShort != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.PWA_URL_TAG, pwaUrlShort);
                }
            }
        }
        if (smsMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.generateOperationUrls(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                String nativeUrlShort = utilityRestClient.urlShortener(nativeUrl);
                if (nativeUrlShort != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.NATIVE_URL_TAG, nativeUrlShort);
                }
            }
        }
        smsMessageDBModel.getSmsMessage().setSmsBody(smsMessageBody);
        smsMessageDBModel.setMessageState(AppConstant.MESSAGE_SENDING);
        smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return smsMessageRepository.save(smsMessageDBModel);
    }


}