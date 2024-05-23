package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.TriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sms_trigger_table")
public class SmsTriggerDBModel {

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
    private long typeId;
    private List<TriggerDataDAO> datas;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public SmsTriggerDBModel() {
    }

    public SmsTriggerDBModel(String account, String accountId, long cDate, List<TriggerDataDAO> datas, String id, String processId, String senderId, String smsBody, String smsTitle, int status, String trigger, String triggerDesc, String triggerType, long typeId, long uDate) {
        this.account = account;
        this.accountId = accountId;
        this.cDate = cDate;
        this.datas = datas;
        this.id = id;
        this.processId = processId;
        this.senderId = senderId;
        this.smsBody = smsBody;
        this.smsTitle = smsTitle;
        this.status = status;
        this.trigger = trigger;
        this.triggerDesc = triggerDesc;
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

    public List<TriggerDataDAO> getDatas() {
        return datas;
    }

    public void setDatas(List<TriggerDataDAO> datas) {
        this.datas = datas;
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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
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

    public String getTriggerDesc() {
        return triggerDesc;
    }

    public void setTriggerDesc(String triggerDesc) {
        this.triggerDesc = triggerDesc;
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
