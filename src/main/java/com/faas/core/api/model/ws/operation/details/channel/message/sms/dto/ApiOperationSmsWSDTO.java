package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;

public class ApiOperationSmsWSDTO {

    private OperationSmsMessageDBModel operationSms;

    public ApiOperationSmsWSDTO() {
    }

    public ApiOperationSmsWSDTO(OperationSmsMessageDBModel operationSms) {
        this.operationSms = operationSms;
    }

    public OperationSmsMessageDBModel getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(OperationSmsMessageDBModel operationSms) {
        this.operationSms = operationSms;
    }
}
