package com.faas.core.base.model.ws.process.settings.dto;

import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;

public class ProcessTypeWSDTO {

    private ProcessTypeDBModel processType;

    public ProcessTypeWSDTO() {
    }

    public ProcessTypeWSDTO(ProcessTypeDBModel processType) {
        this.processType = processType;
    }

    public ProcessTypeDBModel getProcessType() {
        return processType;
    }

    public void setProcessType(ProcessTypeDBModel processType) {
        this.processType = processType;
    }
}
