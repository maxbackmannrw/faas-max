package com.faas.core.base.model.db.process.details.scenario.dao;

import java.util.List;

public class ProcessScenarioElement {

    private String id;
    private String element;
    private String elementType;
    private ScenarioActionDAO action;
    private ScenarioAutomationDAO automation;
    private List<ScenarioElementVariableDAO>variables;
    private int elementOrder;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessScenarioElement() {
    }

    public ProcessScenarioElement(String id, String element, String elementType, ScenarioActionDAO action, ScenarioAutomationDAO automation, List<ScenarioElementVariableDAO> variables, int elementOrder, long uDate, long cDate, int status) {
        this.id = id;
        this.element = element;
        this.elementType = elementType;
        this.action = action;
        this.automation = automation;
        this.variables = variables;
        this.elementOrder = elementOrder;
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

    public ScenarioActionDAO getAction() {
        return action;
    }

    public void setAction(ScenarioActionDAO action) {
        this.action = action;
    }

    public ScenarioAutomationDAO getAutomation() {
        return automation;
    }

    public void setAutomation(ScenarioAutomationDAO automation) {
        this.automation = automation;
    }

    public List<ScenarioElementVariableDAO> getVariables() {
        return variables;
    }

    public void setVariables(List<ScenarioElementVariableDAO> variables) {
        this.variables = variables;
    }

    public int getElementOrder() {
        return elementOrder;
    }

    public void setElementOrder(int elementOrder) {
        this.elementOrder = elementOrder;
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
