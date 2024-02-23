package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationActiveWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationActiveWappCallWSModel {

    private GeneralWSModel general;
    private ApiOperationActiveWappCallWSDTO operationActiveWappCall;

    public ApiOperationActiveWappCallWSModel() {
    }

    public ApiOperationActiveWappCallWSModel(GeneralWSModel general, ApiOperationActiveWappCallWSDTO operationActiveWappCall) {
        this.general = general;
        this.operationActiveWappCall = operationActiveWappCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationActiveWappCallWSDTO getOperationActiveWappCall() {
        return operationActiveWappCall;
    }

    public void setOperationActiveWappCall(ApiOperationActiveWappCallWSDTO operationActiveWappCall) {
        this.operationActiveWappCall = operationActiveWappCall;
    }
}
