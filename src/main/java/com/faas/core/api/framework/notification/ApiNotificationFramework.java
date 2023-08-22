package com.faas.core.api.framework.notification;

import com.faas.core.api.model.ws.notification.dto.ApiNotificationWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiNotificationFramework {


    @Autowired
    AppUtils appUtils;


    public ApiNotificationWSDTO apiGetAgentNotificationService() {

        return null;
    }

    public List<ApiNotificationWSDTO> apiGetNotificationsService() {

        return null;
    }

    public List<ApiNotificationWSDTO> apiGetNotificationsByStateService() {

        return null;
    }

    public ApiNotificationWSDTO apiGetNotificationService() {

        return null;
    }

    public ApiNotificationWSDTO apiUpdateNotificationService() {

        return null;
    }


    public ApiNotificationWSDTO apiRemoveNotificationService() {

        return null;
    }


}
