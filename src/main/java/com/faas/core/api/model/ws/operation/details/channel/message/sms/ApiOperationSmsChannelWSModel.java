package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationSmsChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsChannelWSDTO smsChannel;

    public ApiOperationSmsChannelWSModel() {
    }

    public ApiOperationSmsChannelWSModel(GeneralWSModel general, ApiOperationSmsChannelWSDTO smsChannel) {
        this.general = general;
        this.smsChannel = smsChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsChannelWSDTO getSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(ApiOperationSmsChannelWSDTO smsChannel) {
        this.smsChannel = smsChannel;
    }
}
