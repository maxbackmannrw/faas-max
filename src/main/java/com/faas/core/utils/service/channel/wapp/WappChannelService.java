package com.faas.core.utils.service.channel.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.endpoint.request.channel.wapp.WappChannelRequest;
import com.faas.core.utils.endpoint.request.utility.CommonRequest;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class WappChannelService {

    @Autowired
    WappChannelRequest wappChannelRequest;

    @Autowired
    CommonRequest commonRequest;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public String initWappChannelService(String serverUrl) throws IOException {
        return wappChannelRequest.initWappChannelRequest(serverUrl);
    }


    public String getWappQRCodeInBase64Service(String serverUrl,String instanceKey) throws IOException {
        return wappChannelRequest.getWappQRCodeInBase64Rest(serverUrl,instanceKey);
    }

    @Async
    public void sendAsyncWappMessageService(OperationWappMessageDBModel wappMessageDBModel) throws IOException {

        /*
        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(operationWappMessageDBModel.getWappMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());

        if (wappAccountDBModel.isPresent() && processDBModel.isPresent()) {
            operationWappMessageDBModel = generateWappMessageBodyService(sessionDBModel, operationWappMessageDBModel,wappAccountDBModel.get(),processDBModel.get());
            if (operationWappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.TEXT_MESSAGE)){
                wappRestClient.sendWappTextMessageRest(operationWappMessageDBModel,wappAccountDBModel.get());
            }
            if (operationWappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.IMAGE_MESSAGE)){
            }
            if (operationWappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.VOICE_MESSAGE)){
            }
            if (operationWappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.VIDEO_MESSAGE)){
            }
            if (operationWappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.DOC_MESSAGE)){
            }
        }

         */
    }


    public OperationWappMessageDBModel generateWappMessageBodyService(SessionDBModel sessionDBModel, OperationWappMessageDBModel operationWappMessageDBModel, WappAccountDBModel wappAccountDBModel, ProcessDBModel processDBModel) throws IOException {

        String wappMessageBody = operationWappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            wappMessageBody = wappMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (wappMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                Map<String,String> pwaUrlMap = commonRequest.urlShortenerRest(pwaUrl);
                if (pwaUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                 //   operationWappMessageDBModel.getWappMessage().getMessageMaps().putAll(pwaUrlMap);
                }
            }
        }
        if (wappMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = commonRequest.urlShortenerRest(nativeUrl);
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
