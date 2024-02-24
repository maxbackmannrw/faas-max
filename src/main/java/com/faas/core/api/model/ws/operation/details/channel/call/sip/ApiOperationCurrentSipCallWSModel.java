package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationCurrentSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationCurrentSipCallWSModel {

    private GeneralWSModel general;
    private ApiOperationCurrentSipCallWSDTO operationCurrentSipCall;

    public ApiOperationCurrentSipCallWSModel() {
    }

    public ApiOperationCurrentSipCallWSModel(GeneralWSModel general, ApiOperationCurrentSipCallWSDTO operationCurrentSipCall) {
        this.general = general;
        this.operationCurrentSipCall = operationCurrentSipCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationCurrentSipCallWSDTO getOperationCurrentSipCall() {
        return operationCurrentSipCall;
    }

    public void setOperationCurrentSipCall(ApiOperationCurrentSipCallWSDTO operationCurrentSipCall) {
        this.operationCurrentSipCall = operationCurrentSipCall;
    }
}
