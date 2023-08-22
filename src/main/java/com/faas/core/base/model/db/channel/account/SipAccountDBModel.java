package com.faas.core.base.model.db.channel.account;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Document(collection = "sip_account_table")
public class SipAccountDBModel {

    @Id
    private String id;
    private String account;
    private String userName;
    private String authUser;
    private String password;
    private String sipUrl;
    private List<AccountDataDAO>accountDatas;
    private String provider;
    private long uDate;
    private long cDate;
    private int status;


    public SipAccountDBModel() {
    }

    public SipAccountDBModel(String id, String account, String userName, String authUser, String password, String sipUrl, List<AccountDataDAO> accountDatas, String provider, long uDate, long cDate, int status) {
        this.id = id;
        this.account = account;
        this.userName = userName;
        this.authUser = authUser;
        this.password = password;
        this.sipUrl = sipUrl;
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

    public String getAuthUser() {
        return authUser;
    }

    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSipUrl() {
        return sipUrl;
    }

    public void setSipUrl(String sipUrl) {
        this.sipUrl = sipUrl;
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
