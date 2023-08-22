package com.faas.core.base.model.db.campaign.settings;

import javax.persistence.*;

@Entity
@Table(name = "flow_type_table")
public class FlowTypeDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "flow_type")
    private String flowType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public FlowTypeDBModel() {
    }

    public FlowTypeDBModel(long id, String flowType, long uDate, long cDate, int status) {
        this.id = id;
        this.flowType = flowType;
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

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
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
