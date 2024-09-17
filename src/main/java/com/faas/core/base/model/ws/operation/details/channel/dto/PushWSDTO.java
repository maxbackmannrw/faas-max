package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.data.db.operation.details.channel.OperationPushDBModel;

public class PushWSDTO {

    private OperationPushDBModel operationPush;

    public PushWSDTO() {
    }

    public PushWSDTO(OperationPushDBModel operationPush) {
        this.operationPush = operationPush;
    }

    public OperationPushDBModel getOperationPush() {
        return operationPush;
    }

    public void setOperationPush(OperationPushDBModel operationPush) {
        this.operationPush = operationPush;
    }
}
