package com.faas.core.base.model.db.scenario.content.dao;

public class ScenarioElement {

    private String id;
    private String element;
    private String elementType;
    private ScenarioActionDAO scenarioAction;
    private ScenarioAutomationDAO scenarioAutomation;
    private int order;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioElement() {
    }

    public ScenarioElement(String id, String element, String elementType, ScenarioActionDAO scenarioAction, ScenarioAutomationDAO scenarioAutomation, int order, long uDate, long cDate, int status) {
        this.id = id;
        this.element = element;
        this.elementType = elementType;
        this.scenarioAction = scenarioAction;
        this.scenarioAutomation = scenarioAutomation;
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

    public ScenarioActionDAO getScenarioAction() {
        return scenarioAction;
    }

    public void setScenarioAction(ScenarioActionDAO scenarioAction) {
        this.scenarioAction = scenarioAction;
    }

    public ScenarioAutomationDAO getScenarioAutomation() {
        return scenarioAutomation;
    }

    public void setScenarioAutomation(ScenarioAutomationDAO scenarioAutomation) {
        this.scenarioAutomation = scenarioAutomation;
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
