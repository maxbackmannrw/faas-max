package com.faas.core.api.endpoint.controller.notification;

import com.faas.core.api.middleware.notification.ApiNotificationMiddleware;
import com.faas.core.api.model.ws.notification.ApiNotificationWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/notification/")
public class ApiNotificationController {


    @Autowired
    ApiNotificationMiddleware apiNotificationMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_NOTIFICATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetNotifications(@RequestParam long agentId) {

        ApiNotificationWSModel response = apiNotificationMiddleware.apiGetNotifications(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_NOTIFICATIONS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetNotificationsByState(@RequestParam long agentId) {

        ApiNotificationWSModel response = apiNotificationMiddleware.apiGetNotificationsByState(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetNotification(@RequestParam long agentId) {

        ApiNotificationWSModel response = apiNotificationMiddleware.apiGetNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateNotification(@RequestParam long agentId) {

        ApiNotificationWSModel response = apiNotificationMiddleware.apiUpdateNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveNotification(@RequestParam long agentId) {

        ApiNotificationWSModel response = apiNotificationMiddleware.apiRemoveNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
