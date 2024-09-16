package com.faas.core.misc.handler.channel.wapp;

import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.channel.account.WappAccountDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.channel.account.WappAccountRepository;
import com.faas.core.data.repo.operation.details.channel.OperationWappMessageRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.rest.channel.wapp.WappChannelRestCall;
import com.faas.core.misc.rest.utility.CommonRestCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WappChannelHandler {

    @Autowired
    CommonRestCall commonRestCall;

    @Autowired
    WappChannelRestCall wappChannelRestCall;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    WappAccountRepository wappAccountRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    AppUtils appUtils;

    public String initWappChannelService(String serverUrl) throws IOException {
        return wappChannelRestCall.initWappChannelRequest(serverUrl);
    }

    public String getWappAccountQRCodeService(String serverUrl, String instanceKey) throws IOException {
        return wappChannelRestCall.getWappAccountQRCodeRequest(serverUrl, instanceKey);
    }

    @Async
    public void sendAsyncWappMessageHandler(OperationWappMessageDBModel operationWappMessageDBModel) throws IOException {

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

    public OperationWappMessageDBModel prepareWappMessageHandler(OperationDBModel operationDBModel, OperationWappMessageDBModel operationWappMessageDBModel, WappAccountDBModel wappAccountDBModel, CampaignDBModel campaignDBModel) throws IOException {

        String wappMessageBody = operationWappMessageDBModel.getOperationWappMessage().getWappBody();
        if (wappMessageBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            wappMessageBody = wappMessageBody.replace(AppConstant.CLIENT_NAME_TAG, operationDBModel.getClientName());
        }
        /*
        if (wappMessageBody.contains(AppConstant.PWA_URL_TAG)) {
            String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
            if (pwaUrl != null){
                Map<String,String> pwaUrlMap = commonRestCall.urlShortenerRest(pwaUrl);
                if (pwaUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                 //   operationWappMessageDBModel.getWappMessage().getMessageMaps().putAll(pwaUrlMap);
                }
            }
        }
        if (wappMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = commonRestCall.urlShortenerRest(nativeUrl);
                if (nativeUrlMap != null){
                    wappMessageBody = wappMessageBody.replace(AppConstant.NATIVE_URL_TAG, appUtils.getValueFromMap(nativeUrlMap,"shortnedUrl"));
                   // operationWappMessageDBModel.getWappMessage().getMessageMaps().putAll(nativeUrlMap);
                }
            }
        }
        */
        operationWappMessageDBModel.getOperationWappMessage().setWappBody(wappMessageBody);
        operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENDING);
        operationWappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return operationWappMessageRepository.save(operationWappMessageDBModel);
    }


}
