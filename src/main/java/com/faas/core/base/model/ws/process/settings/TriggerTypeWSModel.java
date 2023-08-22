package com.faas.core.base.model.ws.process.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.settings.dto.TriggerTypeWSDTO;

import java.util.List;

public class TriggerTypeWSModel {

    private GeneralWSModel general;
    private List<TriggerTypeWSDTO> triggerTypes;

    public TriggerTypeWSModel() {
    }

    public TriggerTypeWSModel(GeneralWSModel general, List<TriggerTypeWSDTO> triggerTypes) {
        this.general = general;
        this.triggerTypes = triggerTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<TriggerTypeWSDTO> getTriggerTypes() {
        return triggerTypes;
    }

    public void setTriggerTypes(List<TriggerTypeWSDTO> triggerTypes) {
        this.triggerTypes = triggerTypes;
    }
}
