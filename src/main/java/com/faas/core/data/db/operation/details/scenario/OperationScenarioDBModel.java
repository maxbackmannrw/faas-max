package com.faas.core.data.db.operation.details.scenario;

import com.faas.core.data.db.operation.details.scenario.dao.OperationScenarioDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "operation_scenario_table")
public class OperationScenarioDBModel {

    @Id
    private String id;
    private String operationId;
    private long clientId;
    private long agentId;
    private String campaignId;
    private String scenarioId;
    private String scenario;
    private String scenarioDesc;
    private long scenarioTypeId;
    private String scenarioType;
    private String baseType;
    private List<OperationScenarioDataDAO> scenarioDatas;
    private List<OperationScenarioDataDAO> runResults;
    private String runState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationScenarioDBModel() {
    }

    public OperationScenarioDBModel(String id, String operationId, long clientId, long agentId, String campaignId, String scenarioId, String scenario, String scenarioDesc, long scenarioTypeId, String scenarioType, String baseType, List<OperationScenarioDataDAO> scenarioDatas, List<OperationScenarioDataDAO> runResults, String runState, long uDate, long cDate, int status) {
        this.id = id;
        this.operationId = operationId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioDesc = scenarioDesc;
        this.scenarioTypeId = scenarioTypeId;
        this.scenarioType = scenarioType;
        this.baseType = baseType;
        this.scenarioDatas = scenarioDatas;
        this.runResults = runResults;
        this.runState = runState;
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

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
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

    public List<OperationScenarioDataDAO> getRunResults() {
        return runResults;
    }

    public void setRunResults(List<OperationScenarioDataDAO> runResults) {
        this.runResults = runResults;
    }

    public String getRunState() {
        return runState;
    }

    public void setRunState(String runState) {
        this.runState = runState;
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
