package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsTempWSDTO;

import java.util.List;

public class ProcessSmsTempWSModel {

    private GeneralWSModel general;
    private List<ProcessSmsTempWSDTO>smsMessageTemps;


    public ProcessSmsTempWSModel() {
    }

    public ProcessSmsTempWSModel(GeneralWSModel general, List<ProcessSmsTempWSDTO> smsMessageTemps) {
        this.general = general;
        this.smsMessageTemps = smsMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessSmsTempWSDTO> getSmsMessageTemps() {
        return smsMessageTemps;
    }

    public void setSmsMessageTemps(List<ProcessSmsTempWSDTO> smsMessageTemps) {
        this.smsMessageTemps = smsMessageTemps;
    }
}
