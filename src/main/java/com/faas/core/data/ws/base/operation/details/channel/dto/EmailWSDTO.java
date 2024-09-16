package com.faas.core.data.ws.base.operation.details.channel.dto;

import com.faas.core.data.db.operation.details.channel.OperationEmailDBModel;

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
