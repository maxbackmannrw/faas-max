package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.operation.channel.OperationSmsMessageDBModel;

public class ApiSmsMessageWSDTO {

    private OperationSmsMessageDBModel smsMessage;

    public ApiSmsMessageWSDTO() {
    }

    public ApiSmsMessageWSDTO(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public OperationSmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
