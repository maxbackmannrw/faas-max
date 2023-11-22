package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.AiTriggerDBModel;

public class AiTriggerWSDTO {

    private AiTriggerDBModel aiTrigger;

    public AiTriggerWSDTO() {
    }

    public AiTriggerWSDTO(AiTriggerDBModel aiTrigger) {
        this.aiTrigger = aiTrigger;
    }

    public AiTriggerDBModel getAiTrigger() {
        return aiTrigger;
    }

    public void setAiTrigger(AiTriggerDBModel aiTrigger) {
        this.aiTrigger = aiTrigger;
    }
}
