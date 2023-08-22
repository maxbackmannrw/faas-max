package com.faas.core.api.model.ws.notification;

import com.faas.core.api.model.ws.notification.dto.ApiNotificationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiNotificationWSModel {

    private GeneralWSModel general;
    private List<ApiNotificationWSDTO>notifications;


    public ApiNotificationWSModel() {
    }

    public ApiNotificationWSModel(GeneralWSModel general, List<ApiNotificationWSDTO> notifications) {
        this.general = general;
        this.notifications = notifications;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiNotificationWSDTO> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<ApiNotificationWSDTO> notifications) {
        this.notifications = notifications;
    }
}
