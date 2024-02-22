package com.faas.core.base.model.db.operation.details.channel.dao;

public class OperationSipCallDAO {

    private String numberId;
    private String phoneNumber;
    private String phoneCarrier;
    private String phoneType;
    private String accountId;
    private long sDate;
    private long fDate;
    private int status;

    public OperationSipCallDAO() {
    }

    public OperationSipCallDAO(String numberId, String phoneNumber, String phoneCarrier, String phoneType, String accountId, long sDate, long fDate, int status) {
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.phoneCarrier = phoneCarrier;
        this.phoneType = phoneType;
        this.accountId = accountId;
        this.sDate = sDate;
        this.fDate = fDate;
        this.status = status;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getsDate() {
        return sDate;
    }

    public void setsDate(long sDate) {
        this.sDate = sDate;
    }

    public long getfDate() {
        return fDate;
    }

    public void setfDate(long fDate) {
        this.fDate = fDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
