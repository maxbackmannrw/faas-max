package com.faas.core.base.model.db.process.details.scenario;

import com.faas.core.base.model.db.process.details.scenario.dao.ProcessScenarioDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "process_scenario_table")
public class ProcessScenarioDBModel {

    @Id
    private String id;
    private String processId;
    private String scenarioId;
    private List<ProcessScenarioDataDAO> scenarioDatas;
    private int order;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessScenarioDBModel() {
    }

    public ProcessScenarioDBModel(String id, String processId, String scenarioId, List<ProcessScenarioDataDAO> scenarioDatas, int order, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.scenarioId = scenarioId;
        this.scenarioDatas = scenarioDatas;
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

    public List<ProcessScenarioDataDAO> getScenarioDatas() {
        return scenarioDatas;
    }

    public void setScenarioDatas(List<ProcessScenarioDataDAO> scenarioDatas) {
        this.scenarioDatas = scenarioDatas;
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
