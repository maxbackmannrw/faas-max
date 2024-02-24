package com.faas.core.base.model.ws.process.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;

import java.util.List;

public class ProcessWSModel {

    private GeneralWSModel general;
    private List<ProcessWSDTO> processes;

    public ProcessWSModel() {
    }

    public ProcessWSModel(GeneralWSModel general, List<ProcessWSDTO> processes) {
        this.general = general;
        this.processes = processes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessWSDTO> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ProcessWSDTO> processes) {
        this.processes = processes;
    }
}
