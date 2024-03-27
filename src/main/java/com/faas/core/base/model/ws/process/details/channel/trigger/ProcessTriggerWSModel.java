package com.faas.core.base.model.ws.process.details.channel.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.ProcessTriggerWSDTO;

public class ProcessTriggerWSModel {

    private GeneralWSModel general;
    private ProcessTriggerWSDTO processTrigger;

    public ProcessTriggerWSModel() {
    }

    public ProcessTriggerWSModel(GeneralWSModel general, ProcessTriggerWSDTO processTrigger) {
        this.general = general;
        this.processTrigger = processTrigger;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessTriggerWSDTO getProcessTrigger() {
        return processTrigger;
    }

    public void setProcessTrigger(ProcessTriggerWSDTO processTrigger) {
        this.processTrigger = processTrigger;
    }
}
