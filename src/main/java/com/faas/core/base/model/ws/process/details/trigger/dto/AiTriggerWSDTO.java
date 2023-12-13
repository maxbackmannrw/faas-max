package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessAiTriggerDBModel;

public class AiTriggerWSDTO {

    private ProcessAiTriggerDBModel aiTrigger;

    public AiTriggerWSDTO() {
    }

    public AiTriggerWSDTO(ProcessAiTriggerDBModel aiTrigger) {
        this.aiTrigger = aiTrigger;
    }

    public ProcessAiTriggerDBModel getAiTrigger() {
        return aiTrigger;
    }

    public void setAiTrigger(ProcessAiTriggerDBModel aiTrigger) {
        this.aiTrigger = aiTrigger;
    }
}
