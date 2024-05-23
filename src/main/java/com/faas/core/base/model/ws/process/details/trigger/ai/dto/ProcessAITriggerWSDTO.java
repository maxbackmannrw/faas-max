package com.faas.core.base.model.ws.process.details.trigger.ai.dto;

import com.faas.core.base.model.db.process.details.trigger.AITriggerDBModel;

public class ProcessAITriggerWSDTO {

    private AITriggerDBModel processAITrigger;

    public ProcessAITriggerWSDTO() {
    }

    public ProcessAITriggerWSDTO(AITriggerDBModel processAITrigger) {
        this.processAITrigger = processAITrigger;
    }

    public AITriggerDBModel getProcessAITrigger() {
        return processAITrigger;
    }

    public void setProcessAITrigger(AITriggerDBModel processAITrigger) {
        this.processAITrigger = processAITrigger;
    }
}
