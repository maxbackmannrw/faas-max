package com.faas.core.base.model.db.channel.account;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "sms_account_table")
public class SmsAccountDBModel {

    @Id
    private String id;
    private String account;
    private String userName;
    private String password;
    private String apiToken;
    private String apiUrl;
    private List<AccountDataDAO>accountDatas;
    private String provider;
    private long uDate;
    private long cDate;
    private int status;

    public SmsAccountDBModel() {
    }

    public SmsAccountDBModel(String id, String account, String userName, String password, String apiToken, String apiUrl, List<AccountDataDAO> accountDatas, String provider, long uDate, long cDate, int status) {
        this.id = id;
        this.account = account;
        this.userName = userName;
        this.password = password;
        this.apiToken = apiToken;
        this.apiUrl = apiUrl;
        this.accountDatas = accountDatas;
        this.provider = provider;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public List<AccountDataDAO> getAccountDatas() {
        return accountDatas;
    }

    public void setAccountDatas(List<AccountDataDAO> accountDatas) {
        this.accountDatas = accountDatas;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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
