package com.faas.core.base.model.ws.process.details.trigger.ai;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ai.dto.ProcessAITriggerWSDTO;

import java.util.List;

public class ProcessAITriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessAITriggerWSDTO>processAITriggers;

    public ProcessAITriggerWSModel() {
    }

    public ProcessAITriggerWSModel(GeneralWSModel general, List<ProcessAITriggerWSDTO> processAITriggers) {
        this.general = general;
        this.processAITriggers = processAITriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessAITriggerWSDTO> getProcessAITriggers() {
        return processAITriggers;
    }

    public void setProcessAITriggers(List<ProcessAITriggerWSDTO> processAITriggers) {
        this.processAITriggers = processAITriggers;
    }
}
