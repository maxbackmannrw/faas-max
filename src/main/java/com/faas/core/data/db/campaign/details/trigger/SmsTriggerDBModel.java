package com.faas.core.data.db.campaign.details.trigger;

import com.faas.core.data.db.campaign.details.trigger.dao.TriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sms_trigger_table")
public class SmsTriggerDBModel {

    @Id
    private String id;
    private String campaignId;
    private String trigger;
    private String accountId;
    private String account;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private List<TriggerDataDAO> triggerDatas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public SmsTriggerDBModel() {
    }

    public SmsTriggerDBModel(String id, String campaignId, String trigger, String accountId, String account, String smsTitle, String smsBody, String senderId, List<TriggerDataDAO> triggerDatas, long typeId, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.trigger = trigger;
        this.accountId = accountId;
        this.account = account;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
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

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
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
