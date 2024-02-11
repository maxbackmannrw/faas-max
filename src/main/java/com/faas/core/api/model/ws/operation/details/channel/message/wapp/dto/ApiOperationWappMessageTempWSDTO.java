package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

public class ApiOperationWappMessageTempWSDTO {

    private ProcessWappMessageTempDBModel operationWappMessageTemp;

    public ApiOperationWappMessageTempWSDTO() {
    }

    public ApiOperationWappMessageTempWSDTO(ProcessWappMessageTempDBModel operationWappMessageTemp) {
        this.operationWappMessageTemp = operationWappMessageTemp;
    }

    public ProcessWappMessageTempDBModel getOperationWappMessageTemp() {
        return operationWappMessageTemp;
    }

    public void setOperationWappMessageTemp(ProcessWappMessageTempDBModel operationWappMessageTemp) {
        this.operationWappMessageTemp = operationWappMessageTemp;
    }
}
