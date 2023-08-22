package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;

public class SmsMessageTempWSDTO {

    private SmsMessageTempDBModel smsMessageTemp;

    public SmsMessageTempWSDTO() {
    }

    public SmsMessageTempWSDTO(SmsMessageTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }

    public SmsMessageTempDBModel getSmsMessageTemp() {
        return smsMessageTemp;
    }

    public void setSmsMessageTemp(SmsMessageTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }
}
