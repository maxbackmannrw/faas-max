package com.faas.core.rest.service.channel.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.rest.client.channel.wapp.WappRestClient;
import com.faas.core.rest.client.utility.UtilityRestClient;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@Component
public class WappRestService {

    @Autowired
    WappRestClient wappRestClient;

    @Autowired
    UtilityRestClient utilityRestClient;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public String initWappInstanceService(String serverUrl) throws IOException {
        return wappRestClient.initWappInstanceRest(serverUrl);
    }


    public String getWappQRCodeInBase64Service(String serverUrl,String instanceKey) throws IOException {
        return wappRestClient.getWappQRCodeInBase64Rest(serverUrl,instanceKey);
    }


    @Async
    public void sendWappMessageService(SessionDBModel sessionDBModel,WappMessageDBModel wappMessageDBModel) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(wappMessageDBModel.getWappMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());

        if (wappAccountDBModel.isPresent() && processDBModel.isPresent()) {
            wappMessageDBModel = generateWappMessageBodyService(sessionDBModel,wappMessageDBModel,wappAccountDBModel.get(),processDBModel.get());
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.TEXT_MESSAGE)){
                wappRestClient.sendWappTextMessageRest(wappMessageDBModel,wappAccountDBModel.get());
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.IMAGE_MESSAGE)){
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.VOICE_MESSAGE)){
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.VIDEO_MESSAGE)){
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.DOC_MESSAGE)){
            }
        }
    }


    public WappMessageDBModel generateWappMessageBodyService(SessionDBModel sessionDBModel,WappMessageDBModel wappMessageDBModel,WappAccountDBModel wappAccountDBModel,ProcessDBModel processDBModel) throws IOException {

        String wappMessageBody = wappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            wappMessageBody = wappMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (wappMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                Map<String,String> pwaUrlMap = utilityRestClient.urlShortenerRest(pwaUrl);
                if (pwaUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                    wappMessageDBModel.getWappMessage().getMessageMaps().putAll(pwaUrlMap);
                }
            }
        }
        if (wappMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = utilityRestClient.urlShortenerRest(nativeUrl);
                if (nativeUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.NATIVE_URL_TAG, appUtils.getValueFromMap(nativeUrlMap,"shortnedUrl"));
                    wappMessageDBModel.getWappMessage().getMessageMaps().putAll(nativeUrlMap);
                }
            }
        }
        wappMessageDBModel.getWappMessage().setWappBody(wappMessageBody);
        wappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENDING);
        wappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return wappMessageRepository.save(wappMessageDBModel);
    }



}
