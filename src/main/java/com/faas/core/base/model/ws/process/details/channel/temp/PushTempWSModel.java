package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.PushTempWSDTO;

import java.util.List;

public class PushTempWSModel {

    private GeneralWSModel general;
    private List<PushTempWSDTO>pushTemps;


    public PushTempWSModel() {
    }

    public PushTempWSModel(GeneralWSModel general, List<PushTempWSDTO> pushTemps) {
        this.general = general;
        this.pushTemps = pushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<PushTempWSDTO> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<PushTempWSDTO> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
