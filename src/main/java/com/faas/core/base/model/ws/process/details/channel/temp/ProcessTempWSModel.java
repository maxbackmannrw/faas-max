package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;

public class ProcessTempWSModel {

    private GeneralWSModel general;
    private ProcessTempWSDTO processTemp;

    public ProcessTempWSModel() {
    }

    public ProcessTempWSModel(GeneralWSModel general, ProcessTempWSDTO processTemp) {
        this.general = general;
        this.processTemp = processTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessTempWSDTO getProcessTemp() {
        return processTemp;
    }

    public void setProcessTemp(ProcessTempWSDTO processTemp) {
        this.processTemp = processTemp;
    }
}
