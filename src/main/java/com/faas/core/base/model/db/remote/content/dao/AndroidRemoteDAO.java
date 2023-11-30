package com.faas.core.base.model.db.remote.content.dao;

public class AndroidRemoteDAO {

    private String id;
    private String remoteBrand;
    private String remoteModel;
    private String remoteOS;
    private String remoteUrl;
    private long uDate;
    private long cDate;
    private int status;

    public AndroidRemoteDAO() {
    }

    public AndroidRemoteDAO(String id, String remoteBrand, String remoteModel, String remoteOS, String remoteUrl, long uDate, long cDate, int status) {
        this.id = id;
        this.remoteBrand = remoteBrand;
        this.remoteModel = remoteModel;
        this.remoteOS = remoteOS;
        this.remoteUrl = remoteUrl;
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

    public String getRemoteBrand() {
        return remoteBrand;
    }

    public void setRemoteBrand(String remoteBrand) {
        this.remoteBrand = remoteBrand;
    }

    public String getRemoteModel() {
        return remoteModel;
    }

    public void setRemoteModel(String remoteModel) {
        this.remoteModel = remoteModel;
    }

    public String getRemoteOS() {
        return remoteOS;
    }

    public void setRemoteOS(String remoteOS) {
        this.remoteOS = remoteOS;
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
