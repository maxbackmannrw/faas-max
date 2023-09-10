package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;

import java.util.List;

public class ProcessTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessTriggerWSDTO>processTriggers;

    public ProcessTriggerWSModel() {
    }

    public ProcessTriggerWSModel(GeneralWSModel general, List<ProcessTriggerWSDTO> processTriggers) {
        this.general = general;
        this.processTriggers = processTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessTriggerWSDTO> getProcessTriggers() {
        return processTriggers;
    }

    public void setProcessTriggers(List<ProcessTriggerWSDTO> processTriggers) {
        this.processTriggers = processTriggers;
    }
}
