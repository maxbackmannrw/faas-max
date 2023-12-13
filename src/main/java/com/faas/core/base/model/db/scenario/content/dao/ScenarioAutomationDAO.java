package com.faas.core.base.model.db.scenario.content.dao;

import java.util.List;

public class ScenarioAutomationDAO {

    private long automationId;
    private String automation;
    private String automationType;
    private List<ScenarioDataDAO> automationDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioAutomationDAO() {
    }

    public ScenarioAutomationDAO(long automationId, String automation, String automationType, List<ScenarioDataDAO> automationDatas, long uDate, long cDate, int status) {
        this.automationId = automationId;
        this.automation = automation;
        this.automationType = automationType;
        this.automationDatas = automationDatas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getAutomationId() {
        return automationId;
    }

    public void setAutomationId(long automationId) {
        this.automationId = automationId;
    }

    public String getAutomation() {
        return automation;
    }

    public void setAutomation(String automation) {
        this.automation = automation;
    }

    public String getAutomationType() {
        return automationType;
    }

    public void setAutomationType(String automationType) {
        this.automationType = automationType;
    }

    public List<ScenarioDataDAO> getAutomationDatas() {
        return automationDatas;
    }

    public void setAutomationDatas(List<ScenarioDataDAO> automationDatas) {
        this.automationDatas = automationDatas;
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
