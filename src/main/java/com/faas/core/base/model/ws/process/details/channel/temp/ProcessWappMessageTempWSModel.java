package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessWappMessageTempWSDTO;

import java.util.List;

public class ProcessWappMessageTempWSModel {

    private GeneralWSModel general;
    private List<ProcessWappMessageTempWSDTO>wappMessageTemps;


    public ProcessWappMessageTempWSModel() {
    }

    public ProcessWappMessageTempWSModel(GeneralWSModel general, List<ProcessWappMessageTempWSDTO> wappMessageTemps) {
        this.general = general;
        this.wappMessageTemps = wappMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessWappMessageTempWSDTO> getWappMessageTemps() {
        return wappMessageTemps;
    }

    public void setWappMessageTemps(List<ProcessWappMessageTempWSDTO> wappMessageTemps) {
        this.wappMessageTemps = wappMessageTemps;
    }
}
