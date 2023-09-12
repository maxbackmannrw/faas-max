package com.faas.core.base.model.ws.scenario.settings;

import com.faas.core.base.model.ws.scenario.settings.dto.AutomationTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class AutomationTypeWSModel {

    private GeneralWSModel general;
    private List<AutomationTypeWSDTO>automationTypes;

    public AutomationTypeWSModel() {
    }

    public AutomationTypeWSModel(GeneralWSModel general, List<AutomationTypeWSDTO> automationTypes) {
        this.general = general;
        this.automationTypes = automationTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationTypeWSDTO> getAutomationTypes() {
        return automationTypes;
    }

    public void setAutomationTypes(List<AutomationTypeWSDTO> automationTypes) {
        this.automationTypes = automationTypes;
    }
}
