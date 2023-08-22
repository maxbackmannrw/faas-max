package com.faas.core.api.model.ws.operation.channel.message.wapp.dto;

import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;

public class ApiWappMessageWSDTO {

    private WappMessageDBModel wappMessage;

    public ApiWappMessageWSDTO() {
    }

    public ApiWappMessageWSDTO(WappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }

    public WappMessageDBModel getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(WappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }
}
