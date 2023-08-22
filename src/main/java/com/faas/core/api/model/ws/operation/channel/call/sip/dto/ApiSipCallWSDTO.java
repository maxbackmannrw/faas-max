package com.faas.core.api.model.ws.operation.channel.call.sip.dto;

import com.faas.core.base.model.db.operation.channel.SipCallDBModel;

public class ApiSipCallWSDTO {

    private SipCallDBModel sipCall;

    public ApiSipCallWSDTO() {
    }

    public ApiSipCallWSDTO(SipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }

    public SipCallDBModel getSipCall() {
        return sipCall;
    }

    public void setSipCall(SipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }
}
