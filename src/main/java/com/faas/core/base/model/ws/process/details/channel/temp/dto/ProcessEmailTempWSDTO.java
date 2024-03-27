package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;

public class ProcessEmailTempWSDTO {

    private ProcessEmailTempDBModel processEmailTemp;

    public ProcessEmailTempWSDTO() {
    }

    public ProcessEmailTempWSDTO(ProcessEmailTempDBModel processEmailTemp) {
        this.processEmailTemp = processEmailTemp;
    }

    public ProcessEmailTempDBModel getProcessEmailTemp() {
        return processEmailTemp;
    }

    public void setProcessEmailTemp(ProcessEmailTempDBModel processEmailTemp) {
        this.processEmailTemp = processEmailTemp;
    }
}
