package com.faas.core.data.db.scenario.content;

import com.faas.core.data.db.scenario.content.dao.ScenarioDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "scenario_table")
public class ScenarioDBModel {

    @Id
    private String id;
    private String scenario;
    private String scenarioDesc;
    private long typeId;
    private String scenarioType;
    private String baseType;
    private List<ScenarioDataDAO> scenarioDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioDBModel() {
    }

    public ScenarioDBModel(String id, String scenario, String scenarioDesc, long typeId, String scenarioType, String baseType, List<ScenarioDataDAO> scenarioDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.scenario = scenario;
        this.scenarioDesc = scenarioDesc;
        this.typeId = typeId;
        this.scenarioType = scenarioType;
        this.baseType = baseType;
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
