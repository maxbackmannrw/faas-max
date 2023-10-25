package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.OperationWappMessageDBModel;

public class WappMessageWSDTO {

    private OperationWappMessageDBModel wappMessage;

    public WappMessageWSDTO() {
    }

    public WappMessageWSDTO(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }

    public OperationWappMessageDBModel getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }
}
