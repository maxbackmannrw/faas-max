package com.faas.core.base.model.ws.process.details.trigger.sip;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.sip.dto.ProcessSipTriggerWSDTO;

import java.util.List;

public class ProcessSipTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessSipTriggerWSDTO>processSipTriggers;

    public ProcessSipTriggerWSModel() {
    }

    public ProcessSipTriggerWSModel(GeneralWSModel general, List<ProcessSipTriggerWSDTO> processSipTriggers) {
        this.general = general;
        this.processSipTriggers = processSipTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessSipTriggerWSDTO> getProcessSipTriggers() {
        return processSipTriggers;
    }

    public void setProcessSipTriggers(List<ProcessSipTriggerWSDTO> processSipTriggers) {
        this.processSipTriggers = processSipTriggers;
    }
}
