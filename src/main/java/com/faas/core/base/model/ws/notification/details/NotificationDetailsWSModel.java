package com.faas.core.base.model.ws.notification.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.notification.details.dto.NotificationDetailsWSDTO;

import java.util.List;

public class NotificationDetailsWSModel {

    private GeneralWSModel general;
    private List<NotificationDetailsWSDTO>notificationDetails;

    public NotificationDetailsWSModel() {
    }

    public NotificationDetailsWSModel(GeneralWSModel general, List<NotificationDetailsWSDTO> notificationDetails) {
        this.general = general;
        this.notificationDetails = notificationDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<NotificationDetailsWSDTO> getNotificationDetails() {
        return notificationDetails;
    }

    public void setNotificationDetails(List<NotificationDetailsWSDTO> notificationDetails) {
        this.notificationDetails = notificationDetails;
    }
}
