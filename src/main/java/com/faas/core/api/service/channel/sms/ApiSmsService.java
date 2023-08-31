package com.faas.core.api.service.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.api.endpoint.restclient.channel.sms.ApiSmsRestClient;
import com.faas.core.api.endpoint.restclient.utils.ApiUtilityRestClient;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class ApiSmsService {

    @Autowired
    ApiUtilityRestClient apiUtilityRestClient;

    @Autowired
    ApiSmsRestClient apiSmsRestClient;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void outSendSmsMessage(SessionDBModel sessionDBModel,SmsMessageDBModel smsMessageDBModel) throws IOException {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(smsMessageDBModel.getSmsMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (smsAccountDBModel.isPresent() && processDBModel.isPresent()) {
            smsMessageDBModel = populateSmsMessage(sessionDBModel,smsMessageDBModel,smsAccountDBModel.get(),processDBModel.get());
            if (smsMessageDBModel != null) {
              String sentResult = apiSmsRestClient.sendSmsMessageRestCall(smsMessageDBModel,smsAccountDBModel.get());
                if (sentResult != null){
                    smsMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);
                    smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
                    smsMessageRepository.save(smsMessageDBModel);
                }
            }
        }
    }


    public SmsMessageDBModel populateSmsMessage(SessionDBModel sessionDBModel,SmsMessageDBModel smsMessageDBModel,SmsAccountDBModel smsAccountDBModel,ProcessDBModel processDBModel) throws IOException {

        String smsMessageBody = smsMessageDBModel.getSmsMessage().getSmsBody();
        if (smsMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            smsMessageBody = smsMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (smsMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.createOperationUrls(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                smsMessageBody = smsMessageBody.replace(AppConstant.PWA_URL_TAG, apiUtilityRestClient.createShorterUrl(pwaUrl));
            }
        }
        if (smsMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.createOperationUrls(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                smsMessageBody = smsMessageBody.replace(AppConstant.NATIVE_URL_TAG, apiUtilityRestClient.createShorterUrl(nativeUrl));
            }
        }
        smsMessageDBModel.getSmsMessage().setSmsBody(smsMessageBody);
        smsMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);

        return smsMessageDBModel;
    }


}
