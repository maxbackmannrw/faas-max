package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.TriggerTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "email_trigger_temp_table")
public class EmailTriggerTempDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private String accountId;
    private String account;
    private String emailSubject;
    private String emailTitle;
    private String emailBody;
    private String emailSender;
    private List<TriggerTempDataDAO> datas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public EmailTriggerTempDBModel() {
    }

    public EmailTriggerTempDBModel(String account, String accountId, long cDate, List<TriggerTempDataDAO> datas, String emailBody, String emailSender, String emailSubject, String emailTitle, String id, String processId, int status, String trigger, String triggerType, long typeId, long uDate) {
        this.account = account;
        this.accountId = accountId;
        this.cDate = cDate;
        this.datas = datas;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.emailSubject = emailSubject;
        this.emailTitle = emailTitle;
        this.id = id;
        this.processId = processId;
        this.status = status;
        this.trigger = trigger;
        this.triggerType = triggerType;
        this.typeId = typeId;
        this.uDate = uDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public List<TriggerTempDataDAO> getDatas() {
        return datas;
    }

    public void setDatas(List<TriggerTempDataDAO> datas) {
        this.datas = datas;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }
}
