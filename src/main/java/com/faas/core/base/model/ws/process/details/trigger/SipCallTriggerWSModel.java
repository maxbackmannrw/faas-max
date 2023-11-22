package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.SipCallTriggerWSDTO;

import java.util.List;

public class SipCallTriggerWSModel {

    private GeneralWSModel general;
    private List<SipCallTriggerWSDTO>sipCallTriggers;

    public SipCallTriggerWSModel() {
    }

    public SipCallTriggerWSModel(GeneralWSModel general, List<SipCallTriggerWSDTO> sipCallTriggers) {
        this.general = general;
        this.sipCallTriggers = sipCallTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SipCallTriggerWSDTO> getSipCallTriggers() {
        return sipCallTriggers;
    }

    public void setSipCallTriggers(List<SipCallTriggerWSDTO> sipCallTriggers) {
        this.sipCallTriggers = sipCallTriggers;
    }
}
