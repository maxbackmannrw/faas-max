package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationEmailDBModel;

public class EmailWSDTO {

    private OperationEmailDBModel operationEmail;

    public EmailWSDTO() {
    }

    public EmailWSDTO(OperationEmailDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }

    public OperationEmailDBModel getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(OperationEmailDBModel operationEmail) {
        this.operationEmail = operationEmail;
    }
}
