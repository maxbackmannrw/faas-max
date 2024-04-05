package com.faas.core.utils.handler.channel.push;

import com.faas.core.base.model.db.operation.details.channel.OperationPushDBModel;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PushChannelHandler {


    @Autowired
    AppUtils appUtils;


    @Async
    public void sendAsyncPushService(OperationPushDBModel operationPushDBModel) throws IOException {

        /*
        Optional<SmsAccountDBModel> smsAccountDBModel = smsAccountRepository.findById(operationSmsMessageDBModel.getSmsMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (smsAccountDBModel.isPresent() && processDBModel.isPresent()) {
            operationSmsMessageDBModel = generateSmsBodyService(sessionDBModel, operationSmsMessageDBModel,smsAccountDBModel.get(),processDBModel.get());
            /smsChannelRestCall.sendSmsMessageRest(operationSmsMessageDBModel,smsAccountDBModel.get());
        }
         */
        System.out.println("async sendAsyncPushService  worked");
    }



}
