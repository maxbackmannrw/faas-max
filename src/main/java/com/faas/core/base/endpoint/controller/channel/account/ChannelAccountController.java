package com.faas.core.base.endpoint.controller.channel.account;

import com.faas.core.base.middleware.channel.account.ChannelAccountMiddleware;
import com.faas.core.base.model.ws.channel.account.*;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/channel/account/")
public class ChannelAccountController {


    @Autowired
    ChannelAccountMiddleware channelAccountMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CHANNEL_ACCOUNTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllChannelAccounts(@RequestParam long userId) {

        ChannelAccountWSModel response = channelAccountMiddleware.getAllChannelAccounts(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_ALL_SIP_ACCOUNTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSipAccounts(@RequestParam long userId) {

        SipAccountWSModel response = channelAccountMiddleware.getAllSipAccounts(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> getSipAccount(@RequestParam long userId,
                                           @RequestParam String accountId) {

        SipAccountWSModel response = channelAccountMiddleware.getSipAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> createSipAccount(@RequestParam long userId,
                                              @RequestParam String account,
                                              @RequestParam String userName,
                                              @RequestParam String authUser,
                                              @RequestParam String password,
                                              @RequestParam String sipUrl,
                                              @RequestParam String provider) {

        SipAccountWSModel response = channelAccountMiddleware.createSipAccount(userId, account, userName, authUser, password, sipUrl, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> updateSipAccount(@RequestParam long userId,
                                              @RequestParam String accountId,
                                              @RequestParam String account,
                                              @RequestParam String userName,
                                              @RequestParam String authUser,
                                              @RequestParam String password,
                                              @RequestParam String sipUrl,
                                              @RequestParam String provider) {

        SipAccountWSModel response = channelAccountMiddleware.updateSipAccount(userId, accountId, account, userName, authUser, password, sipUrl, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> removeSipAccount(@RequestParam long userId,
                                              @RequestParam String accountId) {

        SipAccountWSModel response = channelAccountMiddleware.removeSipAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_SMS_ACCOUNTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllSmsAccounts(@RequestParam long userId) {

        SmsAccountWSModel response = channelAccountMiddleware.getAllSmsAccounts(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_SMS_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> getSmsAccount(@RequestParam long userId,
                                           @RequestParam String accountId) {

        SmsAccountWSModel response = channelAccountMiddleware.getSmsAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_SMS_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> createSmsAccount(@RequestParam long userId,
                                              @RequestParam String account,
                                              @RequestParam String userName,
                                              @RequestParam String password,
                                              @RequestParam String apiToken,
                                              @RequestParam String apiUrl,
                                              @RequestParam String provider) {

        SmsAccountWSModel response = channelAccountMiddleware.createSmsAccount(userId, account, userName, password, apiToken, apiUrl, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_SMS_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> updateSmsAccount(@RequestParam long userId,
                                              @RequestParam String accountId,
                                              @RequestParam String account,
                                              @RequestParam String userName,
                                              @RequestParam String password,
                                              @RequestParam String apiToken,
                                              @RequestParam String apiUrl,
                                              @RequestParam String provider) {

        SmsAccountWSModel response = channelAccountMiddleware.updateSmsAccount(userId, accountId, account, userName, password, apiToken, apiUrl, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_SMS_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> removeSmsAccount(@RequestParam long userId,
                                              @RequestParam String accountId) {

        SmsAccountWSModel response = channelAccountMiddleware.removeSmsAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_WAPP_ACCOUNTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllWappAccounts(@RequestParam long userId) {

        WappAccountWSModel response = channelAccountMiddleware.getAllWappAccounts(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> getWappAccount(@RequestParam long userId,
                                            @RequestParam String accountId) {

        WappAccountWSModel response = channelAccountMiddleware.getWappAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_ACCOUNT_QR_CODE, method = RequestMethod.POST)
    public ResponseEntity<?> getWappAccountQRCode(@RequestParam long userId,
                                                  @RequestParam String accountId) throws IOException {

        WappQRCodeWSModel response = channelAccountMiddleware.getWappAccountQRCode(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_WAPP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> createWappAccount(@RequestParam long userId,
                                               @RequestParam String account,
                                               @RequestParam String phoneNumber,
                                               @RequestParam long serverId) throws IOException {

        WappAccountWSModel response = channelAccountMiddleware.createWappAccount(userId, account, phoneNumber, serverId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappAccount(@RequestParam long userId,
                                               @RequestParam String accountId,
                                               @RequestParam String account,
                                               @RequestParam String instanceKey,
                                               @RequestParam String phoneNumber,
                                               @RequestParam long serverId) {

        WappAccountWSModel response = channelAccountMiddleware.updateWappAccount(userId, accountId, account, instanceKey, phoneNumber, serverId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappAccount(@RequestParam long userId,
                                               @RequestParam String accountId) {

        WappAccountWSModel response = channelAccountMiddleware.removeWappAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_EMAIL_ACCOUNTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllEmailAccounts(@RequestParam long userId) {

        EmailAccountWSModel response = channelAccountMiddleware.getAllEmailAccounts(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_EMAIL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailAccount(@RequestParam long userId,
                                             @RequestParam String accountId) {

        EmailAccountWSModel response = channelAccountMiddleware.getEmailAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_EMAIL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailAccount(@RequestParam long userId,
                                                @RequestParam String account,
                                                @RequestParam String provider) {

        EmailAccountWSModel response = channelAccountMiddleware.createEmailAccount(userId, account, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailAccount(@RequestParam long userId,
                                                @RequestParam String accountId,
                                                @RequestParam String account,
                                                @RequestParam String provider) {

        EmailAccountWSModel response = channelAccountMiddleware.updateEmailAccount(userId, accountId, account, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_EMAIL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> removeEmailAccount(@RequestParam long userId,
                                                @RequestParam String accountId) {

        EmailAccountWSModel response = channelAccountMiddleware.removeEmailAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_PUSH_ACCOUNTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllPushAccounts(@RequestParam long userId) {

        PushAccountWSModel response = channelAccountMiddleware.getAllPushAccounts(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PUSH_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> getPushAccount(@RequestParam long userId,
                                            @RequestParam String accountId) {

        PushAccountWSModel response = channelAccountMiddleware.getPushAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PUSH_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> createPushAccount(@RequestParam long userId,
                                               @RequestParam String account,
                                               @RequestParam String provider) {

        PushAccountWSModel response = channelAccountMiddleware.createPushAccount(userId, account, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PUSH_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> updatePushAccount(@RequestParam long userId,
                                               @RequestParam String accountId,
                                               @RequestParam String account,
                                               @RequestParam String provider) {

        PushAccountWSModel response = channelAccountMiddleware.updatePushAccount(userId, accountId, account, provider);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PUSH_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> removePushAccount(@RequestParam long userId,
                                               @RequestParam String accountId) {

        PushAccountWSModel response = channelAccountMiddleware.removePushAccount(userId, accountId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
