package com.faas.core.base.model.db.notification.dao;

public class NotificationContentDAO {

    private String contentId;
    private String contentType;
    private String content;
    private long cDate;
    private int status;

    public NotificationContentDAO() {
    }

    public NotificationContentDAO(String contentId, String contentType, String content, long cDate, int status) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.content = content;
        this.cDate = cDate;
        this.status = status;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
