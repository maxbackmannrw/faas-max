package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

public class ProcessWappMessageTempWSDTO {

    private ProcessWappMessageTempDBModel processWappMessageTemp;

    public ProcessWappMessageTempWSDTO() {
    }

    public ProcessWappMessageTempWSDTO(ProcessWappMessageTempDBModel processWappMessageTemp) {
        this.processWappMessageTemp = processWappMessageTemp;
    }

    public ProcessWappMessageTempDBModel getProcessWappMessageTemp() {
        return processWappMessageTemp;
    }

    public void setProcessWappMessageTemp(ProcessWappMessageTempDBModel processWappMessageTemp) {
        this.processWappMessageTemp = processWappMessageTemp;
    }
}
