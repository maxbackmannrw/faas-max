package com.faas.core.data.db.client.details.dao;

public class ClientPhoneDAO {

    private String id;
    private String phoneNumber;
    private String phoneCarrier;
    private String phoneType;
    private long cDate;
    private int status;

    public ClientPhoneDAO() {
    }

    public ClientPhoneDAO(String id, String phoneNumber, String phoneCarrier, String phoneType, long cDate, int status) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.phoneCarrier = phoneCarrier;
        this.phoneType = phoneType;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneCarrier() {
        return phoneCarrier;
    }

    public void setPhoneCarrier(String phoneCarrier) {
        this.phoneCarrier = phoneCarrier;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
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
