package com.faas.core.external.service.channel.message;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.external.endpoint.restcall.channel.message.ExtSmsMessageRestCall;
import com.faas.core.external.endpoint.restcall.utils.ExtUtilityRestCall;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class ExtSmsMessageService {

    @Autowired
    ExtUtilityRestCall extUtilityRestCall;

    @Autowired
    ExtSmsMessageRestCall extSmsMessageRestCall;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void extSendSmsMessageService(SessionDBModel sessionDBModel,SmsMessageDBModel smsMessageDBModel) throws IOException {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(smsMessageDBModel.getSmsMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (smsAccountDBModel.isPresent() && processDBModel.isPresent()) {
            smsMessageDBModel = populateSmsMessage(sessionDBModel,smsMessageDBModel,smsAccountDBModel.get(),processDBModel.get());
            /*
            if (smsMessageDBModel != null) {
              String sentResult = extSmsMessageRestCall.sendSmsMessageRestCall(smsMessageDBModel,smsAccountDBModel.get());
                if (sentResult != null){
                    smsMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);
                    smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
                    smsMessageRepository.save(smsMessageDBModel);
                }
            }
              */
        }
    }


    public SmsMessageDBModel populateSmsMessage(SessionDBModel sessionDBModel,SmsMessageDBModel smsMessageDBModel,SmsAccountDBModel smsAccountDBModel,ProcessDBModel processDBModel) throws IOException {

        String smsMessageBody = smsMessageDBModel.getSmsMessage().getSmsBody();
        if (smsMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            smsMessageBody = smsMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (smsMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = createSmsMessageUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                smsMessageBody = smsMessageBody.replace(AppConstant.PWA_URL_TAG,extUtilityRestCall.createShorterUrl(pwaUrl));
            }
        }
        if (smsMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = createSmsMessageUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                smsMessageBody = smsMessageBody.replace(AppConstant.NATIVE_URL_TAG,extUtilityRestCall.createShorterUrl(nativeUrl));
            }
        }
        smsMessageDBModel.getSmsMessage().setSmsBody(smsMessageBody);
        smsMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);
        smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return smsMessageRepository.save(smsMessageDBModel);
    }


    public String createSmsMessageUrl(SessionDBModel sessionDBModel,ProcessDBModel processDBModel,String urlType){

        if (processDBModel.getProcessUrls() != null && !processDBModel.getProcessUrls().isEmpty()){
            for (int i=0;i<processDBModel.getProcessUrls().size();i++){
                if (processDBModel.getProcessUrls().get(i).getUrlType().equalsIgnoreCase(urlType)){
                    return processDBModel.getProcessUrls().get(i).getUrl()+"?sid="+sessionDBModel.getId()+"&cid="+sessionDBModel.getClientId();
                }
            }
        }
        return null;
    }








}
