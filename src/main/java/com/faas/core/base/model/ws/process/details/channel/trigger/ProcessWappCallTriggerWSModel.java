package com.faas.core.base.model.ws.process.details.channel.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.ProcessWappCallTriggerWSDTO;

import java.util.List;

public class ProcessWappCallTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessWappCallTriggerWSDTO>processWappCallTriggers;

    public ProcessWappCallTriggerWSModel() {
    }

    public ProcessWappCallTriggerWSModel(GeneralWSModel general, List<ProcessWappCallTriggerWSDTO> processWappCallTriggers) {
        this.general = general;
        this.processWappCallTriggers = processWappCallTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessWappCallTriggerWSDTO> getProcessWappCallTriggers() {
        return processWappCallTriggers;
    }

    public void setProcessWappCallTriggers(List<ProcessWappCallTriggerWSDTO> processWappCallTriggers) {
        this.processWappCallTriggers = processWappCallTriggers;
    }
}
