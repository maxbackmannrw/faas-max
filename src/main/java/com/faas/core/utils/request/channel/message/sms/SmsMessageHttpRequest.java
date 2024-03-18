package com.faas.core.utils.request.channel.message.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.repo.operation.details.channel.OperationSmsMessageRepository;
import com.faas.core.utils.request.content.HttpRequest;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class SmsMessageHttpRequest {

    @Autowired
    HttpRequest httpRequest;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageRest(OperationSmsMessageDBModel operationSmsMessageDBModel, SmsAccountDBModel smsAccountDBModel) throws IOException {

        Map<String,String> formData = new HashMap<>();
        formData.put("username", smsAccountDBModel.getUserName());
        formData.put("password", smsAccountDBModel.getPassword());
        formData.put("mt", appUtils.convertSmsType(operationSmsMessageDBModel.getSmsMessage().getSmsType()));
        formData.put("fl", "fl");
        formData.put("Sid", operationSmsMessageDBModel.getSmsMessage().getSenderId());
       // formData.put("mno", operationSmsMessageDBModel.getPhoneNumber());
        formData.put("msg", operationSmsMessageDBModel.getSmsMessage().getSmsBody());
        String requestUrl = httpRequest.urlBuilder(smsAccountDBModel.getApiUrl(),"",null);

        String response = httpRequest.sendPostFormRequest(requestUrl,formData);
        if (response != null){
        }else {
        }
        operationSmsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationSmsMessageRepository.save(operationSmsMessageDBModel);
    }



}
