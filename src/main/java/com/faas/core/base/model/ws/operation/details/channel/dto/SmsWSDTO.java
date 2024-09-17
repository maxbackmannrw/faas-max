package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.data.db.operation.details.channel.OperationSmsDBModel;

public class SmsWSDTO {

    private OperationSmsDBModel operationSms;

    public SmsWSDTO() {
    }

    public SmsWSDTO(OperationSmsDBModel operationSms) {
        this.operationSms = operationSms;
    }

    public OperationSmsDBModel getOperationSms() {
        return operationSms;
    }

    public void setOperationSms(OperationSmsDBModel operationSms) {
        this.operationSms = operationSms;
    }
}
