package com.faas.core.api.model.ws.operation.details.channel.content;

import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationCallChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationCallChannelWSDTO operationCallChannel;

    public ApiOperationCallChannelWSModel() {
    }

    public ApiOperationCallChannelWSModel(GeneralWSModel general, ApiOperationCallChannelWSDTO operationCallChannel) {
        this.general = general;
        this.operationCallChannel = operationCallChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationCallChannelWSDTO getOperationCallChannel() {
        return operationCallChannel;
    }

    public void setOperationCallChannel(ApiOperationCallChannelWSDTO operationCallChannel) {
        this.operationCallChannel = operationCallChannel;
    }
}
