package com.faas.core.base.model.db.client.details.content.dao;

public class ClientEmailDAO {

    private String id;
    private String emailAddress;
    private long cDate;
    private int status;

    public ClientEmailDAO() {
    }

    public ClientEmailDAO(String id, String emailAddress, long cDate, int status) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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