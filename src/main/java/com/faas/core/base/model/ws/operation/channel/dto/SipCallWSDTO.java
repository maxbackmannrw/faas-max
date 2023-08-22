package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.SipCallDBModel;

public class SipCallWSDTO {

    private SipCallDBModel sipCall;

    public SipCallWSDTO() {
    }

    public SipCallWSDTO(SipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }

    public SipCallDBModel getSipCall() {
        return sipCall;
    }

    public void setSipCall(SipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }
}
