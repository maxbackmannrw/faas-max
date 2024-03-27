package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessSmsTriggerDBModel;

public class ProcessSmsTriggerWSDTO {

    private ProcessSmsTriggerDBModel processSmsTrigger;

    public ProcessSmsTriggerWSDTO() {
    }

    public ProcessSmsTriggerWSDTO(ProcessSmsTriggerDBModel processSmsTrigger) {
        this.processSmsTrigger = processSmsTrigger;
    }

    public ProcessSmsTriggerDBModel getProcessSmsTrigger() {
        return processSmsTrigger;
    }

    public void setProcessSmsTrigger(ProcessSmsTriggerDBModel processSmsTrigger) {
        this.processSmsTrigger = processSmsTrigger;
    }
}
