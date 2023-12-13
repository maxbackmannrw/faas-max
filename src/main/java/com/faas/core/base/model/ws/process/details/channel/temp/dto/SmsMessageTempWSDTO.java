package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

public class SmsMessageTempWSDTO {

    private ProcessSmsMessageTempDBModel smsMessageTemp;

    public SmsMessageTempWSDTO() {
    }

    public SmsMessageTempWSDTO(ProcessSmsMessageTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }

    public ProcessSmsMessageTempDBModel getSmsMessageTemp() {
        return smsMessageTemp;
    }

    public void setSmsMessageTemp(ProcessSmsMessageTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }
}
