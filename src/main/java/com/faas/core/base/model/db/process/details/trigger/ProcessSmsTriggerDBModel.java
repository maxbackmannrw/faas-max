package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.ProcessTriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_sms_trigger_table")
public class ProcessSmsTriggerDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private String triggerDesc;
    private String accountId;
    private String account;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private List<ProcessTriggerDataDAO> datas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessSmsTriggerDBModel() {
    }

    public ProcessSmsTriggerDBModel(String id, String processId, String trigger, String triggerDesc, String accountId, String account, String smsTitle, String smsBody, String senderId, List<ProcessTriggerDataDAO> datas, long typeId, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.trigger = trigger;
        this.triggerDesc = triggerDesc;
        this.accountId = accountId;
        this.account = account;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
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
