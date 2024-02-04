package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSipChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationSipChannelWSDTO sipChannel;

    public ApiOperationSipChannelWSModel() {
    }

    public ApiOperationSipChannelWSModel(GeneralWSModel general, ApiOperationSipChannelWSDTO sipChannel) {
        this.general = general;
        this.sipChannel = sipChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSipChannelWSDTO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(ApiOperationSipChannelWSDTO sipChannel) {
        this.sipChannel = sipChannel;
    }
}
