package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;


public class OperationScenarioDAO {

    private String id;
    private String scenarioId;
    private String scenario;
    private String scenarioDesc;
    private long typeId;
    private String scenarioType;
    private String baseType;
    private List<OperationScenarioDataDAO>scenarioDatas;
    private List<OperationScenarioDataDAO>scenarioResults;
    private String scenarioState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationScenarioDAO() {
    }

    public OperationScenarioDAO(String id, String scenarioId, String scenario, String scenarioDesc, long typeId, String scenarioType, String baseType, List<OperationScenarioDataDAO> scenarioDatas, List<OperationScenarioDataDAO> scenarioResults, String scenarioState, long uDate, long cDate, int status) {
        this.id = id;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioDesc = scenarioDesc;
        this.typeId = typeId;
        this.scenarioType = scenarioType;
        this.baseType = baseType;
        this.scenarioDatas = scenarioDatas;
        this.scenarioResults = scenarioResults;
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

    public String getScenarioDesc() {
        return scenarioDesc;
    }

    public void setScenarioDesc(String scenarioDesc) {
        this.scenarioDesc = scenarioDesc;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getScenarioType() {
        return scenarioType;
    }

    public void setScenarioType(String scenarioType) {
        this.scenarioType = scenarioType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<OperationScenarioDataDAO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<OperationScenarioDataDAO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
    }

    public List<OperationScenarioDataDAO> getScenarioResults() {
        return scenarioResults;
    }

    public void setScenarioResults(List<OperationScenarioDataDAO> scenarioResults) {
        this.scenarioResults = scenarioResults;
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
