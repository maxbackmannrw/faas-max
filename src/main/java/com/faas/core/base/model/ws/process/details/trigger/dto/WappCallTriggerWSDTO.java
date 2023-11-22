package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.WappCallTriggerDBModel;

public class WappCallTriggerWSDTO {

    private WappCallTriggerDBModel wappCallTrigger;

    public WappCallTriggerWSDTO() {
    }

    public WappCallTriggerWSDTO(WappCallTriggerDBModel wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }

    public WappCallTriggerDBModel getWappCallTrigger() {
        return wappCallTrigger;
    }

    public void setWappCallTrigger(WappCallTriggerDBModel wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }
}
