package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;

import java.util.List;

public class ProcessPushTempWSModel {

    private GeneralWSModel general;
    private List<ProcessPushTempWSDTO>processPushTemps;

    public ProcessPushTempWSModel() {
    }

    public ProcessPushTempWSModel(GeneralWSModel general, List<ProcessPushTempWSDTO> processPushTemps) {
        this.general = general;
        this.processPushTemps = processPushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessPushTempWSDTO> getProcessPushTemps() {
        return processPushTemps;
    }

    public void setProcessPushTemps(List<ProcessPushTempWSDTO> processPushTemps) {
        this.processPushTemps = processPushTemps;
    }
}
