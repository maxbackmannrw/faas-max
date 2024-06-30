package com.faas.core.base.model.db.campaign.details.trigger;

import com.faas.core.base.model.db.campaign.details.trigger.dao.TriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "wapp_message_trigger_table")
public class WappMessageTriggerDBModel {

    @Id
    private String id;
    private String campaignId;
    private String trigger;
    private String accountId;
    private String account;
    private String wappTitle;
    private String wappBody;
    private List<TriggerDataDAO> triggerDatas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public WappMessageTriggerDBModel() {
    }

    public WappMessageTriggerDBModel(String id, String campaignId, String trigger, String accountId, String account, String wappTitle, String wappBody, List<TriggerDataDAO> triggerDatas, long typeId, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.trigger = trigger;
        this.accountId = accountId;
        this.account = account;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
        this.triggerDatas = triggerDatas;
        this.typeId = typeId;
        this.triggerType = triggerType;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
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

    public String getWappTitle() {
        return wappTitle;
    }

    public void setWappTitle(String wappTitle) {
        this.wappTitle = wappTitle;
    }

    public String getWappBody() {
        return wappBody;
    }

    public void setWappBody(String wappBody) {
        this.wappBody = wappBody;
    }

    public List<TriggerDataDAO> getTriggerDatas() {
        return triggerDatas;
    }

    public void setTriggerDatas(List<TriggerDataDAO> triggerDatas) {
        this.triggerDatas = triggerDatas;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
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
