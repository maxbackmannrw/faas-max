package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;

public class ApiOperationSmsWSDTO {

    private OperationSmsMessageDBModel smsMessage;

    public ApiOperationSmsWSDTO() {
    }

    public ApiOperationSmsWSDTO(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public OperationSmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
