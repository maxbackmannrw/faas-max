package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.TriggerTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "wapp_message_trigger_temp_table")
public class WappMessageTriggerTempDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private String accountId;
    private String account;
    private String wappTitle;
    private String wappBody;
    private List<TriggerTempDataDAO> datas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public WappMessageTriggerTempDBModel() {
    }

    public WappMessageTriggerTempDBModel(String account, String accountId, long cDate, List<TriggerTempDataDAO> datas, String id, String processId, int status, String trigger, String triggerType, long typeId, long uDate, String wappBody, String wappTitle) {
        this.account = account;
        this.accountId = accountId;
        this.cDate = cDate;
        this.datas = datas;
        this.id = id;
        this.processId = processId;
        this.status = status;
        this.trigger = trigger;
        this.triggerType = triggerType;
        this.typeId = typeId;
        this.uDate = uDate;
        this.wappBody = wappBody;
        this.wappTitle = wappTitle;
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

    public String getWappBody() {
        return wappBody;
    }

    public void setWappBody(String wappBody) {
        this.wappBody = wappBody;
    }

    public String getWappTitle() {
        return wappTitle;
    }

    public void setWappTitle(String wappTitle) {
        this.wappTitle = wappTitle;
    }
}
