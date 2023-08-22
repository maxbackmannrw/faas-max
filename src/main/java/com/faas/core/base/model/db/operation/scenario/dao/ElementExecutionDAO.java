package com.faas.core.base.model.db.operation.scenario.dao;


import com.faas.core.base.model.db.scenario.content.dao.ActionDAO;
import com.faas.core.base.model.db.scenario.content.dao.AutomationDAO;

import java.util.List;

public class ElementExecutionDAO {

    private String id;
    private String elementId;
    private String element;
    private String elementType;
    private ActionDAO action;
    private AutomationDAO automation;
    private List<ExecutionValue>executionValues;
    private long uDate;
    private long cDate;
    private int status;

    public ElementExecutionDAO() {
    }

    public ElementExecutionDAO(String id, String elementId, String element, String elementType, ActionDAO action, AutomationDAO automation, List<ExecutionValue> executionValues, long uDate, long cDate, int status) {
        this.id = id;
        this.elementId = elementId;
        this.element = element;
        this.elementType = elementType;
        this.action = action;
        this.automation = automation;
        this.executionValues = executionValues;
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

    public ActionDAO getAction() {
        return action;
    }

    public void setAction(ActionDAO action) {
        this.action = action;
    }

    public AutomationDAO getAutomation() {
        return automation;
    }

    public void setAutomation(AutomationDAO automation) {
        this.automation = automation;
    }

    public List<ExecutionValue> getExecutionValues() {
        return executionValues;
    }

    public void setExecutionValues(List<ExecutionValue> executionValues) {
        this.executionValues = executionValues;
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
