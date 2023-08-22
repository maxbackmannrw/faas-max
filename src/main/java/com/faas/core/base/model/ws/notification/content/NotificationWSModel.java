package com.faas.core.base.model.ws.notification.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.notification.content.dto.NotificationWSDTO;

import java.util.List;

public class NotificationWSModel {

    private GeneralWSModel general;
    private List<NotificationWSDTO>notifications;

    public NotificationWSModel() {
    }

    public NotificationWSModel(GeneralWSModel general, List<NotificationWSDTO> notifications) {
        this.general = general;
        this.notifications = notifications;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<NotificationWSDTO> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationWSDTO> notifications) {
        this.notifications = notifications;
    }
}
