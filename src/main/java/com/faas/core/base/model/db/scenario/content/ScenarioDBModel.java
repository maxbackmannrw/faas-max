package com.faas.core.base.model.db.scenario.content;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "scenario_table")
public class ScenarioDBModel {

    @Id
    private String id;
    private String scenario;
    private long typeId;
    private String scenarioType;
    private List<ScenarioElement> scenarioElements;
    private List<ScenarioDataDAO> scenarioDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioDBModel() {
    }

    public ScenarioDBModel(String id, String scenario, long typeId, String scenarioType, List<ScenarioElement> scenarioElements, List<ScenarioDataDAO> scenarioDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.scenario = scenario;
        this.typeId = typeId;
        this.scenarioType = scenarioType;
        this.scenarioElements = scenarioElements;
        this.scenarioDatas = scenarioDatas;
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

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
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

    public List<ScenarioElement> getScenarioElements() {
        return scenarioElements;
    }

    public void setScenarioElements(List<ScenarioElement> scenarioElements) {
        this.scenarioElements = scenarioElements;
    }

    public List<ScenarioDataDAO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ScenarioDataDAO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
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
