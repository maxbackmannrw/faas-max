package com.faas.core.api.model.ws.operation.channel.message.email;

import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationEmailWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailWSDTO operationEmail;

    public ApiOperationEmailWSModel() {
    }

    public ApiOperationEmailWSModel(GeneralWSModel general, ApiOperationEmailWSDTO operationEmail) {
        this.general = general;
        this.operationEmail = operationEmail;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationEmailWSDTO getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(ApiOperationEmailWSDTO operationEmail) {
        this.operationEmail = operationEmail;
    }
}
