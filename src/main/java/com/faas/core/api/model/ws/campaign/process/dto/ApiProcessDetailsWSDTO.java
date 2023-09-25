package com.faas.core.api.model.ws.campaign.process.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;

public class ApiProcessDetailsWSDTO {

    private ProcessDBModel process;

    public ApiProcessDetailsWSDTO() {
    }

    public ApiProcessDetailsWSDTO(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }
}
