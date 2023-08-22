package com.faas.core.api.model.ws.notification;

import com.faas.core.api.model.ws.notification.dto.ApiNotificationDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiNotificationDetailsWSModel {

    private GeneralWSModel general;
    private ApiNotificationDetailsWSDTO notificationDetails;

    public ApiNotificationDetailsWSModel() {
    }

    public ApiNotificationDetailsWSModel(GeneralWSModel general, ApiNotificationDetailsWSDTO notificationDetails) {
        this.general = general;
        this.notificationDetails = notificationDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiNotificationDetailsWSDTO getNotificationDetails() {
        return notificationDetails;
    }

    public void setNotificationDetails(ApiNotificationDetailsWSDTO notificationDetails) {
        this.notificationDetails = notificationDetails;
    }
}
