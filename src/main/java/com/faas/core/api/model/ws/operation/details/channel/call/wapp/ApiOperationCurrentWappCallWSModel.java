package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationCurrentWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationCurrentWappCallWSModel {

    private GeneralWSModel general;
    private ApiOperationCurrentWappCallWSDTO operationCurrentWappCall;

    public ApiOperationCurrentWappCallWSModel() {
    }

    public ApiOperationCurrentWappCallWSModel(GeneralWSModel general, ApiOperationCurrentWappCallWSDTO operationCurrentWappCall) {
        this.general = general;
        this.operationCurrentWappCall = operationCurrentWappCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationCurrentWappCallWSDTO getOperationCurrentWappCall() {
        return operationCurrentWappCall;
    }

    public void setOperationCurrentWappCall(ApiOperationCurrentWappCallWSDTO operationCurrentWappCall) {
        this.operationCurrentWappCall = operationCurrentWappCall;
    }
}
