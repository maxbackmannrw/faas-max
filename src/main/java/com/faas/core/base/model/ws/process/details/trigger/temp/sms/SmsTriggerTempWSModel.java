package com.faas.core.base.model.ws.process.details.trigger.temp.sms;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.sms.dto.SmsTriggerTempWSDTO;

import java.util.List;

public class SmsTriggerTempWSModel {

    private GeneralWSModel general;
    private List<SmsTriggerTempWSDTO>smsTriggerTemps;

    public SmsTriggerTempWSModel() {
    }

    public SmsTriggerTempWSModel(GeneralWSModel general, List<SmsTriggerTempWSDTO> smsTriggerTemps) {
        this.general = general;
        this.smsTriggerTemps = smsTriggerTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SmsTriggerTempWSDTO> getSmsTriggerTemps() {
        return smsTriggerTemps;
    }

    public void setSmsTriggerTemps(List<SmsTriggerTempWSDTO> smsTriggerTemps) {
        this.smsTriggerTemps = smsTriggerTemps;
    }
}
