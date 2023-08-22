package com.faas.core.base.model.db.notification;

import com.faas.core.base.model.db.notification.dao.NotificationContentDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "notification_table")
public class NotificationDBModel {

    @Id
    private String id;
    private long agentId;
    private String agentName;
    private String notificationTitle;
    private String notificationText;
    private String destinationId;
    private String destinationType;
    private String destinationUrl;
    private List<NotificationContentDAO>contents;
    private String notificationType;
    private String notificationState;
    private long uDate;
    private long cDate;
    private int status;

    public NotificationDBModel() {
    }

    public NotificationDBModel(String id, long agentId, String agentName, String notificationTitle, String notificationText, String destinationId, String destinationType, String destinationUrl, List<NotificationContentDAO> contents, String notificationType, String notificationState, long uDate, long cDate, int status) {
        this.id = id;
        this.agentId = agentId;
        this.agentName = agentName;
        this.notificationTitle = notificationTitle;
        this.notificationText = notificationText;
        this.destinationId = destinationId;
        this.destinationType = destinationType;
        this.destinationUrl = destinationUrl;
        this.contents = contents;
        this.notificationType = notificationType;
        this.notificationState = notificationState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    public String getDestinationUrl() {
        return destinationUrl;
    }

    public void setDestinationUrl(String destinationUrl) {
        this.destinationUrl = destinationUrl;
    }

    public List<NotificationContentDAO> getContents() {
        return contents;
    }

    public void setContents(List<NotificationContentDAO> contents) {
        this.contents = contents;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(String notificationState) {
        this.notificationState = notificationState;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
