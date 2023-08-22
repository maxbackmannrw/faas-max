package com.faas.core.api.model.ws.operation.channel.call.sip;

import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSipCallWSModel {

    private GeneralWSModel general;
    private ApiOperationSipCallWSDTO operationSipCall;

    public ApiOperationSipCallWSModel() {
    }

    public ApiOperationSipCallWSModel(GeneralWSModel general, ApiOperationSipCallWSDTO operationSipCall) {
        this.general = general;
        this.operationSipCall = operationSipCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSipCallWSDTO getOperationSipCall() {
        return operationSipCall;
    }

    public void setOperationSipCall(ApiOperationSipCallWSDTO operationSipCall) {
        this.operationSipCall = operationSipCall;
    }
}
