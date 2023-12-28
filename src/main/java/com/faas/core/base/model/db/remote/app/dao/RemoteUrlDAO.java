package com.faas.core.base.model.db.remote.app.dao;

public class RemoteUrlDAO {

    private String id;
    private String remoteUrl;
    private String urlType;
    private long cDate;
    private int status;

    public RemoteUrlDAO() {
    }

    public RemoteUrlDAO(String id, String remoteUrl, String urlType, long cDate, int status) {
        this.id = id;
        this.remoteUrl = remoteUrl;
        this.urlType = urlType;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
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
