package com.faas.core.api.model.ws.operation.channel.content.dto;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiOperationPushMessageWSDTO;

public class ApiOperationChannelWSDTO {

    private ApiOperationSipCallWSDTO operationSipCall;
    private ApiOperationWappCallWSDTO operationWappCall;
    private ApiOperationSmsMessageWSDTO operationSmsMessage;
    private ApiOperationWappMessageWSDTO operationWappMessage;
    private ApiOperationPushMessageWSDTO operationPushMessage;
    private ApiOperationEmailWSDTO operationEmail;

    public ApiOperationChannelWSDTO() {
    }

    public ApiOperationChannelWSDTO(ApiOperationSipCallWSDTO operationSipCall, ApiOperationWappCallWSDTO operationWappCall, ApiOperationSmsMessageWSDTO operationSmsMessage, ApiOperationWappMessageWSDTO operationWappMessage, ApiOperationPushMessageWSDTO operationPushMessage, ApiOperationEmailWSDTO operationEmail) {
        this.operationSipCall = operationSipCall;
        this.operationWappCall = operationWappCall;
        this.operationSmsMessage = operationSmsMessage;
        this.operationWappMessage = operationWappMessage;
        this.operationPushMessage = operationPushMessage;
        this.operationEmail = operationEmail;
    }

    public ApiOperationSipCallWSDTO getOperationSipCall() {
        return operationSipCall;
    }

    public void setOperationSipCall(ApiOperationSipCallWSDTO operationSipCall) {
        this.operationSipCall = operationSipCall;
    }

    public ApiOperationWappCallWSDTO getOperationWappCall() {
        return operationWappCall;
    }

    public void setOperationWappCall(ApiOperationWappCallWSDTO operationWappCall) {
        this.operationWappCall = operationWappCall;
    }

    public ApiOperationSmsMessageWSDTO getOperationSmsMessage() {
        return operationSmsMessage;
    }

    public void setOperationSmsMessage(ApiOperationSmsMessageWSDTO operationSmsMessage) {
        this.operationSmsMessage = operationSmsMessage;
    }

    public ApiOperationWappMessageWSDTO getOperationWappMessage() {
        return operationWappMessage;
    }

    public void setOperationWappMessage(ApiOperationWappMessageWSDTO operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }

    public ApiOperationPushMessageWSDTO getOperationPushMessage() {
        return operationPushMessage;
    }

    public void setOperationPushMessage(ApiOperationPushMessageWSDTO operationPushMessage) {
        this.operationPushMessage = operationPushMessage;
    }

    public ApiOperationEmailWSDTO getOperationEmail() {
        return operationEmail;
    }

    public void setOperationEmail(ApiOperationEmailWSDTO operationEmail) {
        this.operationEmail = operationEmail;
    }
}
