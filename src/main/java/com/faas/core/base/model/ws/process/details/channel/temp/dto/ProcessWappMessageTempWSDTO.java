package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.WappMessageTempDBModel;

public class ProcessWappMessageTempWSDTO {

    private WappMessageTempDBModel processWappMessageTemp;

    public ProcessWappMessageTempWSDTO() {
    }

    public ProcessWappMessageTempWSDTO(WappMessageTempDBModel processWappMessageTemp) {
        this.processWappMessageTemp = processWappMessageTemp;
    }

    public WappMessageTempDBModel getProcessWappMessageTemp() {
        return processWappMessageTemp;
    }

    public void setProcessWappMessageTemp(WappMessageTempDBModel processWappMessageTemp) {
        this.processWappMessageTemp = processWappMessageTemp;
    }
}
