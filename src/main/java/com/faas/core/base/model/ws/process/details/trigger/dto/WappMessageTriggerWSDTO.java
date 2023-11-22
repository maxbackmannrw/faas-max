package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.WappMessageTriggerDBModel;

public class WappMessageTriggerWSDTO {

    private WappMessageTriggerDBModel wappMessageTrigger;

    public WappMessageTriggerWSDTO() {
    }

    public WappMessageTriggerWSDTO(WappMessageTriggerDBModel wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }

    public WappMessageTriggerDBModel getWappMessageTrigger() {
        return wappMessageTrigger;
    }

    public void setWappMessageTrigger(WappMessageTriggerDBModel wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }
}
