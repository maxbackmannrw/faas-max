package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.AiTriggerWSDTO;

import java.util.List;

public class AiTriggerWSModel {

    private GeneralWSModel general;
    private List<AiTriggerWSDTO>aiTriggers;

    public AiTriggerWSModel() {
    }

    public AiTriggerWSModel(GeneralWSModel general, List<AiTriggerWSDTO> aiTriggers) {
        this.general = general;
        this.aiTriggers = aiTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AiTriggerWSDTO> getAiTriggers() {
        return aiTriggers;
    }

    public void setAiTriggers(List<AiTriggerWSDTO> aiTriggers) {
        this.aiTriggers = aiTriggers;
    }
}
