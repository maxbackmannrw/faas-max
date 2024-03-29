package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessWappMessageTriggerWSDTO;

import java.util.List;

public class ProcessWappMessageTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessWappMessageTriggerWSDTO>processWappMessageTriggers;

    public ProcessWappMessageTriggerWSModel() {
    }

    public ProcessWappMessageTriggerWSModel(GeneralWSModel general, List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggers) {
        this.general = general;
        this.processWappMessageTriggers = processWappMessageTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessWappMessageTriggerWSDTO> getProcessWappMessageTriggers() {
        return processWappMessageTriggers;
    }

    public void setProcessWappMessageTriggers(List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggers) {
        this.processWappMessageTriggers = processWappMessageTriggers;
    }
}
