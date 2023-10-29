package com.faas.core.api.model.ws.operation.channel.call.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;

public class ApiWappCallWSDTO {

    private OperationWappCallDBModel wappCall;

    public ApiWappCallWSDTO() {
    }

    public ApiWappCallWSDTO(OperationWappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }

    public OperationWappCallDBModel getWappCall() {
        return wappCall;
    }

    public void setWappCall(OperationWappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }
}
