package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessEmailTriggerDBModel;

public class ProcessEmailTriggerWSDTO {

    private ProcessEmailTriggerDBModel processEmailTrigger;

    public ProcessEmailTriggerWSDTO() {
    }

    public ProcessEmailTriggerWSDTO(ProcessEmailTriggerDBModel processEmailTrigger) {
        this.processEmailTrigger = processEmailTrigger;
    }

    public ProcessEmailTriggerDBModel getProcessEmailTrigger() {
        return processEmailTrigger;
    }

    public void setProcessEmailTrigger(ProcessEmailTriggerDBModel processEmailTrigger) {
        this.processEmailTrigger = processEmailTrigger;
    }
}
