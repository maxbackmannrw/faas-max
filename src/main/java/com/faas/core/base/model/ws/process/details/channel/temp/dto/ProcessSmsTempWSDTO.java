package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;

public class ProcessSmsTempWSDTO {

    private ProcessSmsTempDBModel smsMessageTemp;

    public ProcessSmsTempWSDTO() {
    }

    public ProcessSmsTempWSDTO(ProcessSmsTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }

    public ProcessSmsTempDBModel getSmsMessageTemp() {
        return smsMessageTemp;
    }

    public void setSmsMessageTemp(ProcessSmsTempDBModel smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }
}
