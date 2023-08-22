package com.faas.core.base.framework.notification.content;

import com.faas.core.base.model.ws.notification.content.dto.NotificationWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class NotificationFramework {


    @Autowired
    AppUtils appUtils;


    public List<NotificationWSDTO> getAllNotificationsService() {

        return null;
    }


    public List<NotificationWSDTO> getNotificationsByStateService() {

        return null;
    }


    public NotificationWSDTO getNotificationService() {

        return null;
    }


    public NotificationWSDTO createNotificationService() {

        return null;
    }


    public NotificationWSDTO updateNotificationService() {

        return null;
    }


    public NotificationWSDTO removeNotificationService() {

        return null;
    }

}
