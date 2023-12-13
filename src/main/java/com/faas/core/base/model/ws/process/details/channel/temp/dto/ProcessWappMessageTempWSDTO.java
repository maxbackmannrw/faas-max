package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

public class ProcessWappMessageTempWSDTO {

    private ProcessWappMessageTempDBModel wappMessageTemp;

    public ProcessWappMessageTempWSDTO() {
    }

    public ProcessWappMessageTempWSDTO(ProcessWappMessageTempDBModel wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }

    public ProcessWappMessageTempDBModel getWappMessageTemp() {
        return wappMessageTemp;
    }

    public void setWappMessageTemp(ProcessWappMessageTempDBModel wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }
}
