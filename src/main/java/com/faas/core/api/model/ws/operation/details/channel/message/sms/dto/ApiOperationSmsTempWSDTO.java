package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

public class ApiOperationSmsTempWSDTO {

    private ProcessSmsMessageTempDBModel operationSmsTemp;

    public ApiOperationSmsTempWSDTO() {
    }

    public ApiOperationSmsTempWSDTO(ProcessSmsMessageTempDBModel operationSmsTemp) {
        this.operationSmsTemp = operationSmsTemp;
    }

    public ProcessSmsMessageTempDBModel getOperationSmsTemp() {
        return operationSmsTemp;
    }

    public void setOperationSmsTemp(ProcessSmsMessageTempDBModel operationSmsTemp) {
        this.operationSmsTemp = operationSmsTemp;
    }
}
