package com.faas.core.utils.service.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
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
    WappMessageRepository wappMessageRepository;

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


    public void sendWappMessageService(WappMessageDBModel wappMessageDBModel) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(wappMessageDBModel.getWappMessage().getAccountId());
        if (wappAccountDBModel.isPresent()) {
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.TEXT_WAPP)) {

                String messageBody = wappMessageBodyPopulate(wappMessageDBModel);
                if (messageBody != null && wappManagerRESTCall.sendWappTextMessage(wappAccountDBModel.get().getServerUrl(), wappAccountDBModel.get().getInstanceKey(), wappMessageDBModel.getPhoneNumber(), messageBody)) {
                    wappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENT);
                    wappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
                    wappMessageRepository.save(wappMessageDBModel);
                }

            }
        }
    }


    public String wappMessageBodyPopulate(WappMessageDBModel wappMessageDBModel) throws IOException {

        String wappMessageBody = wappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
        //    wappMessageBody = wappMessageBody.replace(AppConstant.MESSAGE_CLIENT_NAME_TAG, wappMessageDBModel.getClientName());
        }
        return wappMessageBody;
    }


    public String wappPWAShortLinkCreate(WappMessageDBModel wappMessageDBModel) throws IOException {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(wappMessageDBModel.getProcessId());
        return null;
    }


}
