package com.faas.core.base.model.ws.channel.settings;

import com.faas.core.base.model.ws.channel.settings.dto.EmailTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class EmailTypeWSModel {

    private GeneralWSModel general;
    private List<EmailTypeWSDTO> emailTypes;

    public EmailTypeWSModel() {
    }

    public EmailTypeWSModel(GeneralWSModel general, List<EmailTypeWSDTO> emailTypes) {
        this.general = general;
        this.emailTypes = emailTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<EmailTypeWSDTO> getEmailTypes() {
        return emailTypes;
    }

    public void setEmailTypes(List<EmailTypeWSDTO> emailTypes) {
        this.emailTypes = emailTypes;
    }
}
