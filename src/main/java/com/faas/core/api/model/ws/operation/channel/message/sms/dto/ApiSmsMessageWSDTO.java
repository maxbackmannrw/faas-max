package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;

public class ApiSmsMessageWSDTO {

    private SmsMessageDBModel smsMessage;

    public ApiSmsMessageWSDTO() {
    }

    public ApiSmsMessageWSDTO(SmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public SmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(SmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
