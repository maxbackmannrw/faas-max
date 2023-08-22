package com.faas.core.base.model.db.scenario.content.dao;

import java.util.List;

public class ScenarioElement {

    private String id;
    private String element;
    private String elementType;
    private ActionDAO action;
    private AutomationDAO automation;
    private List<ElementVariableDAO>variables;
    private int elementOrder;
    private long uDate;
    private long cDate;
    private int status;

    public ScenarioElement() {
    }

    public ScenarioElement(String id, String element, String elementType, AutomationDAO automation, ActionDAO action, List<ElementVariableDAO> variables, int elementOrder, long uDate, long cDate, int status) {
        this.id = id;
        this.element = element;
        this.elementType = elementType;
        this.automation = automation;
        this.action = action;
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

    public AutomationDAO getAutomation() {
        return automation;
    }

    public void setAutomation(AutomationDAO automation) {
        this.automation = automation;
    }

    public ActionDAO getAction() {
        return action;
    }

    public void setAction(ActionDAO action) {
        this.action = action;
    }

    public List<ElementVariableDAO> getVariables() {
        return variables;
    }

    public void setVariables(List<ElementVariableDAO> variables) {
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
