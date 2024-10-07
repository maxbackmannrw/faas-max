package com.faas.core.data.db.client.details.dao;

public class ClientPhoneDAO {

    private String id;
    private String phoneNumber;
    private String phoneCarrier;
    private String numberType;
    private long cDate;
    private int status;

    public ClientPhoneDAO() {
    }

    public ClientPhoneDAO(String id, String phoneNumber, String phoneCarrier, String numberType, long cDate, int status) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.phoneCarrier = phoneCarrier;
        this.numberType = numberType;
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

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
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
