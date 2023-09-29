package com.faas.core.base.model.db.process.details.scenario;

import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioDataDAO;
import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioElement;
import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioVariableDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioVariableDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "process_scenario_table")
public class ProcessScenarioDBModel {

    @Id
    private String id;
    private String processId;
    private String scenarioId;
    private String scenario;
    private long scenarioTypeId;
    private String scenarioType;
    private String baseType;
    private List<ProcessScenarioVariableDAO> scenarioVariables;
    private List<ProcessScenarioElement> scenarioElements;
    private List<ProcessScenarioDataDAO> scenarioDatas;
    private int scenarioOrder;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessScenarioDBModel() {
    }

    public ProcessScenarioDBModel(String id, String processId, String scenarioId, String scenario, long scenarioTypeId, String scenarioType, String baseType, List<ProcessScenarioVariableDAO> scenarioVariables, List<ProcessScenarioElement> scenarioElements, List<ProcessScenarioDataDAO> scenarioDatas, int scenarioOrder, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioTypeId = scenarioTypeId;
        this.scenarioType = scenarioType;
        this.baseType = baseType;
        this.scenarioVariables = scenarioVariables;
        this.scenarioElements = scenarioElements;
        this.scenarioDatas = scenarioDatas;
        this.scenarioOrder = scenarioOrder;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<ProcessScenarioVariableDAO> getScenarioVariables() {
        return scenarioVariables;
    }

    public void setScenarioVariables(List<ProcessScenarioVariableDAO> scenarioVariables) {
        this.scenarioVariables = scenarioVariables;
    }

    public List<ProcessScenarioElement> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ProcessScenarioElement> scenarioElements) {
        this.scenarioElements = scenarioElements;
    }

    public List<ProcessScenarioDataDAO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ProcessScenarioDataDAO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
    }

    public int getScenarioOrder() {
        return scenarioOrder;
    }

    public void setScenarioOrder(int scenarioOrder) {
        this.scenarioOrder = scenarioOrder;
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
