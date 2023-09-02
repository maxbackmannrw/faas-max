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
        return wappRestClient.initWappInstance(serverUrl);
    }


    public String getWappQRCodeInBase64Service(String serverUrl,String instanceKey) throws IOException {
        return wappRestClient.getWappQRCodeInBase64(serverUrl,instanceKey);
    }


    @Async
    public void sendWappMessageService(SessionDBModel sessionDBModel,WappMessageDBModel wappMessageDBModel) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(wappMessageDBModel.getWappMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (wappAccountDBModel.isPresent() && processDBModel.isPresent()) {
            wappMessageDBModel = populateWappMessage(sessionDBModel,wappMessageDBModel,wappAccountDBModel.get(),processDBModel.get());
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.TEXT_MESSAGE)){
                wappRestClient.sendWappTextMessage(wappMessageDBModel,wappAccountDBModel.get());
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.IMAGE_MESSAGE)){
                wappRestClient.sendWappTextMessage(wappMessageDBModel,wappAccountDBModel.get());
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.VIDEO_MESSAGE)){
                wappRestClient.sendWappTextMessage(wappMessageDBModel,wappAccountDBModel.get());
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.VIDEO_MESSAGE)){
                wappRestClient.sendWappTextMessage(wappMessageDBModel,wappAccountDBModel.get());
            }
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.FILE_MESSAGE)){
                wappRestClient.sendWappTextMessage(wappMessageDBModel,wappAccountDBModel.get());
            }
        }
    }


    public WappMessageDBModel populateWappMessage(SessionDBModel sessionDBModel,WappMessageDBModel wappMessageDBModel,WappAccountDBModel wappAccountDBModel,ProcessDBModel processDBModel) throws IOException {

        String wappMessageBody = wappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            wappMessageBody = wappMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (wappMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.generateOperationUrls(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                String pwaUrlShort = utilityRestClient.urlShortener(pwaUrl);
                if (pwaUrlShort != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.PWA_URL_TAG, pwaUrlShort);
                }
            }
        }
        if (wappMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.generateOperationUrls(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                String nativeUrlShort = utilityRestClient.urlShortener(nativeUrl);
                if (nativeUrlShort != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.NATIVE_URL_TAG, nativeUrlShort);
                }
            }
        }
        wappMessageDBModel.getWappMessage().setWappBody(wappMessageBody);

        return wappMessageDBModel;
    }


    public void sendWappMessageService(WappMessageDBModel wappMessageDBModel) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(wappMessageDBModel.getWappMessage().getAccountId());
        if (wappAccountDBModel.isPresent()) {
            if (wappMessageDBModel.getWappMessage().getMessageType().equalsIgnoreCase(AppConstant.TEXT_MESSAGE)) {



            }
        }
    }



}
