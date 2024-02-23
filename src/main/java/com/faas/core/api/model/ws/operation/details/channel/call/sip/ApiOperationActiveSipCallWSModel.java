package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationActiveSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationActiveSipCallWSModel {

    private GeneralWSModel general;
    private ApiOperationActiveSipCallWSDTO operationActiveSipCall;

    public ApiOperationActiveSipCallWSModel() {
    }

    public ApiOperationActiveSipCallWSModel(GeneralWSModel general, ApiOperationActiveSipCallWSDTO operationActiveSipCall) {
        this.general = general;
        this.operationActiveSipCall = operationActiveSipCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationActiveSipCallWSDTO getOperationActiveSipCall() {
        return operationActiveSipCall;
    }

    public void setOperationActiveSipCall(ApiOperationActiveSipCallWSDTO operationActiveSipCall) {
        this.operationActiveSipCall = operationActiveSipCall;
    }
}
