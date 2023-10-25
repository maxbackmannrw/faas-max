package com.faas.core.api.model.ws.operation.channel.call.sip.dto;

import com.faas.core.base.model.db.operation.channel.OperationSipCallDBModel;

public class ApiSipCallWSDTO {

    private OperationSipCallDBModel sipCall;

    public ApiSipCallWSDTO() {
    }

    public ApiSipCallWSDTO(OperationSipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }

    public OperationSipCallDBModel getSipCall() {
        return sipCall;
    }

    public void setSipCall(OperationSipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }
}
