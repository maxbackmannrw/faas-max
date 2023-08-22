package com.faas.core.base.model.db.automation.content;

import javax.persistence.*;

@Entity
@Table(name = "automation_temps_table")
public class AutomationTempDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "automation_temp")
    private String automationTemp;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "automation_type")
    private String automationType;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public AutomationTempDBModel() {
    }

    public AutomationTempDBModel(long id, String automationTemp, long typeId, String automationType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.automationTemp = automationTemp;
        this.typeId = typeId;
        this.automationType = automationType;
        this.baseType = baseType;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutomationTemp() {
        return automationTemp;
    }

    public void setAutomationTemp(String automationTemp) {
        this.automationTemp = automationTemp;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getAutomationType() {
        return automationType;
    }

    public void setAutomationType(String automationType) {
        this.automationType = automationType;
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
