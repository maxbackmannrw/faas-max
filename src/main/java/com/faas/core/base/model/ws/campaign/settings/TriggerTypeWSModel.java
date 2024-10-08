package com.faas.core.base.model.ws.campaign.settings;

import com.faas.core.base.model.ws.campaign.settings.dto.TriggerTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
