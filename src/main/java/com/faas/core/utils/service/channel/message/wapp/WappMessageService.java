package com.faas.core.utils.service.channel.message.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.request.channel.call.wapp.WappCallHttpRequest;
import com.faas.core.utils.request.utility.UtilityHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@Service
public class WappMessageService {

    @Autowired
    WappCallHttpRequest wappRestClient;

    @Autowired
    UtilityHttpRequest utilityHttpRequest;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public String initWappInstanceService(String serverUrl) throws IOException {
        return wappRestClient.initWappInstanceRest(serverUrl);
    }


    public String getWappQRCodeInBase64Service(String serverUrl,String instanceKey) throws IOException {
        return wappRestClient.getWappQRCodeInBase64Rest(serverUrl,instanceKey);
    }


    @Async
    public void sendWappMessageService(OperationWappMessageDBModel wappMessageDBModel) {

        System.out.println("async sendWappMessageService  worked");
    }


    public OperationWappMessageDBModel generateWappMessageBodyService(SessionDBModel sessionDBModel, OperationWappMessageDBModel operationWappMessageDBModel, WappAccountDBModel wappAccountDBModel, ProcessDBModel processDBModel) throws IOException {

        String wappMessageBody = operationWappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            wappMessageBody = wappMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (wappMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                Map<String,String> pwaUrlMap = utilityHttpRequest.urlShortenerRest(pwaUrl);
                if (pwaUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                 //   operationWappMessageDBModel.getWappMessage().getMessageMaps().putAll(pwaUrlMap);
                }
            }
        }
        if (wappMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = utilityHttpRequest.urlShortenerRest(nativeUrl);
                if (nativeUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.NATIVE_URL_TAG, appUtils.getValueFromMap(nativeUrlMap,"shortnedUrl"));
                   // operationWappMessageDBModel.getWappMessage().getMessageMaps().putAll(nativeUrlMap);
                }
            }
        }
        operationWappMessageDBModel.getWappMessage().setWappBody(wappMessageBody);
        operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENDING);
        operationWappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return operationWappMessageRepository.save(operationWappMessageDBModel);
    }



}
