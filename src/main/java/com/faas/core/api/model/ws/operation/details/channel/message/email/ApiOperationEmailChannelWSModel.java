package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationEmailChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailWSDTO operationEmail;

    public ApiOperationEmailChannelWSModel() {
    }

    public ApiOperationEmailChannelWSModel(GeneralWSModel general, ApiOperationEmailWSDTO operationEmail) {
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
