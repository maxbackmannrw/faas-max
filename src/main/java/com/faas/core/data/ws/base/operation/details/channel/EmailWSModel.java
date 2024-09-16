package com.faas.core.data.ws.base.operation.details.channel;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.operation.details.channel.dto.EmailWSDTO;

import java.util.List;

public class EmailWSModel {

    private GeneralWSModel general;
    private List<EmailWSDTO> operationEmails;

    public EmailWSModel() {
    }

    public EmailWSModel(GeneralWSModel general, List<EmailWSDTO> operationEmails) {
        this.general = general;
        this.operationEmails = operationEmails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<EmailWSDTO> getOperationEmails() {
        return operationEmails;
    }

    public void setOperationEmails(List<EmailWSDTO> operationEmails) {
        this.operationEmails = operationEmails;
    }
}
