package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;

import java.util.List;

public class TriggerWSModel {

    private GeneralWSModel general;
    private List<TriggerWSDTO>triggers;

    public TriggerWSModel() {
    }

    public TriggerWSModel(GeneralWSModel general, List<TriggerWSDTO> triggers) {
        this.general = general;
        this.triggers = triggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<TriggerWSDTO> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<TriggerWSDTO> triggers) {
        this.triggers = triggers;
    }
}
