package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationWappCallChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationWappCallChannelWSDTO wappCallChannel;

    public ApiOperationWappCallChannelWSModel() {
    }

    public ApiOperationWappCallChannelWSModel(GeneralWSModel general, ApiOperationWappCallChannelWSDTO wappCallChannel) {
        this.general = general;
        this.wappCallChannel = wappCallChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappCallChannelWSDTO getWappCallChannel() {
        return wappCallChannel;
    }

    public void setWappCallChannel(ApiOperationWappCallChannelWSDTO wappCallChannel) {
        this.wappCallChannel = wappCallChannel;
    }
}
