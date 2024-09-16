package com.faas.core.misc.handler.channel.sms;

import com.faas.core.data.db.channel.account.SmsAccountDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.details.channel.OperationSmsDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.channel.account.SmsAccountRepository;
import com.faas.core.data.repo.operation.details.channel.OperationSmsRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.rest.channel.sms.SmsChannelRestCall;
import com.faas.core.misc.rest.utility.CommonRestCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;


@Service
public class SmsChannelHandler {


    @Autowired
    CommonRestCall commonRestCall;

    @Autowired
    SmsChannelRestCall smsChannelRestCall;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    SmsAccountRepository smsAccountRepository;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    AppUtils appUtils;


    @Async
    public void sendAsyncSmsHandler(OperationDBModel operationModel, OperationSmsDBModel operationSmsModel) throws IOException {

        Optional<SmsAccountDBModel> smsAccountModel = smsAccountRepository.findById(operationSmsModel.getOperationSms().getAccountId());
        if (smsAccountModel.isPresent() && operationSmsModel.getOperationSms() != null && operationSmsModel.getOperationSms().getSmsBody() != null) {
            operationSmsModel = smsChannelRestCall.sendSmsRestCall(prepareOperationSmsHandler(operationModel, operationSmsModel), smsAccountModel.get());
            if (operationSmsModel != null) {
                OperationSmsRepository.save(operationSmsModel);
            }
        }
    }

    public OperationSmsDBModel prepareOperationSmsHandler(OperationDBModel operationModel, OperationSmsDBModel operationSmsModel) throws IOException {

        operationSmsModel = replaceSmsClientNameTag(operationModel, operationSmsModel);
        operationSmsModel = replaceSmsRemoteUrlsTag(operationModel, operationSmsModel);

            /*
            if (smsBody.contains(AppConstant.PWA_URL_TAG)) {
                String pwaUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.PWA_URL);
                if (pwaUrl != null){
                    Map<String,String> pwaUrlMap = commonRestCall.urlShortenerRest(pwaUrl);
                    if (pwaUrlMap != null){
                        smsMessageBody = smsMessageBody.replace(AppConstant.PWA_URL_TAG, appUtils.getValueFromMap(pwaUrlMap,"shortnedUrl"));
                    }
                }
            }

                    String smsMessageBody = operationSmsDBModel.getSmsMessage().getSmsBody();


        if (smsMessageBody.contains(AppConstant.NATIVE_URL_TAG)) {
            String nativeUrl = appUtils.getSelectedUrl(sessionDBModel,processDBModel,AppConstant.NATIVE_URL);
            if (nativeUrl != null){
                Map<String,String> nativeUrlMap = commonRequest.urlShortenerRest(nativeUrl);
                if (nativeUrlMap != null){
                    smsMessageBody = smsMessageBody.replace(AppConstant.NATIVE_URL_TAG, appUtils.getValueFromMap(nativeUrlMap,"shortnedUrl"));
                }
            }
        }
        operationSmsDBModel.setuDate(appUtils.getCurrentTimeStamp());

        return operationSmsRepository.save(operationSmsDBModel);

*/

        operationSmsModel.setSmsState(AppConstant.MESSAGE_SENDING);
        operationSmsModel.setuDate(appUtils.getCurrentTimeStamp());

        return OperationSmsRepository.save(operationSmsModel);
    }

    public OperationSmsDBModel replaceSmsClientNameTag(OperationDBModel operationModel, OperationSmsDBModel operationSmsModel) {

        String smsBody = operationSmsModel.getOperationSms().getSmsBody();
        if (smsBody.contains(AppConstant.CLIENT_NAME_TAG)) {
            smsBody = smsBody.replace(AppConstant.CLIENT_NAME_TAG, operationModel.getClientName());
            operationSmsModel.getOperationSms().setSmsBody(smsBody);
        }
        return operationSmsModel;
    }

    public OperationSmsDBModel replaceSmsRemoteUrlsTag(OperationDBModel operationModel, OperationSmsDBModel operationSmsModel) {

        String smsBody = operationSmsModel.getOperationSms().getSmsBody();
        if (smsBody.contains(AppConstant.REMOTE_URL_TAG)) {
            smsBody = smsBody.replace(AppConstant.CLIENT_NAME_TAG, operationModel.getClientName());
            operationSmsModel.getOperationSms().setSmsBody(smsBody);
        }
        return operationSmsModel;
    }


}
