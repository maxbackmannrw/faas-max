package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.TriggerDBModel;

public class TriggerWSDTO {

    private TriggerDBModel trigger;

    public TriggerWSDTO() {
    }

    public TriggerWSDTO(TriggerDBModel trigger) {
        this.trigger = trigger;
    }

    public TriggerDBModel getTrigger() {
        return trigger;
    }

    public void setTrigger(TriggerDBModel trigger) {
        this.trigger = trigger;
    }
}
