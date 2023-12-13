package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

public class WappMessageTempWSDTO {

    private ProcessWappMessageTempDBModel wappMessageTemp;

    public WappMessageTempWSDTO() {
    }

    public WappMessageTempWSDTO(ProcessWappMessageTempDBModel wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }

    public ProcessWappMessageTempDBModel getWappMessageTemp() {
        return wappMessageTemp;
    }

    public void setWappMessageTemp(ProcessWappMessageTempDBModel wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }
}
