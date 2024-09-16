package com.faas.core.data.ws.base.campaign.settings.dto;

import com.faas.core.data.db.campaign.settings.TriggerTypeDBModel;

public class TriggerTypeWSDTO {

    private TriggerTypeDBModel triggerType;

    public TriggerTypeWSDTO() {
    }

    public TriggerTypeWSDTO(TriggerTypeDBModel triggerType) {
        this.triggerType = triggerType;
    }

    public TriggerTypeDBModel getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(TriggerTypeDBModel triggerType) {
        this.triggerType = triggerType;
    }
}
