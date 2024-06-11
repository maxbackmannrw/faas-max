package com.faas.core.base.model.ws.process.details.channel.temp.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessWappMessageTempWSDTO;

import java.util.List;

public class ProcessWappMessageTempWSModel {

    private GeneralWSModel general;
    private List<ProcessWappMessageTempWSDTO>processWappMessageTemps;

    public ProcessWappMessageTempWSModel() {
    }

    public ProcessWappMessageTempWSModel(GeneralWSModel general, List<ProcessWappMessageTempWSDTO> processWappMessageTemps) {
        this.general = general;
        this.processWappMessageTemps = processWappMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessWappMessageTempWSDTO> getProcessWappMessageTemps() {
        return processWappMessageTemps;
    }

    public void setProcessWappMessageTemps(List<ProcessWappMessageTempWSDTO> processWappMessageTemps) {
        this.processWappMessageTemps = processWappMessageTemps;
    }
}
