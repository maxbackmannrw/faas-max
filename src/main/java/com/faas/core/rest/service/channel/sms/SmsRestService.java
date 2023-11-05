package com.faas.core.rest.service.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.operation.details.channel.OperationSmsMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.rest.call.channel.sms.SmsMessageRestCall;
import com.faas.core.rest.call.utility.UtilityRestCall;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@Component
public class SmsRestService {

    @Autowired
    UtilityRestCall utilityRestCall;

    @Autowired
    SmsMessageRestCall smsMessageRestCall;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void sendSmsMessageService(SessionDBModel sessionDBModel, OperationSmsMessageDBModel operationSmsMessageDBModel) throws IOException {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(operationSmsMessageDBModel.getSmsMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (smsAccountDBModel.isPresent() && processDBModel.isPresent()) {
            operationSmsMessageDBModel = generateSmsBodyService(sessionDBModel, operationSmsMessageDBModel,smsAccountDBModel.get(),processDBModel.get());
            smsMessageRestCall.sendSmsMessageRest(operationSmsMessageDBModel,smsAccountDBModel.get());
        }
    }


    public OperationSmsMessageDBModel generateSmsBodyService(SessionDBModel sessionDBModel, OperationSmsMessageDBModel operationSmsMessageDBModel, SmsAccountDBModel smsAccountDBModel, ProcessDBModel processDBModel) throws IOException {

        String smsMessageBody = operationSmsMessageDBModel.getSmsMessage().getSmsBody();
        if (smsMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            smsMessageBody = smsMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (smsMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                Map<String,String> pwaUrlMap = utilityRestCall.urlShortenerRest(pwaUrl);
                if (pwaUrlMap != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                    operationSmsMessageDBModel.getSmsMessage().getMessageMaps().putAll(pwaUrlMap);
                }
            }
        }
        if (smsMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = utilityRestCall.urlShortenerRest(nativeUrl);
                if (nativeUrlMap != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.NATIVE_URL_TAG, appUtils.getValueFromMap(nativeUrlMap,"shortnedUrl"));
                    operationSmsMessageDBModel.getSmsMessage().getMessageMaps().putAll(nativeUrlMap);
                }
            }
        }
        operationSmsMessageDBModel.getSmsMessage().setSmsBody(smsMessageBody);
        operationSmsMessageDBModel.setMessageState(AppConstant.MESSAGE_SENDING);
        operationSmsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return operationSmsMessageRepository.save(operationSmsMessageDBModel);
    }


}
