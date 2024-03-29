package com.faas.core.utils.service.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.operation.details.channel.OperationSmsRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.endpoint.request.channel.sms.SmsChannelRequest;
import com.faas.core.utils.endpoint.request.utility.CommonRequest;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class SmsChannelService {

    @Autowired
    CommonRequest commonRequest;

    @Autowired
    SmsChannelRequest smsChannelRequest;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    OperationSmsRepository operationSmsRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void sendAsyncSmsService(OperationSmsDBModel operationSmsDBModel) throws IOException {

        /*
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(operationSmsMessageDBModel.getSmsMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (smsAccountDBModel.isPresent() && processDBModel.isPresent()) {
            operationSmsMessageDBModel = generateSmsBodyService(sessionDBModel, operationSmsMessageDBModel,smsAccountDBModel.get(),processDBModel.get());
            /smsChannelRestCall.sendSmsMessageRest(operationSmsMessageDBModel,smsAccountDBModel.get());
        }
         */
        System.out.println("async sendAsyncSmsService  worked");
    }


    public OperationSmsDBModel generateSmsBodyService(SessionDBModel sessionDBModel, OperationSmsDBModel operationSmsDBModel, SmsAccountDBModel smsAccountDBModel, ProcessDBModel processDBModel) throws IOException {

        String smsMessageBody = operationSmsDBModel.getSmsMessage().getSmsBody();
        if (smsMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            smsMessageBody = smsMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (smsMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                Map<String,String> pwaUrlMap = commonRequest.urlShortenerRest(pwaUrl);
                if (pwaUrlMap != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                }
            }
        }
        if (smsMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = commonRequest.urlShortenerRest(nativeUrl);
                if (nativeUrlMap != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.NATIVE_URL_TAG, appUtils.getValueFromMap(nativeUrlMap,"shortnedUrl"));
                }
            }
        }
        operationSmsDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return operationSmsRepository.save(operationSmsDBModel);
    }


}
