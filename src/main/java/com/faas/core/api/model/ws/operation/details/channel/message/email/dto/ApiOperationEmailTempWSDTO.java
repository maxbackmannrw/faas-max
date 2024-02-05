package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

public class ApiOperationEmailTempWSDTO {

    private ProcessEmailTempDBModel emailTemp;

    public ApiOperationEmailTempWSDTO() {
    }

    public ApiOperationEmailTempWSDTO(ProcessEmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }

    public ProcessEmailTempDBModel getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(ProcessEmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }
}
