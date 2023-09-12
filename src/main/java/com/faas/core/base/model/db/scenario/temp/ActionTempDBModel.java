package com.faas.core.base.model.db.scenario.temp;

import javax.persistence.*;

@Entity
@Table(name = "action_temps_table")
public class ActionTempDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "action_temp")
    private String actionTemp;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;


    public ActionTempDBModel() {
    }

    public ActionTempDBModel(long id, String actionTemp, long uDate, long cDate, int status) {
        this.id = id;
        this.actionTemp = actionTemp;
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

    public String getActionTemp() {
        return actionTemp;
    }

    public void setActionTemp(String actionTemp) {
        this.actionTemp = actionTemp;
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
