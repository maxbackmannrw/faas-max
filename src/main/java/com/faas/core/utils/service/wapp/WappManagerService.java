package com.faas.core.utils.service.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class WappManagerService {

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    WappManagerRESTCall wappManagerRESTCall;

    @Autowired
    AppUtils appUtils;


    public String initWappInstanceService(String serverUrl) throws IOException {
        return wappManagerRESTCall.initWappInstance(serverUrl);
    }


    public String getWappQRCodeInBase64(String serverUrl,String instanceKey) throws IOException {
        return wappManagerRESTCall.getWappQRCodeInBase64(serverUrl,instanceKey);
    }


    public void sendWappMessageService(OperationWappMessageDBModel operationWappMessageDBModel) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(operationWappMessageDBModel.getWappMessage().getAccountId());
        if (wappAccountDBModel.isPresent()) {
            if (operationWappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.TEXT_MESSAGE)) {
                String messageBody = wappMessageBodyPopulate(operationWappMessageDBModel);
                if (messageBody != null && wappManagerRESTCall.sendWappTextMessage(wappAccountDBModel.get().getServerUrl(), wappAccountDBModel.get().getInstanceKey(), operationWappMessageDBModel.getClientPhone().getPhoneNumber(), messageBody)) {
                    operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENT);
                    operationWappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
                    operationWappMessageRepository.save(operationWappMessageDBModel);
                }
            }
        }
    }


    public String wappMessageBodyPopulate(OperationWappMessageDBModel operationWappMessageDBModel) throws IOException {

        String wappMessageBody = operationWappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
        //    wappMessageBody = wappMessageBody.replace(AppConstant.MESSAGE_CLIENT_NAME_TAG, wappMessageDBModel.getClientName());
        }
        return wappMessageBody;
    }


    public String wappPWAShortLinkCreate(OperationWappMessageDBModel operationWappMessageDBModel) throws IOException {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(operationWappMessageDBModel.getProcessId());
        return null;
    }


}
