package com.faas.core.base.model.ws.automation.content.dto;

import com.faas.core.base.model.db.automation.content.AutomationTempDBModel;

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
