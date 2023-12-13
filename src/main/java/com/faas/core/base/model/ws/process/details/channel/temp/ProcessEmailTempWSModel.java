package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessEmailTempWSDTO;

import java.util.List;

public class ProcessEmailTempWSModel {

    private GeneralWSModel general;
    private List<ProcessEmailTempWSDTO>emailTemps;


    public ProcessEmailTempWSModel() {
    }

    public ProcessEmailTempWSModel(GeneralWSModel general, List<ProcessEmailTempWSDTO> emailTemps) {
        this.general = general;
        this.emailTemps = emailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessEmailTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<ProcessEmailTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }
}
