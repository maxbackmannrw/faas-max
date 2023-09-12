package com.faas.core.base.model.ws.scenario.temp.automation.dto;

import com.faas.core.base.model.db.scenario.temp.AutomationTempDBModel;

public class AutomationTempWSDTO {

    private AutomationTempDBModel automationTemp;

    public AutomationTempWSDTO() {
    }

    public AutomationTempWSDTO(AutomationTempDBModel automationTemp) {
        this.automationTemp = automationTemp;
    }

    public AutomationTempDBModel getAutomationTemp() {
        return automationTemp;
    }

    public void setAutomationTemp(AutomationTempDBModel automationTemp) {
        this.automationTemp = automationTemp;
    }
}
