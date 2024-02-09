package com.faas.core.base.model.db.process.details.channel.content.dao;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;

import java.util.List;

public class ProcessPushAccountDAO {

    private String accountId;
    private String account;
    private List<AccountDataDAO>accountDatas;
    private String provider;
    private long cDate;
    private int status;

    public ProcessPushAccountDAO() {
    }

    public ProcessPushAccountDAO(String accountId, String account, List<AccountDataDAO> accountDatas, String provider, long cDate, int status) {
        this.accountId = accountId;
        this.account = account;
        this.accountDatas = accountDatas;
        this.provider = provider;
        this.cDate = cDate;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
