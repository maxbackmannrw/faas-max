package com.faas.core.api.model.ws.operation.channel.message.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;

public class ApiWappMessageWSDTO {

    private OperationWappMessageDBModel wappMessage;

    public ApiWappMessageWSDTO() {
    }

    public ApiWappMessageWSDTO(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }

    public OperationWappMessageDBModel getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }
}
