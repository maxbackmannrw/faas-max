package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsDBModel;

public class OperationSmsWSDTO {

    private OperationSmsDBModel operationSms;

    public OperationSmsWSDTO() {
    }

    public OperationSmsWSDTO(OperationSmsDBModel operationSms) {
        this.operationSms = operationSms;
    }

    public OperationSmsDBModel getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(OperationSmsDBModel operationSms) {
        this.operationSms = operationSms;
    }
}
