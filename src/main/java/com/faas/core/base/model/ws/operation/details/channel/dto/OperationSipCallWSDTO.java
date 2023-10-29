package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;

public class OperationSipCallWSDTO {

    private OperationSipCallDBModel sipCall;

    public OperationSipCallWSDTO() {
    }

    public OperationSipCallWSDTO(OperationSipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }

    public OperationSipCallDBModel getSipCall() {
        return sipCall;
    }

    public void setSipCall(OperationSipCallDBModel sipCall) {
        this.sipCall = sipCall;
    }
}
