package com.faas.core.base.model.ws.process.details.trigger.sms.dto;

import com.faas.core.base.model.db.process.details.trigger.SmsTriggerDBModel;

public class ProcessSmsTriggerWSDTO {

    private SmsTriggerDBModel processSmsTrigger;

    public ProcessSmsTriggerWSDTO() {
    }

    public ProcessSmsTriggerWSDTO(SmsTriggerDBModel processSmsTrigger) {
        this.processSmsTrigger = processSmsTrigger;
    }

    public SmsTriggerDBModel getProcessSmsTrigger() {
        return processSmsTrigger;
    }

    public void setProcessSmsTrigger(SmsTriggerDBModel processSmsTrigger) {
        this.processSmsTrigger = processSmsTrigger;
    }
}
