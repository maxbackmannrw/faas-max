package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.WappMessageTempWSDTO;

import java.util.List;

public class WappMessageTempWSModel {

    private GeneralWSModel general;
    private List<WappMessageTempWSDTO>wappMessageTemps;


    public WappMessageTempWSModel() {
    }

    public WappMessageTempWSModel(GeneralWSModel general, List<WappMessageTempWSDTO> wappMessageTemps) {
        this.general = general;
        this.wappMessageTemps = wappMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappMessageTempWSDTO> getWappMessageTemps() {
        return wappMessageTemps;
    }

    public void setWappMessageTemps(List<WappMessageTempWSDTO> wappMessageTemps) {
        this.wappMessageTemps = wappMessageTemps;
    }
}
