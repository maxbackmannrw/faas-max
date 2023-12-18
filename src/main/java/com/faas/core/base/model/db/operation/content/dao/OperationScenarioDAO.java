package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;


public class OperationScenarioDAO {

    private String id;
    private String scenarioId;
    private String scenario;
    private long scenarioTypeId;
    private String scenarioType;
    private List<ScenarioExecutionDAO>executions;
    private String scenarioState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationScenarioDAO() {
    }

    public OperationScenarioDAO(String id, String scenarioId, String scenario, long scenarioTypeId, String scenarioType, List<ScenarioExecutionDAO> executions, String scenarioState, long uDate, long cDate, int status) {
        this.id = id;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioTypeId = scenarioTypeId;
        this.scenarioType = scenarioType;
        this.executions = executions;
        this.scenarioState = scenarioState;
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

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public long getScenarioTypeId() {
        return scenarioTypeId;
    }

    public void setScenarioTypeId(long scenarioTypeId) {
        this.scenarioTypeId = scenarioTypeId;
    }

    public String getScenarioType() {
        return scenarioType;
    }

    public void setScenarioType(String scenarioType) {
        this.scenarioType = scenarioType;
    }

    public List<ScenarioExecutionDAO> getExecutions() {
        return executions;
    }

    public void setExecutions(List<ScenarioExecutionDAO> executions) {
        this.executions = executions;
    }

    public String getScenarioState() {
        return scenarioState;
    }

    public void setScenarioState(String scenarioState) {
        this.scenarioState = scenarioState;
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
