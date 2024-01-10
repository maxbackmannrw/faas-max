package com.faas.core.api.model.ws.operation.details.channel.content;

import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationChannelWSDTO operationChannel;

    public ApiOperationChannelWSModel() {
    }

    public ApiOperationChannelWSModel(GeneralWSModel general, ApiOperationChannelWSDTO operationChannel) {
        this.general = general;
        this.operationChannel = operationChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationChannelWSDTO getOperationChannel() {
        return operationChannel;
    }

    public void setOperationChannel(ApiOperationChannelWSDTO operationChannel) {
        this.operationChannel = operationChannel;
    }
}
