package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationPushDBModel;

public class ApiOperationPushWSDTO {

    private OperationPushDBModel operationPush;

    public ApiOperationPushWSDTO() {
    }

    public ApiOperationPushWSDTO(OperationPushDBModel operationPush) {
        this.operationPush = operationPush;
    }

    public OperationPushDBModel getOperationPush() {
        return operationPush;
    }

    public void setOperationPush(OperationPushDBModel operationPush) {
        this.operationPush = operationPush;
    }
}
