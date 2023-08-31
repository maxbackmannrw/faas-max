package com.faas.core.api.service.channel.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.channel.account.WappAccountRepository;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.api.endpoint.restclient.channel.wapp.ApiWappRestClient;
import com.faas.core.api.endpoint.restclient.utils.ApiUtilityRestClient;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class ApiWappService {

    @Autowired
    ApiUtilityRestClient apiUtilityRestClient;

    @Autowired
    ApiWappRestClient apiWappRestClient;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void outSendWappMessage(SessionDBModel sessionDBModel,WappMessageDBModel wappMessageDBModel) throws IOException {

        Optional<WappAccountDBModel> wappAccountDBModel = wappAccountRepository.findById(wappMessageDBModel.getWappMessage().getAccountId());
        Optional<ProcessDBModel> processDBModel = processRepository.findById(sessionDBModel.getProcessId());
        if (wappAccountDBModel.isPresent() && processDBModel.isPresent()) {
            wappMessageDBModel = populateWappMessage(sessionDBModel,wappMessageDBModel,wappAccountDBModel.get(),processDBModel.get());
            /*
            if (wappMessageDBModel != null) {
              String sentResult = outWappMessageRest.sendSmsMessageRestCall(smsMessageDBModel,smsAccountDBModel.get());
                if (sentResult != null){
                    smsMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);
                    smsMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
                    smsMessageRepository.save(smsMessageDBModel);
                }
            }
              */
        }
    }


    public WappMessageDBModel populateWappMessage(SessionDBModel sessionDBModel,WappMessageDBModel wappMessageDBModel,WappAccountDBModel wappAccountDBModel,ProcessDBModel processDBModel) throws IOException {

        String wappMessageBody = wappMessageDBModel.getWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            wappMessageBody = wappMessageBody.replace(AppConstant.CLIENT_NAME_TAG, sessionDBModel.getClientName());
        }
        if (wappMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.createOperationUrls(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                wappMessageBody = wappMessageBody.replace(AppConstant.PWA_URL_TAG, apiUtilityRestClient.createShorterUrl(pwaUrl));
            }
        }
        if (wappMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.createOperationUrls(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                wappMessageBody = wappMessageBody.replace(AppConstant.NATIVE_URL_TAG, apiUtilityRestClient.createShorterUrl(nativeUrl));
            }
        }
        wappMessageDBModel.getWappMessage().setWappBody(wappMessageBody);
        wappMessageDBModel.setMessageState(AppConstant.SENT_MESSAGE);

        return wappMessageDBModel;
    }



}
