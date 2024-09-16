package com.faas.core.data.ws.api.operation.details.channel.content.dto;

import com.faas.core.data.ws.api.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;

public class ApiOperationMessageChannelWSDTO {

    private ApiOperationSmsChannelWSDTO operationSmsChannel;
    private ApiOperationWappMessageChannelWSDTO operationWappMessageChannel;
    private ApiOperationEmailChannelWSDTO operationEmailChannel;
    private ApiOperationPushChannelWSDTO operationPushChannel;

    public ApiOperationMessageChannelWSDTO() {
    }

    public ApiOperationMessageChannelWSDTO(ApiOperationSmsChannelWSDTO operationSmsChannel, ApiOperationWappMessageChannelWSDTO operationWappMessageChannel, ApiOperationEmailChannelWSDTO operationEmailChannel, ApiOperationPushChannelWSDTO operationPushChannel) {
        this.operationSmsChannel = operationSmsChannel;
        this.operationWappMessageChannel = operationWappMessageChannel;
        this.operationEmailChannel = operationEmailChannel;
        this.operationPushChannel = operationPushChannel;
    }

    public ApiOperationSmsChannelWSDTO getOperationSmsChannel() {
        return operationSmsChannel;
    }

    public void setOperationSmsChannel(ApiOperationSmsChannelWSDTO operationSmsChannel) {
        this.operationSmsChannel = operationSmsChannel;
    }

    public ApiOperationWappMessageChannelWSDTO getOperationWappMessageChannel() {
        return operationWappMessageChannel;
    }

    public void setOperationWappMessageChannel(ApiOperationWappMessageChannelWSDTO operationWappMessageChannel) {
        this.operationWappMessageChannel = operationWappMessageChannel;
    }

    public ApiOperationEmailChannelWSDTO getOperationEmailChannel() {
        return operationEmailChannel;
    }

    public void setOperationEmailChannel(ApiOperationEmailChannelWSDTO operationEmailChannel) {
        this.operationEmailChannel = operationEmailChannel;
    }

    public ApiOperationPushChannelWSDTO getOperationPushChannel() {
        return operationPushChannel;
    }

    public void setOperationPushChannel(ApiOperationPushChannelWSDTO operationPushChannel) {
        this.operationPushChannel = operationPushChannel;
    }
}
