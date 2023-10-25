package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.OperationWappCallDBModel;

public class WappCallWSDTO {

    private OperationWappCallDBModel wappCall;

    public WappCallWSDTO() {
    }

    public WappCallWSDTO(OperationWappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }

    public OperationWappCallDBModel getWappCall() {
        return wappCall;
    }

    public void setWappCall(OperationWappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }
}
