package com.faas.core.base.model.db.channel.account;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "wapp_accounts_table")
public class WappAccountDBModel {

    @Id
    private String id;
    private String account;
    private String instanceKey;
    private String phoneNumber;
    private List<AccountDataDAO>accountDatas;
    private long serverId;
    private String wappServer;
    private String serverUrl;
    private String serverType;
    private long uDate;
    private long cDate;
    private int status;

    public WappAccountDBModel() {
    }

    public WappAccountDBModel(String id, String account, String instanceKey, String phoneNumber, List<AccountDataDAO> accountDatas, long serverId, String wappServer, String serverUrl, String serverType, long uDate, long cDate, int status) {
        this.id = id;
        this.account = account;
        this.instanceKey = instanceKey;
        this.phoneNumber = phoneNumber;
        this.accountDatas = accountDatas;
        this.serverId = serverId;
        this.wappServer = wappServer;
        this.serverUrl = serverUrl;
        this.serverType = serverType;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getInstanceKey() {
        return instanceKey;
    }

    public void setInstanceKey(String instanceKey) {
        this.instanceKey = instanceKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AccountDataDAO> getAccountDatas() {
        return accountDatas;
    }

    public void setAccountDatas(List<AccountDataDAO> accountDatas) {
        this.accountDatas = accountDatas;
    }

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
    }

    public String getWappServer() {
        return wappServer;
    }

    public void setWappServer(String wappServer) {
        this.wappServer = wappServer;
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
