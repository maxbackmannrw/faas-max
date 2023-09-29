package com.faas.core.base.model.db.process.details.scenario.dao;


public class ScenarioAutomationDAO {

    private long tempId;
    private String automationTemp;
    private long automationTypeId;
    private String automationType;
    private String baseType;
    private long cDate;
    private int status;

    public ScenarioAutomationDAO() {
    }

    public ScenarioAutomationDAO(long tempId, String automationTemp, long automationTypeId, String automationType, String baseType, long cDate, int status) {
        this.tempId = tempId;
        this.automationTemp = automationTemp;
        this.automationTypeId = automationTypeId;
        this.automationType = automationType;
        this.baseType = baseType;
        this.cDate = cDate;
        this.status = status;
    }

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public String getAutomationTemp() {
        return automationTemp;
    }

    public void setAutomationTemp(String automationTemp) {
        this.automationTemp = automationTemp;
    }

    public long getAutomationTypeId() {
        return automationTypeId;
    }

    public void setAutomationTypeId(long automationTypeId) {
        this.automationTypeId = automationTypeId;
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
