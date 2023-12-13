package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

public class ProcessSmsMessageTempWSDTO {

    private ProcessSmsMessageTempDBModel smsMessageTemp;

    public ProcessSmsMessageTempWSDTO() {
    }

    public ProcessSmsMessageTempWSDTO(ProcessSmsMessageTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }

    public ProcessSmsMessageTempDBModel getSmsMessageTemp() {
        return smsMessageTemp;
    }

    public void setSmsMessageTemp(ProcessSmsMessageTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }
}
