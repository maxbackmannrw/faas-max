package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationEmailWSDTO;

import java.util.List;

public class OperationEmailWSModel {

    private GeneralWSModel general;
    private List<OperationEmailWSDTO>operationEmails;

    public OperationEmailWSModel() {
    }

    public OperationEmailWSModel(GeneralWSModel general, List<OperationEmailWSDTO> operationEmails) {
        this.general = general;
        this.operationEmails = operationEmails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationEmailWSDTO> getOperationEmails() {
        return operationEmails;
    }

    public void setOperationEmails(List<OperationEmailWSDTO> operationEmails) {
        this.operationEmails = operationEmails;
    }
}
