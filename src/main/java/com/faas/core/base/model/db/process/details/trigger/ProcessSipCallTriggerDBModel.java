package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.ProcessTriggerDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sip_call_trigger_table")
public class ProcessSipCallTriggerDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private String triggerDesc;
    private String accountId;
    private String account;
    private String callerId;
    private List<ProcessTriggerDataDAO> datas;
    private long typeId;
    private String triggerType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessSipCallTriggerDBModel() {
    }

    public ProcessSipCallTriggerDBModel(String id, String processId, String trigger, String triggerDesc, String accountId, String account, String callerId, List<ProcessTriggerDataDAO> datas, long typeId, String triggerType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.trigger = trigger;
        this.triggerDesc = triggerDesc;
        this.accountId = accountId;
        this.account = account;
        this.callerId = callerId;
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

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
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
