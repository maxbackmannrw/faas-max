package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;

public class ProcessEmailTempWSDTO {

    private EmailTempDBModel processEmailTemp;

    public ProcessEmailTempWSDTO() {
    }

    public ProcessEmailTempWSDTO(EmailTempDBModel processEmailTemp) {
        this.processEmailTemp = processEmailTemp;
    }

    public EmailTempDBModel getProcessEmailTemp() {
        return processEmailTemp;
    }

    public void setProcessEmailTemp(EmailTempDBModel processEmailTemp) {
        this.processEmailTemp = processEmailTemp;
    }
}
