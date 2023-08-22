package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;

public class SmsMessageWSDTO {

    private SmsMessageDBModel smsMessage;

    public SmsMessageWSDTO() {
    }

    public SmsMessageWSDTO(SmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public SmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(SmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
