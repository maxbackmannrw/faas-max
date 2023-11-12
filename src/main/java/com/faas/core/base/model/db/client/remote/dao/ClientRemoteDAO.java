package com.faas.core.base.model.db.client.remote.dao;

public class ClientRemoteDAO {

    private String remoteUrl;
    private long uDate;
    private long cDate;
    private int status;

    public ClientRemoteDAO() {
    }

    public ClientRemoteDAO(String remoteUrl, long uDate, long cDate, int status) {
        this.remoteUrl = remoteUrl;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
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
