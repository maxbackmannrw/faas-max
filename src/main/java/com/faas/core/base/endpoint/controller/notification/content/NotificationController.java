package com.faas.core.base.endpoint.controller.notification.content;

import com.faas.core.base.middleware.notification.content.NotificationMiddleware;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.notification.content.NotificationWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/notification/")
public class NotificationController {


    @Autowired
    NotificationMiddleware notificationMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_NOTIFICATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllNotifications(@RequestParam long agentId) {

        NotificationWSModel response = notificationMiddleware.getAllNotifications(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_NOTIFICATIONS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getNotificationsByState(@RequestParam long agentId) {

        NotificationWSModel response = notificationMiddleware.getNotificationsByState(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> getNotification(@RequestParam long agentId) {

        NotificationWSModel response = notificationMiddleware.getNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> createNotification(@RequestParam long agentId) {

        NotificationWSModel response = notificationMiddleware.createNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateNotification(@RequestParam long agentId) {

        NotificationWSModel response = notificationMiddleware.updateNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_NOTIFICATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeNotification(@RequestParam long agentId) {

        NotificationWSModel response = notificationMiddleware.removeNotification(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
