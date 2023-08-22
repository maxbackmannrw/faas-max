package com.faas.core.api.middleware.notification;

import com.faas.core.api.framework.notification.ApiNotificationFramework;
import com.faas.core.api.model.ws.notification.ApiNotificationWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiNotificationMiddleware {


    @Autowired
    ApiNotificationFramework apiNotificationFramework;


    public ApiNotificationWSModel apiGetNotifications(long agentId) {

        ApiNotificationWSModel response = new ApiNotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetNotifications");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiNotificationWSModel apiGetNotificationsByState(long agentId) {

        ApiNotificationWSModel response = new ApiNotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetNotificationsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiNotificationWSModel apiGetNotification(long agentId) {

        ApiNotificationWSModel response = new ApiNotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiNotificationWSModel apiUpdateNotification(long agentId) {

        ApiNotificationWSModel response = new ApiNotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiNotificationWSModel apiRemoveNotification(long agentId) {

        ApiNotificationWSModel response = new ApiNotificationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiRemoveNotification");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
