package com.faas.core.api.model.ws.operation.channel.call.wapp.dto;

import com.faas.core.base.model.db.operation.channel.WappCallDBModel;

public class ApiWappCallWSDTO {

    private WappCallDBModel wappCall;

    public ApiWappCallWSDTO() {
    }

    public ApiWappCallWSDTO(WappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }

    public WappCallDBModel getWappCall() {
        return wappCall;
    }

    public void setWappCall(WappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }
}
