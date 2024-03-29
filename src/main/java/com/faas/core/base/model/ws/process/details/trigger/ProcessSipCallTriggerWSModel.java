package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessSipCallTriggerWSDTO;

import java.util.List;

public class ProcessSipCallTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessSipCallTriggerWSDTO>processSipCallTriggers;

    public ProcessSipCallTriggerWSModel() {
    }

    public ProcessSipCallTriggerWSModel(GeneralWSModel general, List<ProcessSipCallTriggerWSDTO> processSipCallTriggers) {
        this.general = general;
        this.processSipCallTriggers = processSipCallTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessSipCallTriggerWSDTO> getProcessSipCallTriggers() {
        return processSipCallTriggers;
    }

    public void setProcessSipCallTriggers(List<ProcessSipCallTriggerWSDTO> processSipCallTriggers) {
        this.processSipCallTriggers = processSipCallTriggers;
    }
}
