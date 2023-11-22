package com.faas.core.base.model.ws.process.details.trigger;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.EmailTriggerWSDTO;

import java.util.List;

public class EmailTriggerWSModel {

    private GeneralWSModel general;
    private List<EmailTriggerWSDTO>emailTriggers;

    public EmailTriggerWSModel() {
    }

    public EmailTriggerWSModel(GeneralWSModel general, List<EmailTriggerWSDTO> emailTriggers) {
        this.general = general;
        this.emailTriggers = emailTriggers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<EmailTriggerWSDTO> getEmailTriggers() {
        return emailTriggers;
    }

    public void setEmailTriggers(List<EmailTriggerWSDTO> emailTriggers) {
        this.emailTriggers = emailTriggers;
    }
}
