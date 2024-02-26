package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationCurrentSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationCurrentSipCallWSModel {

    private GeneralWSModel general;
    private ApiOperationCurrentSipCallWSDTO currentSipCall;

    public ApiOperationCurrentSipCallWSModel() {
    }

    public ApiOperationCurrentSipCallWSModel(GeneralWSModel general, ApiOperationCurrentSipCallWSDTO currentSipCall) {
        this.general = general;
        this.currentSipCall = currentSipCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationCurrentSipCallWSDTO getCurrentSipCall() {
        return currentSipCall;
    }

    public void setCurrentSipCall(ApiOperationCurrentSipCallWSDTO currentSipCall) {
        this.currentSipCall = currentSipCall;
    }
}
