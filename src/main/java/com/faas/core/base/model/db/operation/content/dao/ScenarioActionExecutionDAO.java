package com.faas.core.base.model.db.operation.content.dao;

import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;

import java.util.List;

public class ScenarioActionExecutionDAO {

    private long actionId;
    private String action;
    private List<ScenarioDataDAO> actionDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioActionExecutionDAO() {
    }

    public ScenarioActionExecutionDAO(long actionId, String action, List<ScenarioDataDAO> actionDatas, long uDate, long cDate, int status) {
        this.actionId = actionId;
        this.action = action;
        this.actionDatas = actionDatas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<ScenarioDataDAO> getActionDatas() {
        return actionDatas;
    }

    public void setActionDatas(List<ScenarioDataDAO> actionDatas) {
        this.actionDatas = actionDatas;
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

