package com.faas.core.base.model.ws.process.details.trigger.temp.dto;

import com.faas.core.base.model.db.process.details.trigger.SmsTriggerTempDBModel;

public class SmsTriggerTempWSDTO {

    private SmsTriggerTempDBModel smsTriggerTemp;

    public SmsTriggerTempWSDTO() {
    }

    public SmsTriggerTempWSDTO(SmsTriggerTempDBModel smsTriggerTemp) {
        this.smsTriggerTemp = smsTriggerTemp;
    }

    public SmsTriggerTempDBModel getSmsTriggerTemp() {
        return smsTriggerTemp;
    }

    public void setSmsTriggerTemp(SmsTriggerTempDBModel smsTriggerTemp) {
        this.smsTriggerTemp = smsTriggerTemp;
    }
}
