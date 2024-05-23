package com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.dto.WappCallTriggerTempWSDTO;

import java.util.List;

public class WappCallTriggerTempWSModel {

    private GeneralWSModel general;
    private List<WappCallTriggerTempWSDTO>wappCallTriggerTemps;

    public WappCallTriggerTempWSModel() {
    }

    public WappCallTriggerTempWSModel(GeneralWSModel general, List<WappCallTriggerTempWSDTO> wappCallTriggerTemps) {
        this.general = general;
        this.wappCallTriggerTemps = wappCallTriggerTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappCallTriggerTempWSDTO> getWappCallTriggerTemps() {
        return wappCallTriggerTemps;
    }

    public void setWappCallTriggerTemps(List<WappCallTriggerTempWSDTO> wappCallTriggerTemps) {
        this.wappCallTriggerTemps = wappCallTriggerTemps;
    }
}
