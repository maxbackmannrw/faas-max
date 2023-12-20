package com.faas.core.base.model.db.process.details.scenario;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;
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
    private List<ScenarioDataDAO> scenarioDatas;
    private List<ScenarioElement> scenarioElements;
    private long typeId;
    private String scenarioType;
    private int order;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessScenarioDBModel() {
    }

    public ProcessScenarioDBModel(String id, String processId, String scenarioId, String scenario, List<ScenarioDataDAO> scenarioDatas, List<ScenarioElement> scenarioElements, long typeId, String scenarioType, int order, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioDatas = scenarioDatas;
        this.scenarioElements = scenarioElements;
        this.typeId = typeId;
        this.scenarioType = scenarioType;
        this.order = order;
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

    public List<ScenarioDataDAO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ScenarioDataDAO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
    }

    public List<ScenarioElement> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ScenarioElement> scenarioElements) {
        this.scenarioElements = scenarioElements;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
