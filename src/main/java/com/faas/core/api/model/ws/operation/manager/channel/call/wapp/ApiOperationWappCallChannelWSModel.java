package com.faas.core.api.model.ws.operation.manager.channel.call.wapp;

import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationWappCallChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationWappCallChannelWSDTO operationWappCallChannel;

    public ApiOperationWappCallChannelWSModel() {
    }

    public ApiOperationWappCallChannelWSModel(GeneralWSModel general, ApiOperationWappCallChannelWSDTO operationWappCallChannel) {
        this.general = general;
        this.operationWappCallChannel = operationWappCallChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappCallChannelWSDTO getOperationWappCallChannel() {
        return operationWappCallChannel;
    }

    public void setOperationWappCallChannel(ApiOperationWappCallChannelWSDTO operationWappCallChannel) {
        this.operationWappCallChannel = operationWappCallChannel;
    }
}
