package com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.dto;

import com.faas.core.base.model.db.process.details.trigger.WappCallTriggerTempDBModel;

public class WappCallTriggerTempWSDTO {

    private WappCallTriggerTempDBModel wappCallTriggerTemp;

    public WappCallTriggerTempWSDTO() {
    }

    public WappCallTriggerTempWSDTO(WappCallTriggerTempDBModel wappCallTriggerTemp) {
        this.wappCallTriggerTemp = wappCallTriggerTemp;
    }

    public WappCallTriggerTempDBModel getWappCallTriggerTemp() {
        return wappCallTriggerTemp;
    }

    public void setWappCallTriggerTemp(WappCallTriggerTempDBModel wappCallTriggerTemp) {
        this.wappCallTriggerTemp = wappCallTriggerTemp;
    }
}
