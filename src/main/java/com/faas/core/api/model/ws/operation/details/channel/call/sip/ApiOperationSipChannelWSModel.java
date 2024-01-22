package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSipChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationSipCallWSDTO operationSipCall;

    public ApiOperationSipChannelWSModel() {
    }

    public ApiOperationSipChannelWSModel(GeneralWSModel general, ApiOperationSipCallWSDTO operationSipCall) {
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
