package com.faas.core.api.model.ws.operation.details.channel.call.content.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;

public class ApiOperationCallChannelWSDTO {

    private ApiOperationSipChannelWSDTO sipChannel;
    private ApiOperationWappCallChannelWSDTO wappCallChannel;

    public ApiOperationCallChannelWSDTO() {
    }

    public ApiOperationCallChannelWSDTO(ApiOperationSipChannelWSDTO sipChannel, ApiOperationWappCallChannelWSDTO wappCallChannel) {
        this.sipChannel = sipChannel;
        this.wappCallChannel = wappCallChannel;
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
}
