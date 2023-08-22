package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;

public class ProcessTempWSModel {

    private GeneralWSModel general;
    private ProcessTempWSDTO processTemps;

    public ProcessTempWSModel() {
    }

    public ProcessTempWSModel(GeneralWSModel general, ProcessTempWSDTO processTemps) {
        this.general = general;
        this.processTemps = processTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessTempWSDTO getProcessTemps() {
        return processTemps;
    }

    public void setProcessTemps(ProcessTempWSDTO processTemps) {
        this.processTemps = processTemps;
    }
}
