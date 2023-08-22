package com.faas.core.base.model.ws.process.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;

public class ProcessWSDTO {

    private ProcessDBModel process;

    public ProcessWSDTO() {
    }

    public ProcessWSDTO(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }
}
