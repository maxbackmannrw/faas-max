package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessSmsMessageTempWSDTO;

import java.util.List;

public class ProcessSmsMessageTempWSModel {

    private GeneralWSModel general;
    private List<ProcessSmsMessageTempWSDTO>smsMessageTemps;


    public ProcessSmsMessageTempWSModel() {
    }

    public ProcessSmsMessageTempWSModel(GeneralWSModel general, List<ProcessSmsMessageTempWSDTO> smsMessageTemps) {
        this.general = general;
        this.smsMessageTemps = smsMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessSmsMessageTempWSDTO> getSmsMessageTemps() {
        return smsMessageTemps;
    }

    public void setSmsMessageTemps(List<ProcessSmsMessageTempWSDTO> smsMessageTemps) {
        this.smsMessageTemps = smsMessageTemps;
    }
}
