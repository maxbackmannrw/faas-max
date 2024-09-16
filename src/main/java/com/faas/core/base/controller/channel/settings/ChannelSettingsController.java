package com.faas.core.base.controller.channel.settings;

import com.faas.core.base.middleware.channel.settings.ChannelSettingsMiddleware;
import com.faas.core.data.ws.base.channel.settings.EmailTypeWSModel;
import com.faas.core.data.ws.base.channel.settings.MessageTypeWSModel;
import com.faas.core.data.ws.base.channel.settings.PushTypeWSModel;
import com.faas.core.data.ws.base.channel.settings.WappServerWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/channel/settings/")
public class ChannelSettingsController {


    @Autowired
    ChannelSettingsMiddleware channelSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_EMAIL_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllEmailTypes(@RequestParam long userId) {

        EmailTypeWSModel response = channelSettingsMiddleware.getAllEmailTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_EMAIL_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getEmailType(@RequestParam long userId,
                                          @RequestParam long typeId) {

        EmailTypeWSModel response = channelSettingsMiddleware.getEmailType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_EMAIL_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createEmailType(@RequestParam long userId,
                                             @RequestParam String emailType) {

        EmailTypeWSModel response = channelSettingsMiddleware.createEmailType(userId, emailType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_EMAIL_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateEmailType(@RequestParam long userId,
                                             @RequestParam long typeId,
                                             @RequestParam String emailType) {

        EmailTypeWSModel response = channelSettingsMiddleware.updateEmailType(userId, typeId, emailType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_EMAIL_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeEmailType(@RequestParam long userId,
                                             @RequestParam long typeId) {

        EmailTypeWSModel response = channelSettingsMiddleware.removeEmailType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PUSH_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getPushTypes(@RequestParam long userId) {

        PushTypeWSModel response = channelSettingsMiddleware.getPushTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PUSH_TYPES_BY_MAIN, method = RequestMethod.POST)
    public ResponseEntity<?> getPushTypesByMain(@RequestParam long userId,
                                                @RequestParam String mainType) {

        PushTypeWSModel response = channelSettingsMiddleware.getPushTypesByMain(userId, mainType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PUSH_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getPushType(@RequestParam long userId,
                                         @RequestParam long typeId) {

        PushTypeWSModel response = channelSettingsMiddleware.getPushType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PUSH_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createPushType(@RequestParam long userId,
                                            @RequestParam String pushType,
                                            @RequestParam String mainType) {

        PushTypeWSModel response = channelSettingsMiddleware.createPushType(userId, pushType, mainType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PUSH_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updatePushType(@RequestParam long userId,
                                            @RequestParam long typeId,
                                            @RequestParam String pushType,
                                            @RequestParam String mainType) {

        PushTypeWSModel response = channelSettingsMiddleware.updatePushType(userId, typeId, pushType, mainType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PUSH_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removePushType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        PushTypeWSModel response = channelSettingsMiddleware.removePushType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_MESSAGE_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllMessageTypes(@RequestParam long userId) {

        MessageTypeWSModel response = channelSettingsMiddleware.getAllMessageTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_MESSAGE_TYPES_BY_MAIN, method = RequestMethod.POST)
    public ResponseEntity<?> getMessageTypesByMain(@RequestParam long userId,
                                                   @RequestParam String mainType) {

        MessageTypeWSModel response = channelSettingsMiddleware.getMessageTypesByMain(userId, mainType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_MESSAGE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getMessageType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        MessageTypeWSModel response = channelSettingsMiddleware.getMessageType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_MESSAGE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createMessageType(@RequestParam long userId,
                                               @RequestParam String messageType,
                                               @RequestParam String mainType) {

        MessageTypeWSModel response = channelSettingsMiddleware.createMessageType(userId, messageType, mainType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_MESSAGE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateMessageType(@RequestParam long userId,
                                               @RequestParam long typeId,
                                               @RequestParam String messageType,
                                               @RequestParam String mainType) {

        MessageTypeWSModel response = channelSettingsMiddleware.updateMessageType(userId, typeId, messageType, mainType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_MESSAGE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeMessageType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        MessageTypeWSModel response = channelSettingsMiddleware.removeMessageType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_WAPP_SERVERS, method = RequestMethod.POST)
    public ResponseEntity<?> getWappServers(@RequestParam long userId) {

        WappServerWSModel response = channelSettingsMiddleware.getWappServers(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_WAPP_SERVER, method = RequestMethod.POST)
    public ResponseEntity<?> getWappServer(@RequestParam long userId,
                                           @RequestParam long serverId) {

        WappServerWSModel response = channelSettingsMiddleware.getWappServer(userId, serverId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_WAPP_SERVER, method = RequestMethod.POST)
    public ResponseEntity<?> createWappServer(@RequestParam long userId,
                                              @RequestParam String serverName,
                                              @RequestParam String serverUrl,
                                              @RequestParam String serverType) {

        WappServerWSModel response = channelSettingsMiddleware.createWappServer(userId, serverName, serverUrl, serverType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_WAPP_SERVER, method = RequestMethod.POST)
    public ResponseEntity<?> updateWappServer(@RequestParam long userId,
                                              @RequestParam long serverId,
                                              @RequestParam String serverName,
                                              @RequestParam String serverUrl,
                                              @RequestParam String serverType) {

        WappServerWSModel response = channelSettingsMiddleware.updateWappServer(userId, serverId, serverName, serverUrl, serverType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_WAPP_SERVER, method = RequestMethod.POST)
    public ResponseEntity<?> removeWappServer(@RequestParam long userId,
                                              @RequestParam long serverId) {

        WappServerWSModel response = channelSettingsMiddleware.removeWappServer(userId, serverId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
