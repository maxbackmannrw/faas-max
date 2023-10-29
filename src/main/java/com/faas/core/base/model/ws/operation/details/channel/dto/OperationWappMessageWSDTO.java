package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;

public class OperationWappMessageWSDTO {

    private OperationWappMessageDBModel wappMessage;

    public OperationWappMessageWSDTO() {
    }

    public OperationWappMessageWSDTO(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }

    public OperationWappMessageDBModel getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }
}
