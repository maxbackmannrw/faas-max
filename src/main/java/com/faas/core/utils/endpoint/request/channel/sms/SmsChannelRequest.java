package com.faas.core.utils.endpoint.request.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsDBModel;
import com.faas.core.base.repo.operation.details.channel.OperationSmsRepository;
import com.faas.core.utils.endpoint.request.utility.HttpRequest;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class SmsChannelRequest {

    @Autowired
    HttpRequest httpRequest;

    @Autowired
    OperationSmsRepository operationSmsRepository;

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageRest(OperationSmsDBModel operationSmsDBModel, SmsAccountDBModel smsAccountDBModel) throws IOException {

        /*
        Map<String,String> formData = new HashMap<>();
        formData.put("username", smsAccountDBModel.getUserName());
        formData.put("password", smsAccountDBModel.getPassword());
        formData.put("mt", appUtils.convertSmsType(operationSmsDBModel.getSmsMessage().getSmsType()));
        formData.put("fl", "fl");
        formData.put("Sid", operationSmsDBModel.getSmsMessage().getSenderId());
       // formData.put("mno", operationSmsMessageDBModel.getPhoneNumber());
        formData.put("msg", operationSmsDBModel.getSmsMessage().getSmsBody());
        String requestUrl = httpRequest.httpUrlBuilder(smsAccountDBModel.getApiUrl(),"",null);

        String response = httpRequest.callPostXFormRequest(requestUrl,formData);
        if (response != null){
        }else {
        }
        operationSmsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationSmsRepository.save(operationSmsDBModel);

         */
    }



}
