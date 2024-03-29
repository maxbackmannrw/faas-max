package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.ProcessTriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_email_trigger_table")
public class ProcessEmailTriggerDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private String triggerDesc;
    private String accountId;
    private String account;
    private String emailSubject;
    private String emailTitle;
    private String emailBody;
    private String emailSender;
    private List<ProcessTriggerDataDAO> datas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessEmailTriggerDBModel() {
    }

    public ProcessEmailTriggerDBModel(String id, String processId, String trigger, String triggerDesc, String accountId, String account, String emailSubject, String emailTitle, String emailBody, String emailSender, List<ProcessTriggerDataDAO> datas, long typeId, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.trigger = trigger;
        this.triggerDesc = triggerDesc;
        this.accountId = accountId;
        this.account = account;
        this.emailSubject = emailSubject;
        this.emailTitle = emailTitle;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.datas = datas;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getTriggerDesc() {
        return triggerDesc;
    }

    public void setTriggerDesc(String triggerDesc) {
        this.triggerDesc = triggerDesc;
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

    public List<ProcessTriggerDataDAO> getDatas() {
        return datas;
    }

    public void setDatas(List<ProcessTriggerDataDAO> datas) {
        this.datas = datas;
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
