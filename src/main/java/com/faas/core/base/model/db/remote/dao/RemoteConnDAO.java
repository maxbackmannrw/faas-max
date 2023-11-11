package com.faas.core.base.model.db.remote.dao;

public class RemoteConnDAO {

    private String connUrl;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteConnDAO() {
    }

    public RemoteConnDAO(String connUrl, long uDate, long cDate, int status) {
        this.connUrl = connUrl;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getConnUrl() {
        return connUrl;
    }

    public void setConnUrl(String connUrl) {
        this.connUrl = connUrl;
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
