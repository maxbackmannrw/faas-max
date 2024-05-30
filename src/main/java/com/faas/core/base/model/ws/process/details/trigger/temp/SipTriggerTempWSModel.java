package com.faas.core.base.model.ws.process.details.trigger.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.SipTriggerTempWSDTO;

import java.util.List;

public class SipTriggerTempWSModel {

    private GeneralWSModel general;
    private List<SipTriggerTempWSDTO>sipTriggerTemps;

    public SipTriggerTempWSModel() {
    }

    public SipTriggerTempWSModel(GeneralWSModel general, List<SipTriggerTempWSDTO> sipTriggerTemps) {
        this.general = general;
        this.sipTriggerTemps = sipTriggerTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SipTriggerTempWSDTO> getSipTriggerTemps() {
        return sipTriggerTemps;
    }

    public void setSipTriggerTemps(List<SipTriggerTempWSDTO> sipTriggerTemps) {
        this.sipTriggerTemps = sipTriggerTemps;
    }
}
