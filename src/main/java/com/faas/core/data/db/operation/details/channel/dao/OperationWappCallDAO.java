package com.faas.core.data.db.operation.details.channel.dao;

public class OperationWappCallDAO {

    private String numberId;
    private String phoneNumber;
    private String numberType;
    private String accountId;
    private long sDate;
    private long fDate;
    private int status;

    public OperationWappCallDAO() {
    }

    public OperationWappCallDAO(String numberId, String phoneNumber, String numberType, String accountId, long sDate, long fDate, int status) {
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.numberType = numberType;
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

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
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
