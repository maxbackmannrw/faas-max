package com.faas.core.base.model.db.channel.settings;

import javax.persistence.*;

@Entity
@Table(name = "wapp_servers_table")
public class WappServerDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "server_name")
    private String serverName;

    @Column(name = "server_url")
    private String serverUrl;

    @Column(name = "server_type")
    private String serverType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public WappServerDBModel() {
    }

    public WappServerDBModel(long id, String serverName, String serverUrl, String serverType, long uDate, long cDate, int status) {
        this.id = id;
        this.serverName = serverName;
        this.serverUrl = serverUrl;
        this.serverType = serverType;
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

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
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
