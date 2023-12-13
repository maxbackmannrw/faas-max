package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessPushTempWSDTO;

import java.util.List;

public class ProcessPushTempWSModel {

    private GeneralWSModel general;
    private List<ProcessPushTempWSDTO>pushTemps;


    public ProcessPushTempWSModel() {
    }

    public ProcessPushTempWSModel(GeneralWSModel general, List<ProcessPushTempWSDTO> pushTemps) {
        this.general = general;
        this.pushTemps = pushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessPushTempWSDTO> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<ProcessPushTempWSDTO> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
