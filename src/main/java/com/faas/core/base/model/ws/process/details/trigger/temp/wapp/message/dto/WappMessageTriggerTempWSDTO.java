package com.faas.core.base.model.ws.process.details.trigger.temp.wapp.message.dto;

import com.faas.core.base.model.db.process.details.trigger.WappMessageTriggerTempDBModel;

public class WappMessageTriggerTempWSDTO {

    private WappMessageTriggerTempDBModel wappMessageTriggerTemp;

    public WappMessageTriggerTempWSDTO() {
    }

    public WappMessageTriggerTempWSDTO(WappMessageTriggerTempDBModel wappMessageTriggerTemp) {
        this.wappMessageTriggerTemp = wappMessageTriggerTemp;
    }

    public WappMessageTriggerTempDBModel getWappMessageTriggerTemp() {
        return wappMessageTriggerTemp;
    }

    public void setWappMessageTriggerTemp(WappMessageTriggerTempDBModel wappMessageTriggerTemp) {
        this.wappMessageTriggerTemp = wappMessageTriggerTemp;
    }
}
