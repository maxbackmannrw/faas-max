package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

public class OperationWappCallWSDTO {

    private OperationWappCallDBModel wappCall;

    public OperationWappCallWSDTO() {
    }

    public OperationWappCallWSDTO(OperationWappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }

    public OperationWappCallDBModel getWappCall() {
        return wappCall;
    }

    public void setWappCall(OperationWappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }
}
