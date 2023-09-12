package com.faas.core.base.model.ws.scenario.temp.automation;

import com.faas.core.base.model.ws.scenario.temp.automation.dto.AutomationTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class AutomationTempWSModel {

    private GeneralWSModel general;
    private List<AutomationTempWSDTO>automationTemps;

    public AutomationTempWSModel() {
    }

    public AutomationTempWSModel(GeneralWSModel general, List<AutomationTempWSDTO> automationTemps) {
        this.general = general;
        this.automationTemps = automationTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomationTempWSDTO> getAutomationTemps() {
        return automationTemps;
    }

    public void setAutomationTemps(List<AutomationTempWSDTO> automationTemps) {
        this.automationTemps = automationTemps;
    }
}
