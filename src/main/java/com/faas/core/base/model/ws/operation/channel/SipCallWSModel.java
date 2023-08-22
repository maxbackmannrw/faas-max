package com.faas.core.base.model.ws.operation.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.channel.dto.SipCallWSDTO;

import java.util.List;

public class SipCallWSModel {

    private GeneralWSModel general;
    private List<SipCallWSDTO>sipCalls;

    public SipCallWSModel() {
    }

    public SipCallWSModel(GeneralWSModel general, List<SipCallWSDTO> sipCalls) {
        this.general = general;
        this.sipCalls = sipCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SipCallWSDTO> getSipCalls() {
        return sipCalls;
    }

    public void setSipCalls(List<SipCallWSDTO> sipCalls) {
        this.sipCalls = sipCalls;
    }
}
