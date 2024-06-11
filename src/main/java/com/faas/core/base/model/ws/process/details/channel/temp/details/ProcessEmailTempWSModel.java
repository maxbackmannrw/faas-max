package com.faas.core.base.model.ws.process.details.channel.temp.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessEmailTempWSDTO;

import java.util.List;

public class ProcessEmailTempWSModel {

    private GeneralWSModel general;
    private List<ProcessEmailTempWSDTO>processEmailTemps;

    public ProcessEmailTempWSModel() {
    }

    public ProcessEmailTempWSModel(GeneralWSModel general, List<ProcessEmailTempWSDTO> processEmailTemps) {
        this.general = general;
        this.processEmailTemps = processEmailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessEmailTempWSDTO> getProcessEmailTemps() {
        return processEmailTemps;
    }

    public void setProcessEmailTemps(List<ProcessEmailTempWSDTO> processEmailTemps) {
        this.processEmailTemps = processEmailTemps;
    }
}
