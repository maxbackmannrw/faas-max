package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.OperationSipCallDBModel;

public class SipCallWSDTO {

    private OperationSipCallDBModel sipCall;

    public SipCallWSDTO() {
    }

    public SipCallWSDTO(OperationSipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }

    public OperationSipCallDBModel getSipCall() {
        return sipCall;
    }

    public void setSipCall(OperationSipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }
}
