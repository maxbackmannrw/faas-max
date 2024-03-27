package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;

import java.util.List;

public class ProcessSmsTempWSModel {

    private GeneralWSModel general;
    private List<ProcessSmsTempWSDTO>processSmsTemps;

    public ProcessSmsTempWSModel() {
    }

    public ProcessSmsTempWSModel(GeneralWSModel general, List<ProcessSmsTempWSDTO> processSmsTemps) {
        this.general = general;
        this.processSmsTemps = processSmsTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessSmsTempWSDTO> getProcessSmsTemps() {
        return processSmsTemps;
    }

    public void setProcessSmsTemps(List<ProcessSmsTempWSDTO> processSmsTemps) {
        this.processSmsTemps = processSmsTemps;
    }
}
