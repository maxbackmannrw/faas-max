package com.faas.core.api.model.ws.operation.details.channel.call.content.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;

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
