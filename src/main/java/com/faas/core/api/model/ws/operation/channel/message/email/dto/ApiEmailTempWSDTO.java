package com.faas.core.api.model.ws.operation.channel.message.email.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

public class ApiEmailTempWSDTO {

    private ProcessEmailTempDBModel emailTemp;

    public ApiEmailTempWSDTO() {
    }

    public ApiEmailTempWSDTO(ProcessEmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }

    public ProcessEmailTempDBModel getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(ProcessEmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }
}
