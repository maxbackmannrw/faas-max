package com.faas.core.base.model.ws.process.details.channel.temp.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.content.dto.ProcessTempWSDTO;

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
