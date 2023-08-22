package com.faas.core.base.model.db.channel.account;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "wapp_account_table")
public class WappAccountDBModel {

    @Id
    private String id;
    private String account;
    private String instanceKey;
    private String phoneNumber;
    private String serverUrl;
    private List<AccountDataDAO>accountDatas;
    private long uDate;
    private long cDate;
    private int status;

    public WappAccountDBModel() {
    }

    public WappAccountDBModel(String id, String account, String instanceKey, String phoneNumber, String serverUrl, List<AccountDataDAO> accountDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.account = account;
        this.instanceKey = instanceKey;
        this.phoneNumber = phoneNumber;
        this.serverUrl = serverUrl;
        this.accountDatas = accountDatas;
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

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public List<AccountDataDAO> getAccountDatas() {
        return accountDatas;
    }

    public void setAccountDatas(List<AccountDataDAO> accountDatas) {
        this.accountDatas = accountDatas;
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
