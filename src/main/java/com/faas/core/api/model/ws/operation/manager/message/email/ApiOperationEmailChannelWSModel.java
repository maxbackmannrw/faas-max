package com.faas.core.api.model.ws.operation.manager.message.email;

import com.faas.core.api.model.ws.operation.manager.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
