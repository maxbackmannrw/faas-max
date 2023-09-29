package com.faas.core.base.model.db.operation.scenario.dao;

public class ScenarioExecutionValue {

    private String valueId;
    private String valueType;
    private String value;
    private long cDate;
    private int status;

    public ScenarioExecutionValue() {
    }

    public ScenarioExecutionValue(String valueId, String valueType, String value, long cDate, int status) {
        this.valueId = valueId;
        this.valueType = valueType;
        this.value = value;
        this.cDate = cDate;
        this.status = status;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
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
