package com.faas.core.api.model.ws.operation.details.channel.message.email.dto;

import com.faas.core.data.db.operation.details.channel.OperationEmailDBModel;

public class ApiOperationEmailWSDTO {

    private OperationEmailDBModel operationEmail;

    public ApiOperationEmailWSDTO() {
    }

    public ApiOperationEmailWSDTO(OperationEmailDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }

    public OperationEmailDBModel getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(OperationEmailDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }
}
