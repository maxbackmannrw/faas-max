package com.faas.core.base.model.ws.process.details.trigger.temp.email;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.email.dto.EmailTriggerTempWSDTO;

import java.util.List;

public class EmailTriggerTempWSModel {

    private GeneralWSModel general;
    private List<EmailTriggerTempWSDTO>emailTriggerTemps;

    public EmailTriggerTempWSModel() {
    }

    public EmailTriggerTempWSModel(List<EmailTriggerTempWSDTO> emailTriggerTemps, GeneralWSModel general) {
        this.emailTriggerTemps = emailTriggerTemps;
        this.general = general;
    }

    public List<EmailTriggerTempWSDTO> getEmailTriggerTemps() {
        return emailTriggerTemps;
    }

    public void setEmailTriggerTemps(List<EmailTriggerTempWSDTO> emailTriggerTemps) {
        this.emailTriggerTemps = emailTriggerTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }
}
