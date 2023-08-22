package com.faas.core.base.endpoint.controller.notification.details;

import com.faas.core.base.middleware.notification.details.NotificationDetailsMiddleware;
import com.faas.core.base.model.ws.notification.details.NotificationDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/notification/details/")
public class NotificationDetailsController {


    @Autowired
    NotificationDetailsMiddleware notificationDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_NOTIFICATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getNotificationDetails(@RequestParam long agentId) {

        NotificationDetailsWSModel response = notificationDetailsMiddleware.getNotificationDetails(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
