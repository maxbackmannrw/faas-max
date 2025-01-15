package com.faas.core.api.model.ws.operation.manager.call.content.dto;

import com.faas.core.api.model.ws.operation.manager.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.call.wapp.dto.ApiOperationWappCallChannelWSDTO;

public class ApiOperationCallChannelWSDTO {

    private ApiOperationSipChannelWSDTO operationSipChannel;
    private ApiOperationWappCallChannelWSDTO operationWappCallChannel;

    public ApiOperationCallChannelWSDTO() {
    }

    public ApiOperationCallChannelWSDTO(ApiOperationSipChannelWSDTO operationSipChannel, ApiOperationWappCallChannelWSDTO operationWappCallChannel) {
        this.operationSipChannel = operationSipChannel;
        this.operationWappCallChannel = operationWappCallChannel;
    }

    public ApiOperationSipChannelWSDTO getOperationSipChannel() {
        return operationSipChannel;
    }

    public void setOperationSipChannel(ApiOperationSipChannelWSDTO operationSipChannel) {
        this.operationSipChannel = operationSipChannel;
    }

    public ApiOperationWappCallChannelWSDTO getOperationWappCallChannel() {
        return operationWappCallChannel;
    }

    public void setOperationWappCallChannel(ApiOperationWappCallChannelWSDTO operationWappCallChannel) {
        this.operationWappCallChannel = operationWappCallChannel;
    }
}
