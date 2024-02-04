package com.faas.core.api.model.ws.operation.details.channel.content.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;

public class ApiOperationChannelWSDTO {

    private ApiOperationSipChannelWSDTO sipChannel;
    private ApiOperationWappCallChannelWSDTO wappCallChannel;
    private ApiOperationSmsChannelWSDTO smsChannel;
    private ApiOperationWappMessageChannelWSDTO wappMessageChannel;
    private ApiOperationEmailChannelWSDTO emailChannel;
    private ApiOperationPushChannelWSDTO pushChannel;

    public ApiOperationChannelWSDTO() {
    }

    public ApiOperationChannelWSDTO(ApiOperationSipChannelWSDTO sipChannel, ApiOperationWappCallChannelWSDTO wappCallChannel, ApiOperationSmsChannelWSDTO smsChannel, ApiOperationWappMessageChannelWSDTO wappMessageChannel, ApiOperationEmailChannelWSDTO emailChannel, ApiOperationPushChannelWSDTO pushChannel) {
        this.sipChannel = sipChannel;
        this.wappCallChannel = wappCallChannel;
        this.smsChannel = smsChannel;
        this.wappMessageChannel = wappMessageChannel;
        this.emailChannel = emailChannel;
        this.pushChannel = pushChannel;
    }

    public ApiOperationSipChannelWSDTO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(ApiOperationSipChannelWSDTO sipChannel) {
        this.sipChannel = sipChannel;
    }

    public ApiOperationWappCallChannelWSDTO getWappCallChannel() {
        return wappCallChannel;
    }

    public void setWappCallChannel(ApiOperationWappCallChannelWSDTO wappCallChannel) {
        this.wappCallChannel = wappCallChannel;
    }

    public ApiOperationSmsChannelWSDTO getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(ApiOperationSmsChannelWSDTO smsChannel) {
        this.smsChannel = smsChannel;
    }

    public ApiOperationWappMessageChannelWSDTO getWappMessageChannel() {
        return wappMessageChannel;
    }

    public void setWappMessageChannel(ApiOperationWappMessageChannelWSDTO wappMessageChannel) {
        this.wappMessageChannel = wappMessageChannel;
    }

    public ApiOperationEmailChannelWSDTO getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(ApiOperationEmailChannelWSDTO emailChannel) {
        this.emailChannel = emailChannel;
    }

    public ApiOperationPushChannelWSDTO getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(ApiOperationPushChannelWSDTO pushChannel) {
        this.pushChannel = pushChannel;
    }
}
