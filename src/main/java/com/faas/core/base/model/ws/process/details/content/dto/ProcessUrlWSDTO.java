package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;

public class ProcessUrlWSDTO {

    private ProcessUrlDAO processUrl;

    public ProcessUrlWSDTO() {
    }

    public ProcessUrlWSDTO(ProcessUrlDAO processUrl) {
        this.processUrl = processUrl;
    }

    public ProcessUrlDAO getProcessUrl() {
        return processUrl;
    }

    public void setProcessUrl(ProcessUrlDAO processUrl) {
        this.processUrl = processUrl;
    }
}
