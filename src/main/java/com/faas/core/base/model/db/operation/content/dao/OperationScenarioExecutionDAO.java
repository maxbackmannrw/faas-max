package com.faas.core.base.model.db.operation.content.dao;


import com.faas.core.base.model.db.scenario.content.dao.ScenarioActionDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioAutomationDAO;

import java.util.List;

public class OperationScenarioExecutionDAO {

    private String id;
    private String elementId;
    private String element;
    private String elementType;
    private ScenarioActionDAO action;
    private ScenarioAutomationDAO automation;
    private List<ScenarioExecutionValue> executionValues;
    private long uDate;
    private long cDate;
    private int status;

    public OperationScenarioExecutionDAO() {
    }

    public OperationScenarioExecutionDAO(String id, String elementId, String element, String elementType, ScenarioActionDAO action, ScenarioAutomationDAO automation, List<ScenarioExecutionValue> executionValues, long uDate, long cDate, int status) {
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

    public List<ScenarioExecutionValue> getExecutionValues() {
        return executionValues;
    }

    public void setExecutionValues(List<ScenarioExecutionValue> executionValues) {
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
