package com.faas.core.base.model.ws.operation.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.channel.dto.EmailMessageWSDTO;

import java.util.List;

public class EmailMessageWSModel {

    private GeneralWSModel general;
    private List<EmailMessageWSDTO>emailMessages;

    public EmailMessageWSModel() {
    }

    public EmailMessageWSModel(GeneralWSModel general, List<EmailMessageWSDTO> emailMessages) {
        this.general = general;
        this.emailMessages = emailMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<EmailMessageWSDTO> getEmailMessages() {
        return emailMessages;
    }

    public void setEmailMessages(List<EmailMessageWSDTO> emailMessages) {
        this.emailMessages = emailMessages;
    }
}
