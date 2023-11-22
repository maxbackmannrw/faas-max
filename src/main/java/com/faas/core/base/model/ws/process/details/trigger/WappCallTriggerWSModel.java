package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.WappCallTriggerWSDTO;

import java.util.List;

public class WappCallTriggerWSModel {

    private GeneralWSModel general;
    private List<WappCallTriggerWSDTO>wappCallTriggers;

    public WappCallTriggerWSModel() {
    }

    public WappCallTriggerWSModel(GeneralWSModel general, List<WappCallTriggerWSDTO> wappCallTriggers) {
        this.general = general;
        this.wappCallTriggers = wappCallTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappCallTriggerWSDTO> getWappCallTriggers() {
        return wappCallTriggers;
    }

    public void setWappCallTriggers(List<WappCallTriggerWSDTO> wappCallTriggers) {
        this.wappCallTriggers = wappCallTriggers;
    }
}
