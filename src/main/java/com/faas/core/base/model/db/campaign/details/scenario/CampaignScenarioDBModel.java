package com.faas.core.base.model.db.campaign.details.scenario;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "campaign_scenario_table")
public class CampaignScenarioDBModel {

    @Id
    private String id;
    private String campaignId;
    private String scenarioId;
    private String scenario;
    private String scenarioDesc;
    private List<ScenarioDataDAO> scenarioDatas;
    private long typeId;
    private String scenarioType;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignScenarioDBModel() {
    }

    public CampaignScenarioDBModel(String id, String campaignId, String scenarioId, String scenario, String scenarioDesc, List<ScenarioDataDAO> scenarioDatas, long typeId, String scenarioType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.scenarioId = scenarioId;
        this.scenario = scenario;
        this.scenarioDesc = scenarioDesc;
        this.scenarioDatas = scenarioDatas;
        this.typeId = typeId;
        this.scenarioType = scenarioType;
        this.baseType = baseType;
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

    public List<ScenarioDataDAO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ScenarioDataDAO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
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
