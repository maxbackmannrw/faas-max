package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;

public class ProcessDataWSDTO {

    private ProcessDataDAO processData;

    public ProcessDataWSDTO() {
    }

    public ProcessDataWSDTO(ProcessDataDAO processData) {
        this.processData = processData;
    }

    public ProcessDataDAO getProcessData() {
        return processData;
    }

    public void setProcessData(ProcessDataDAO processData) {
        this.processData = processData;
    }
}
