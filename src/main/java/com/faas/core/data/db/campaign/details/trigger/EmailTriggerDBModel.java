package com.faas.core.data.db.campaign.details.trigger;

import com.faas.core.data.db.campaign.details.trigger.dao.TriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "email_trigger_table")
public class EmailTriggerDBModel {

    @Id
    private String id;
    private String campaignId;
    private String trigger;
    private String accountId;
    private String account;
    private String emailSubject;
    private String emailTitle;
    private String emailBody;
    private String emailSender;
    private List<TriggerDataDAO> triggerDatas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public EmailTriggerDBModel() {
    }

    public EmailTriggerDBModel(String id, String campaignId, String trigger, String accountId, String account, String emailSubject, String emailTitle, String emailBody, String emailSender, List<TriggerDataDAO> triggerDatas, long typeId, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.trigger = trigger;
        this.accountId = accountId;
        this.account = account;
        this.emailSubject = emailSubject;
        this.emailTitle = emailTitle;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
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

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
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
