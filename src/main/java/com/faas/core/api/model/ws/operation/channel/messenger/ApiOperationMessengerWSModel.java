package com.faas.core.api.model.ws.operation.channel.messenger;

import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiOperationMessengerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;



public class ApiOperationMessengerWSModel {

    private GeneralWSModel general;
    private ApiOperationMessengerWSDTO operationMessenger;

    public ApiOperationMessengerWSModel() {
    }

    public ApiOperationMessengerWSModel(GeneralWSModel general, ApiOperationMessengerWSDTO operationMessenger) {
        this.general = general;
        this.operationMessenger = operationMessenger;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationMessengerWSDTO getOperationMessenger() {
        return operationMessenger;
    }

    public void setOperationMessenger(ApiOperationMessengerWSDTO operationMessenger) {
        this.operationMessenger = operationMessenger;
    }
}
