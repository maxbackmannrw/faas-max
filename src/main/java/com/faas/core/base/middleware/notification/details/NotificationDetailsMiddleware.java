package com.faas.core.base.middleware.notification.details;

import com.faas.core.base.framework.notification.details.NotificationDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.notification.details.NotificationDetailsWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotificationDetailsMiddleware {


    @Autowired
    NotificationDetailsFramework notificationDetailsFramework;


    public NotificationDetailsWSModel getNotificationDetails(long userId) {

        NotificationDetailsWSModel response = new NotificationDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getNotificationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
