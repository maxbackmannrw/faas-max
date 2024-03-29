package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationEmailDBModel;

public class OperationEmailWSDTO {

    private OperationEmailDBModel operationEmail;

    public OperationEmailWSDTO() {
    }

    public OperationEmailWSDTO(OperationEmailDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }

    public OperationEmailDBModel getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(OperationEmailDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }
}
