package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.SmsMessageTempWSDTO;

import java.util.List;

public class SmsMessageTempWSModel {

    private GeneralWSModel general;
    private List<SmsMessageTempWSDTO>smsMessageTemps;


    public SmsMessageTempWSModel() {
    }

    public SmsMessageTempWSModel(GeneralWSModel general, List<SmsMessageTempWSDTO> smsMessageTemps) {
        this.general = general;
        this.smsMessageTemps = smsMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SmsMessageTempWSDTO> getSmsMessageTemps() {
        return smsMessageTemps;
    }

    public void setSmsMessageTemps(List<SmsMessageTempWSDTO> smsMessageTemps) {
        this.smsMessageTemps = smsMessageTemps;
    }
}
