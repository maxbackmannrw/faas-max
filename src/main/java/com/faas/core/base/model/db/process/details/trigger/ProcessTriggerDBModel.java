package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.ProcessTriggerDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "process_trigger_table")
public class ProcessTriggerDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private ProcessTriggerDetails triggerDetails;
    private long triggerTypeId;
    private String triggerType;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessTriggerDBModel() {
    }

    public ProcessTriggerDBModel(String id, String processId, String trigger, ProcessTriggerDetails triggerDetails, long triggerTypeId, String triggerType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.trigger = trigger;
        this.triggerDetails = triggerDetails;
        this.triggerTypeId = triggerTypeId;
        this.triggerType = triggerType;
        this.baseType = baseType;
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

    public ProcessTriggerDetails getTriggerDetails() {
        return triggerDetails;
    }

    public void setTriggerDetails(ProcessTriggerDetails triggerDetails) {
        this.triggerDetails = triggerDetails;
    }

    public long getTriggerTypeId() {
        return triggerTypeId;
    }

    public void setTriggerTypeId(long triggerTypeId) {
        this.triggerTypeId = triggerTypeId;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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
