package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessEmailTriggerWSDTO;

import java.util.List;

public class ProcessEmailTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessEmailTriggerWSDTO>processEmailTriggers;

    public ProcessEmailTriggerWSModel() {
    }

    public ProcessEmailTriggerWSModel(GeneralWSModel general, List<ProcessEmailTriggerWSDTO> processEmailTriggers) {
        this.general = general;
        this.processEmailTriggers = processEmailTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessEmailTriggerWSDTO> getProcessEmailTriggers() {
        return processEmailTriggers;
    }

    public void setProcessEmailTriggers(List<ProcessEmailTriggerWSDTO> processEmailTriggers) {
        this.processEmailTriggers = processEmailTriggers;
    }
}
