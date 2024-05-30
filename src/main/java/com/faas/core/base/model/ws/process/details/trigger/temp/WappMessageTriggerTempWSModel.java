package com.faas.core.base.model.ws.process.details.trigger.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappMessageTriggerTempWSDTO;

import java.util.List;

public class WappMessageTriggerTempWSModel {

    private GeneralWSModel general;
    private List<WappMessageTriggerTempWSDTO>wappMessageTriggerTemps;

    public WappMessageTriggerTempWSModel() {
    }

    public WappMessageTriggerTempWSModel(GeneralWSModel general, List<WappMessageTriggerTempWSDTO> wappMessageTriggerTemps) {
        this.general = general;
        this.wappMessageTriggerTemps = wappMessageTriggerTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappMessageTriggerTempWSDTO> getWappMessageTriggerTemps() {
        return wappMessageTriggerTemps;
    }

    public void setWappMessageTriggerTemps(List<WappMessageTriggerTempWSDTO> wappMessageTriggerTemps) {
        this.wappMessageTriggerTemps = wappMessageTriggerTemps;
    }
}
