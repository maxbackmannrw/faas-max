package com.faas.core.data.ws.api.operation.details.channel.message.sms.dto;

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
