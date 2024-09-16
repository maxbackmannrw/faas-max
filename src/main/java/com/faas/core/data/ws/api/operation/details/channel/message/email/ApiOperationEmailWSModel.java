package com.faas.core.data.ws.api.operation.details.channel.message.email;

import com.faas.core.data.ws.api.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ApiOperationEmailWSModel {

    private GeneralWSModel general;
    private List<ApiOperationEmailWSDTO> operationEmails;

    public ApiOperationEmailWSModel() {
    }

    public ApiOperationEmailWSModel(GeneralWSModel general, List<ApiOperationEmailWSDTO> operationEmails) {
        this.general = general;
        this.operationEmails = operationEmails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationEmailWSDTO> getOperationEmails() {
        return operationEmails;
    }

    public void setOperationEmails(List<ApiOperationEmailWSDTO> operationEmails) {
        this.operationEmails = operationEmails;
    }
}
