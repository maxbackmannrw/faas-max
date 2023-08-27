package com.faas.core.base.model.db.process.details.trigger;

import com.faas.core.base.model.db.process.details.trigger.dao.TriggerDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trigger_table")
public class TriggerDBModel {

    @Id
    private String id;
    private String processId;
    private String trigger;
    private TriggerDetails triggerDetails;
    private long typeId;
    private String type;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public TriggerDBModel() {
    }

    public TriggerDBModel(String id, String processId, String trigger, TriggerDetails triggerDetails, long typeId, String type, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.trigger = trigger;
        this.triggerDetails = triggerDetails;
        this.typeId = typeId;
        this.type = type;
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

    public TriggerDetails getTriggerDetails() {
        return triggerDetails;
    }

    public void setTriggerDetails(TriggerDetails triggerDetails) {
        this.triggerDetails = triggerDetails;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
