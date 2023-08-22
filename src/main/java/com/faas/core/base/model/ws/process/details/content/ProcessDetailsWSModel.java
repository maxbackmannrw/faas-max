package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;


public class ProcessDetailsWSModel {

    private GeneralWSModel general;
    private ProcessDetailsWSDTO processDetails;

    public ProcessDetailsWSModel() {
    }

    public ProcessDetailsWSModel(GeneralWSModel general, ProcessDetailsWSDTO processDetails) {
        this.general = general;
        this.processDetails = processDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessDetailsWSDTO getProcessDetails() {
        return processDetails;
    }

    public void setProcessDetails(ProcessDetailsWSDTO processDetails) {
        this.processDetails = processDetails;
    }
}
