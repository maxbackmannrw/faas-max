package com.faas.core.base.model.ws.process.details.trigger.temp.dto;

import com.faas.core.base.model.db.process.details.trigger.AITriggerTempDBModel;

public class AITriggerTempWSDTO {

    private AITriggerTempDBModel aiTriggerTemp;

    public AITriggerTempWSDTO() {
    }

    public AITriggerTempWSDTO(AITriggerTempDBModel aiTriggerTemp) {
        this.aiTriggerTemp = aiTriggerTemp;
    }

    public AITriggerTempDBModel getAiTriggerTemp() {
        return aiTriggerTemp;
    }

    public void setAiTriggerTemp(AITriggerTempDBModel aiTriggerTemp) {
        this.aiTriggerTemp = aiTriggerTemp;
    }
}
