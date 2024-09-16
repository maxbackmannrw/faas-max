package com.faas.core.data.ws.api.operation.details.channel.message.email;

import com.faas.core.data.ws.api.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class ApiOperationEmailChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailChannelWSDTO operationEmailChannel;

    public ApiOperationEmailChannelWSModel() {
    }

    public ApiOperationEmailChannelWSModel(GeneralWSModel general, ApiOperationEmailChannelWSDTO operationEmailChannel) {
        this.general = general;
        this.operationEmailChannel = operationEmailChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationEmailChannelWSDTO getOperationEmailChannel() {
        return operationEmailChannel;
    }

    public void setOperationEmailChannel(ApiOperationEmailChannelWSDTO operationEmailChannel) {
        this.operationEmailChannel = operationEmailChannel;
    }
}
