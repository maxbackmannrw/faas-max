package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationPushDBModel;

public class OperationPushWSDTO {

    private OperationPushDBModel operationPush;

    public OperationPushWSDTO() {
    }

    public OperationPushWSDTO(OperationPushDBModel operationPush) {
        this.operationPush = operationPush;
    }

    public OperationPushDBModel getOperationPush() {
        return operationPush;
    }

    public void setOperationPush(OperationPushDBModel operationPush) {
        this.operationPush = operationPush;
    }
}
