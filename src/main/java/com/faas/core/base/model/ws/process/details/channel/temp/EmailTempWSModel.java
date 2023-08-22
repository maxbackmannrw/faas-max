package com.faas.core.base.model.ws.process.details.channel.temp;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.EmailTempWSDTO;

import java.util.List;

public class EmailTempWSModel {

    private GeneralWSModel general;
    private List<EmailTempWSDTO>emailTemps;


    public EmailTempWSModel() {
    }

    public EmailTempWSModel(GeneralWSModel general, List<EmailTempWSDTO> emailTemps) {
        this.general = general;
        this.emailTemps = emailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<EmailTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<EmailTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }
}
