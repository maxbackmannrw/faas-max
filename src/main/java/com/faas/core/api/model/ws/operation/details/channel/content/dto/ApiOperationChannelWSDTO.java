package com.faas.core.api.model.ws.operation.details.channel.content.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;

public class ApiOperationChannelWSDTO {

    private ApiOperationSipChannelWSDTO operationSipChannel;
    private ApiOperationWappCallChannelWSDTO operationWappCallChannel;
    private ApiOperationSmsChannelWSDTO operationSmsChannel;
    private ApiOperationWappMessageChannelWSDTO operationWappMessageChannel;
    private ApiOperationPushChannelWSDTO operationPushChannel;
    private ApiOperationEmailChannelWSDTO operationEmailChannel;

    public ApiOperationChannelWSDTO() {
    }

    public ApiOperationChannelWSDTO(ApiOperationSipChannelWSDTO operationSipChannel, ApiOperationWappCallChannelWSDTO operationWappCallChannel, ApiOperationSmsChannelWSDTO operationSmsChannel, ApiOperationWappMessageChannelWSDTO operationWappMessageChannel, ApiOperationPushChannelWSDTO operationPushChannel, ApiOperationEmailChannelWSDTO operationEmailChannel) {
        this.operationSipChannel = operationSipChannel;
        this.operationWappCallChannel = operationWappCallChannel;
        this.operationSmsChannel = operationSmsChannel;
        this.operationWappMessageChannel = operationWappMessageChannel;
        this.operationPushChannel = operationPushChannel;
        this.operationEmailChannel = operationEmailChannel;
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

    public ApiOperationPushChannelWSDTO getOperationPushChannel() {
        return operationPushChannel;
    }

    public void setOperationPushChannel(ApiOperationPushChannelWSDTO operationPushChannel) {
        this.operationPushChannel = operationPushChannel;
    }

    public ApiOperationEmailChannelWSDTO getOperationEmailChannel() {
        return operationEmailChannel;
    }

    public void setOperationEmailChannel(ApiOperationEmailChannelWSDTO operationEmailChannel) {
        this.operationEmailChannel = operationEmailChannel;
    }
}
