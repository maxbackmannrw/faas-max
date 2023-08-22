package com.faas.core.base.middleware.notification.content;

import com.faas.core.base.framework.notification.content.NotificationFramework;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.notification.content.NotificationWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotificationMiddleware {

    @Autowired
    NotificationFramework notificationFramework;


    public NotificationWSModel getAllNotifications(long userId) {

        NotificationWSModel response = new NotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public NotificationWSModel getNotificationsByState(long userId) {

        NotificationWSModel response = new NotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getNotificationsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public NotificationWSModel getNotification(long userId) {

        NotificationWSModel response = new NotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public NotificationWSModel createNotification(long userId) {

        NotificationWSModel response = new NotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("createNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public NotificationWSModel updateNotification(long userId) {

        NotificationWSModel response = new NotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("updateNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public NotificationWSModel removeNotification(long userId) {

        NotificationWSModel response = new NotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }
}
