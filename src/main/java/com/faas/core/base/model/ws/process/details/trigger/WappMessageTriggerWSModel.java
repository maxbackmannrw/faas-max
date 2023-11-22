package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.WappMessageTriggerWSDTO;

import java.util.List;

public class WappMessageTriggerWSModel {

    private GeneralWSModel general;
    private List<WappMessageTriggerWSDTO>wappMessageTriggers;

    public WappMessageTriggerWSModel() {
    }

    public WappMessageTriggerWSModel(GeneralWSModel general, List<WappMessageTriggerWSDTO> wappMessageTriggers) {
        this.general = general;
        this.wappMessageTriggers = wappMessageTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappMessageTriggerWSDTO> getWappMessageTriggers() {
        return wappMessageTriggers;
    }

    public void setWappMessageTriggers(List<WappMessageTriggerWSDTO> wappMessageTriggers) {
        this.wappMessageTriggers = wappMessageTriggers;
    }
}
