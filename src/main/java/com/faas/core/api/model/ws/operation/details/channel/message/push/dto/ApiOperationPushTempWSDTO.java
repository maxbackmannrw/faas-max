package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

public class ApiOperationPushTempWSDTO {

    private ProcessPushTempDBModel pushTemp;

    public ApiOperationPushTempWSDTO() {
    }

    public ApiOperationPushTempWSDTO(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }

    public ProcessPushTempDBModel getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }
}
