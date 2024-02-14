package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;

public class ApiOperationPushWSDTO {

    private OperationPushMessageDBModel operationPush;

    public ApiOperationPushWSDTO() {
    }

    public ApiOperationPushWSDTO(OperationPushMessageDBModel operationPush) {
        this.operationPush = operationPush;
    }

    public OperationPushMessageDBModel getOperationPush() {
        return operationPush;
    }

    public void setOperationPush(OperationPushMessageDBModel operationPush) {
        this.operationPush = operationPush;
    }
}
