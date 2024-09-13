package com.faas.core.base.model.db.remote.details;

import javax.persistence.*;

@Entity
@Table(name = "remote_url_table")
public class RemoteUrlDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "remote_id")
    private String remoteId;

    @Column(name = "remote_url")
    private String remoteUrl;

    @Column(name = "url_type")
    private String urlType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public RemoteUrlDBModel() {
    }

    public RemoteUrlDBModel(long id, String remoteId, String remoteUrl, String urlType, long uDate, long cDate, int status) {
        this.id = id;
        this.remoteId = remoteId;
        this.remoteUrl = remoteUrl;
        this.urlType = urlType;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
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
