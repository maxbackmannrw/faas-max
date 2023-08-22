package com.faas.core.base.framework.notification.details;

import com.faas.core.base.model.ws.notification.details.dto.NotificationDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotificationDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public NotificationDetailsWSDTO getNotificationDetailsService() {

        NotificationDetailsWSDTO notificationDetailsWSDTO = new NotificationDetailsWSDTO();

        return notificationDetailsWSDTO;
    }




}
