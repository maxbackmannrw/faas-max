package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationWappCallChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationWappCallWSDTO operationWappCall;

    public ApiOperationWappCallChannelWSModel() {
    }

    public ApiOperationWappCallChannelWSModel(GeneralWSModel general, ApiOperationWappCallWSDTO operationWappCall) {
        this.general = general;
        this.operationWappCall = operationWappCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappCallWSDTO getOperationWappCall() {
        return operationWappCall;
    }

    public void setOperationWappCall(ApiOperationWappCallWSDTO operationWappCall) {
        this.operationWappCall = operationWappCall;
    }
}
