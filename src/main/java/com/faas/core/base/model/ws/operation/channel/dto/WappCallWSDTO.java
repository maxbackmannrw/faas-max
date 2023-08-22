package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.WappCallDBModel;

public class WappCallWSDTO {

    private WappCallDBModel wappCall;

    public WappCallWSDTO() {
    }

    public WappCallWSDTO(WappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }

    public WappCallDBModel getWappCall() {
        return wappCall;
    }

    public void setWappCall(WappCallDBModel wappCall) {
        this.wappCall = wappCall;
    }
}
