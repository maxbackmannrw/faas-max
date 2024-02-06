package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;

public class ApiOperationWappMessageWSDTO {

    private OperationWappMessageDBModel wappMessage;

    public ApiOperationWappMessageWSDTO() {
    }

    public ApiOperationWappMessageWSDTO(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }

    public OperationWappMessageDBModel getWappMessage() {
        return wappMessage;
    }

    public void setWappMessage(OperationWappMessageDBModel wappMessage) {
        this.wappMessage = wappMessage;
    }
}