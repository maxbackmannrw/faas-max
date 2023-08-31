package com.faas.core.external.service.channel.message;

import com.faas.core.base.model.db.channel.account.SmsAccountDBModel;
import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.channel.account.SmsAccountRepository;
import com.faas.core.base.repo.operation.channel.SmsMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class ExtWappMessageService {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    AppUtils appUtils;


    public void sendSmsMessageService(SmsMessageDBModel smsMessageDBModel) throws IOException {

        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(smsMessageDBModel.getSmsMessage().getAccountId());
        if (smsAccountDBModel.isPresent()) {
            String smsMessageBody = smsMessageBodyPopulate(smsMessageDBModel);
            if (smsMessageBody == null) {
                return;
            }
            String smsApiUrl = "smsAccountDBModel.get().getSmsApiUrl()";
            String accountUserName = smsAccountDBModel.get().getUserName();
            String accountPassword = smsAccountDBModel.get().getPassword();
            String smsType = appUtils.convertSmsType(smsMessageDBModel.getSmsMessage().getMessageType());
            String senderId = smsMessageDBModel.getSmsMessage().getSenderId();
            String phoneNumber = smsMessageDBModel.getPhoneNumber();

            String sentResult = sendSmsMessageIntegration(smsApiUrl, accountUserName, accountPassword, smsType, senderId, phoneNumber, smsMessageBody);
            if (!sentResult.equalsIgnoreCase(AppConstant.GENERAL_FAIL_STATUS)) {

                smsMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);
                smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
                smsMessageRepository.save(smsMessageDBModel);
            }
        }
    }


    public String sendSmsMessageIntegration(String smsApiUrl, String userName, String password, String smsType, String senderId,
                                            String phoneNumber, String messageBody) throws IOException {

        RequestBody formBody = new FormBody.Builder()
                .add("username", userName)
                .add("password", password)
                .add("mt", smsType)
                .add("fl", "fl")
                .add("Sid", senderId)
                .add("mno", phoneNumber)
                .add("msg", messageBody)
                .build();

        Request request = new Request.Builder()
                .url(smsApiUrl)
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




    public String smsMessageBodyPopulate(SmsMessageDBModel smsMessageDBModel) throws IOException {

        String smsMessageBody = smsMessageDBModel.getSmsMessage().getSmsBody();
        if (smsMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
           // smsMessageBody = smsMessageBody.replace(AppConstant.MESSAGE_CLIENT_NAME_TAG, smsMessageDBModel.getClientName());
        }

        return smsMessageBody;
    }


    public String smsPWAShortLinkCreate(SmsMessageDBModel smsMessageDBModel) throws IOException {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(smsMessageDBModel.getProcessId());

        return null;
    }


}
