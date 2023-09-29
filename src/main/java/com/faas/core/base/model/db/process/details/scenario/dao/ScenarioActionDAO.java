package com.faas.core.base.model.db.process.details.scenario.dao;


public class ScenarioActionDAO {

    private long tempId;
    private String actionTemp;
    private long cDate;
    private int status;

    public ScenarioActionDAO() {
    }

    public ScenarioActionDAO(long tempId, String actionTemp, long cDate, int status) {
        this.tempId = tempId;
        this.actionTemp = actionTemp;
        this.cDate = cDate;
        this.status = status;
    }

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public String getActionTemp() {
        return actionTemp;
    }

    public void setActionTemp(String actionTemp) {
        this.actionTemp = actionTemp;
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

