package com.faas.core.base.model.db.campaign.details.channel.dao;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;
import java.util.List;

public class CampaignEmailChannelDAO {

    private String id;
    private String accountId;
    private String account;
    private List<AccountDataDAO> accountDatas;
    private String provider;
    private String state;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignEmailChannelDAO() {
    }

    public CampaignEmailChannelDAO(String id, String accountId, String account, List<AccountDataDAO> accountDatas, String provider, String state, long uDate, long cDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.account = account;
        this.accountDatas = accountDatas;
        this.provider = provider;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
