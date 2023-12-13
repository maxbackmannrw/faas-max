package com.faas.core.base.model.db.automation;

import javax.persistence.*;

@Entity
@Table(name = "automation_table")
public class AutomationDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "automation")
    private String automation;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "automation_type")
    private String automationType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public AutomationDBModel() {
    }

    public AutomationDBModel(long id, String automation, long typeId, String automationType, long uDate, long cDate, int status) {
        this.id = id;
        this.automation = automation;
        this.typeId = typeId;
        this.automationType = automationType;
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

    public String getAutomation() {
        return automation;
    }

    public void setAutomation(String automation) {
        this.automation = automation;
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
