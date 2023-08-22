package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;

public class WappMessageWSDTO {

    private WappMessageDBModel wappMessage;

    public WappMessageWSDTO() {
    }

    public WappMessageWSDTO(WappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }

    public WappMessageDBModel getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(WappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }
}
