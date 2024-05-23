package com.faas.core.base.model.ws.process.details.trigger.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.ProcessTriggerTempWSDTO;

public class ProcessTriggerTempWSModel {

    private GeneralWSModel general;
    private ProcessTriggerTempWSDTO processTriggerTemp;

    public ProcessTriggerTempWSModel() {
    }

    public ProcessTriggerTempWSModel(GeneralWSModel general, ProcessTriggerTempWSDTO processTriggerTemp) {
        this.general = general;
        this.processTriggerTemp = processTriggerTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessTriggerTempWSDTO getProcessTriggerTemp() {
        return processTriggerTemp;
    }

    public void setProcessTriggerTemp(ProcessTriggerTempWSDTO processTriggerTemp) {
        this.processTriggerTemp = processTriggerTemp;
    }
}
