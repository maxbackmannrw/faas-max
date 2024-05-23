package com.faas.core.base.model.ws.process.details.trigger.temp.ai;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.ai.dto.AITriggerTempWSDTO;

import java.util.List;

public class AITriggerTempWSModel {

    private GeneralWSModel general;
    private List<AITriggerTempWSDTO>aiTriggerTemps;

    public AITriggerTempWSModel() {
    }

    public AITriggerTempWSModel(List<AITriggerTempWSDTO> aiTriggerTemps, GeneralWSModel general) {
        this.aiTriggerTemps = aiTriggerTemps;
        this.general = general;
    }

    public List<AITriggerTempWSDTO> getAiTriggerTemps() {
        return aiTriggerTemps;
    }

    public void setAiTriggerTemps(List<AITriggerTempWSDTO> aiTriggerTemps) {
        this.aiTriggerTemps = aiTriggerTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }
}
