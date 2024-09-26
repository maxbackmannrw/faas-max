package com.faas.core.api.model.ws.operation.manager.channel.message.dto;

import com.faas.core.data.db.operation.details.channel.OperationSmsDBModel;

public class ApiOperationSmsWSDTO {

    private OperationSmsDBModel operationSms;

    public ApiOperationSmsWSDTO() {
    }

    public ApiOperationSmsWSDTO(OperationSmsDBModel operationSms) {
        this.operationSms = operationSms;
    }

    public OperationSmsDBModel getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(OperationSmsDBModel operationSms) {
        this.operationSms = operationSms;
    }
}
