package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;

public class ApiOperationEmailWSDTO {

    private OperationEmailMessageDBModel operationEmail;

    public ApiOperationEmailWSDTO() {
    }

    public ApiOperationEmailWSDTO(OperationEmailMessageDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }

    public OperationEmailMessageDBModel getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(OperationEmailMessageDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }
}
