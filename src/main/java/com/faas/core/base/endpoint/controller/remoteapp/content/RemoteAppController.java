package com.faas.core.base.endpoint.controller.remoteapp.content;

import com.faas.core.base.middleware.remoteapp.content.RemoteAppMiddleware;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppSummaryWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppWSModel;
import com.faas.core.base.model.ws.remoteapp.details.RemoteAppDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remoteapp/")
public class RemoteAppController {


    @Autowired
    RemoteAppMiddleware remoteAppMiddleware;


    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteApps(@RequestParam long userId,
                                           @RequestParam String connState,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        RemoteAppListWSModel response = remoteAppMiddleware.getRemoteApps(userId, connState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS_BY_BASE_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppsByBaseType(@RequestParam long userId,
                                                     @RequestParam String connState,
                                                     @RequestParam String baseType,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        RemoteAppListWSModel response = remoteAppMiddleware.getRemoteAppsByBaseType(userId, connState, baseType, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_APPS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteApps(@RequestParam long userId,
                                                 @RequestParam long clientId) {

        RemoteAppListWSModel response = remoteAppMiddleware.getClientRemoteApps(userId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteApp(@RequestParam long userId,
                                          @RequestParam String remoteAppId) {

        RemoteAppWSModel response = remoteAppMiddleware.getRemoteApp(userId, remoteAppId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> createRemoteApp(@RequestParam long userId,
                                             @RequestParam String operationId,
                                             @RequestParam String remoteId) {

        RemoteAppWSModel response = remoteAppMiddleware.createRemoteApp(userId, operationId, remoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> updateRemoteApp(@RequestParam long userId,
                                             @RequestParam String remoteAppId,
                                             @RequestParam String remoteState) {

        RemoteAppWSModel response = remoteAppMiddleware.updateRemoteApp(userId, remoteAppId, remoteState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_REMOTE_APP, method = RequestMethod.POST)
    public ResponseEntity<?> removeRemoteApp(@RequestParam long userId,
                                             @RequestParam String remoteAppId) {

        RemoteAppWSModel response = remoteAppMiddleware.removeRemoteApp(userId, remoteAppId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APP_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppDetails(@RequestParam long userId,
                                                 @RequestParam String remoteAppId) {

        RemoteAppDetailsWSModel response = remoteAppMiddleware.getRemoteAppDetails(userId, remoteAppId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_REMOTE_APPS_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteAppsSummary(@RequestParam long userId) {

        RemoteAppSummaryWSModel response = remoteAppMiddleware.getRemoteAppsSummary(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
