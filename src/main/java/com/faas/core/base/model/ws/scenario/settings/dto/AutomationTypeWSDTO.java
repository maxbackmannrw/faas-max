package com.faas.core.base.model.ws.scenario.settings.dto;

import com.faas.core.base.model.db.scenario.settings.AutomationTypeDBModel;

public class AutomationTypeWSDTO {

    private AutomationTypeDBModel automationType;

    public AutomationTypeWSDTO() {
    }

    public AutomationTypeWSDTO(AutomationTypeDBModel automationType) {
        this.automationType = automationType;
    }

    public AutomationTypeDBModel getAutomationType() {
        return automationType;
    }

    public void setAutomationType(AutomationTypeDBModel automationType) {
        this.automationType = automationType;
    }
}
