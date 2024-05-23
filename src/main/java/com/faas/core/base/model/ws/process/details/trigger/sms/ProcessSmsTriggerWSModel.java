package com.faas.core.base.model.ws.process.details.trigger.sms;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.sms.dto.ProcessSmsTriggerWSDTO;

import java.util.List;

public class ProcessSmsTriggerWSModel {

    private GeneralWSModel general;
    private List<ProcessSmsTriggerWSDTO>processSmsTriggers;

    public ProcessSmsTriggerWSModel() {
    }

    public ProcessSmsTriggerWSModel(GeneralWSModel general, List<ProcessSmsTriggerWSDTO> processSmsTriggers) {
        this.general = general;
        this.processSmsTriggers = processSmsTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessSmsTriggerWSDTO> getProcessSmsTriggers() {
        return processSmsTriggers;
    }

    public void setProcessSmsTriggers(List<ProcessSmsTriggerWSDTO> processSmsTriggers) {
        this.processSmsTriggers = processSmsTriggers;
    }
}
