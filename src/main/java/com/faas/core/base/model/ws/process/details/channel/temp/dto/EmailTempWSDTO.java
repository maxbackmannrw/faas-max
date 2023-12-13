package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

public class EmailTempWSDTO {

    private ProcessEmailTempDBModel emailTemp;

    public EmailTempWSDTO() {
    }

    public EmailTempWSDTO(ProcessEmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }

    public ProcessEmailTempDBModel getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(ProcessEmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }
}
