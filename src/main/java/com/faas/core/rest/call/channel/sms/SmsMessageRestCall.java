package com.faas.core.rest.call.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.rest.call.content.RestCall;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class SmsMessageRestCall {

    @Autowired
    RestCall restCall;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageRest(SmsMessageDBModel smsMessageDBModel, SmsAccountDBModel smsAccountDBModel) throws IOException {

        Map<String,String> formData = new HashMap<>();
        formData.put("username", smsAccountDBModel.getUserName());
        formData.put("password", smsAccountDBModel.getPassword());
        formData.put("mt", appUtils.convertSmsType(smsMessageDBModel.getSmsMessage().getMessageType()));
        formData.put("fl", "fl");
        formData.put("Sid", smsMessageDBModel.getSmsMessage().getSenderId());
        formData.put("mno", smsMessageDBModel.getPhoneNumber());
        formData.put("msg", smsMessageDBModel.getSmsMessage().getSmsBody());
        String requestUrl = restCall.urlBuilder(smsAccountDBModel.getApiUrl(),"",null);

        String response = restCall.sendPostFormRequest(requestUrl,formData);
        if (response != null){
            smsMessageDBModel.setMessageState(AppConstant.MESSAGE_SENT);
        }else {
            smsMessageDBModel.setMessageState(AppConstant.MESSAGE_FAILED);
        }
        smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        smsMessageRepository.save(smsMessageDBModel);
    }



}
