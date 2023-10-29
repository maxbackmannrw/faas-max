package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationEmailMessageWSDTO;

import java.util.List;

public class OperationEmailMessageWSModel {

    private GeneralWSModel general;
    private List<OperationEmailMessageWSDTO>emailMessages;

    public OperationEmailMessageWSModel() {
    }

    public OperationEmailMessageWSModel(GeneralWSModel general, List<OperationEmailMessageWSDTO> emailMessages) {
        this.general = general;
        this.emailMessages = emailMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationEmailMessageWSDTO> getEmailMessages() {
        return emailMessages;
    }

    public void setEmailMessages(List<OperationEmailMessageWSDTO> emailMessages) {
        this.emailMessages = emailMessages;
    }
}
