package com.faas.core.api.endpoint.restclient.channel.sms;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ApiSmsRestClient {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public String sendSmsMessageRestCall(SmsMessageDBModel smsMessageDBModel, SmsAccountDBModel smsAccountDBModel) throws IOException {

        RequestBody formBody = new FormBody.Builder()
                .add("username", smsAccountDBModel.getUserName())
                .add("password", smsAccountDBModel.getPassword())
                .add("mt", appUtils.convertSmsType(smsMessageDBModel.getSmsMessage().getMessageType()))
                .add("fl", "fl")
                .add("Sid", smsMessageDBModel.getSmsMessage().getSenderId())
                .add("mno", smsMessageDBModel.getPhoneNumber())
                .add("msg", smsMessageDBModel.getSmsMessage().getSmsBody())
                .build();

        Request request = new Request.Builder()
                .url(smsAccountDBModel.getApiUrl())
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "text/plain")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                if (response.body() != null) {
                    System.out.println("response.body()" + response.body().string());
                    return response.body().string();
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
            return AppConstant.GENERAL_FAIL_STATUS;
        }

    }


}
