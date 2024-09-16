package com.faas.core.data.db.channel.account;

import com.faas.core.data.db.channel.account.dao.AccountDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "email_account_table")
public class EmailAccountDBModel {

    @Id
    private String id;
    private String account;
    private List<AccountDataDAO> accountDatas;
    private String provider;
    private long uDate;
    private long cDate;
    private int status;

    public EmailAccountDBModel() {
    }

    public EmailAccountDBModel(String id, String account, List<AccountDataDAO> accountDatas, String provider, long uDate, long cDate, int status) {
        this.id = id;
        this.account = account;
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
