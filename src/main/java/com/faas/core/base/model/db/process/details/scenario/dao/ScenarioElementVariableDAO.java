package com.faas.core.base.model.db.process.details.scenario.dao;

public class ScenarioElementVariableDAO {

    private String variableId;
    private String variableType;
    private String value;
    private long cDate;
    private int status;

    public ScenarioElementVariableDAO() {
    }

    public ScenarioElementVariableDAO(String variableId, String variableType, String value, long cDate, int status) {
        this.variableId = variableId;
        this.variableType = variableType;
        this.value = value;
        this.cDate = cDate;
        this.status = status;
    }

    public String getVariableId() {
        return variableId;
    }

    public void setVariableId(String variableId) {
        this.variableId = variableId;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
