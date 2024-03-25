package com.faas.core.base.model.ws.process.details.channel.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.ProcessChannelTriggerWSDTO;

public class ProcessChannelTriggerWSModel {

    private GeneralWSModel general;
    private ProcessChannelTriggerWSDTO processChannelTrigger;

    public ProcessChannelTriggerWSModel() {
    }

    public ProcessChannelTriggerWSModel(GeneralWSModel general, ProcessChannelTriggerWSDTO processChannelTrigger) {
        this.general = general;
        this.processChannelTrigger = processChannelTrigger;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessChannelTriggerWSDTO getProcessChannelTrigger() {
        return processChannelTrigger;
    }

    public void setProcessChannelTrigger(ProcessChannelTriggerWSDTO processChannelTrigger) {
        this.processChannelTrigger = processChannelTrigger;
    }
}
