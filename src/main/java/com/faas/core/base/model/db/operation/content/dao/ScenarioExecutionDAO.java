package com.faas.core.base.model.db.operation.content.dao;


import java.util.List;

public class ScenarioExecutionDAO {

    private String id;
    private String elementId;
    private String element;
    private String elementType;
    private ScenarioActionExecutionDAO actionExecution;
    private ScenarioAutomationExecutionDAO automationExecution;
    private List<ScenarioExecutionDataDAO> executionDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioExecutionDAO() {
    }

    public ScenarioExecutionDAO(String id, String elementId, String element, String elementType, ScenarioActionExecutionDAO actionExecution, ScenarioAutomationExecutionDAO automationExecution, List<ScenarioExecutionDataDAO> executionDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.elementId = elementId;
        this.element = element;
        this.elementType = elementType;
        this.actionExecution = actionExecution;
        this.automationExecution = automationExecution;
        this.executionDatas = executionDatas;
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

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public ScenarioActionExecutionDAO getActionExecution() {
        return actionExecution;
    }

    public void setActionExecution(ScenarioActionExecutionDAO actionExecution) {
        this.actionExecution = actionExecution;
    }

    public ScenarioAutomationExecutionDAO getAutomationExecution() {
        return automationExecution;
    }

    public void setAutomationExecution(ScenarioAutomationExecutionDAO automationExecution) {
        this.automationExecution = automationExecution;
    }

    public List<ScenarioExecutionDataDAO> getExecutionDatas() {
        return executionDatas;
    }

    public void setExecutionDatas(List<ScenarioExecutionDataDAO> executionDatas) {
        this.executionDatas = executionDatas;
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
