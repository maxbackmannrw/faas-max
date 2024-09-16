package com.faas.core.misc.rest.channel.sms;

import com.faas.core.data.db.channel.account.SmsAccountDBModel;
import com.faas.core.data.db.operation.details.channel.OperationSmsDBModel;
import com.faas.core.data.repo.operation.details.channel.OperationSmsRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.rest.utility.RestCallTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SmsChannelRestCall {


    @Autowired
    RestCallTemplate restCallTemplate;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    AppUtils appUtils;


    public OperationSmsDBModel sendSmsRestCall(OperationSmsDBModel operationSmsDBModel, SmsAccountDBModel smsAccountDBModel) throws IOException {

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
        return null;
    }


}
