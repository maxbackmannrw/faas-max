package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationCurrentWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationCurrentWappCallWSModel {

    private GeneralWSModel general;
    private ApiOperationCurrentWappCallWSDTO currentWappCall;

    public ApiOperationCurrentWappCallWSModel() {
    }

    public ApiOperationCurrentWappCallWSModel(GeneralWSModel general, ApiOperationCurrentWappCallWSDTO currentWappCall) {
        this.general = general;
        this.currentWappCall = currentWappCall;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationCurrentWappCallWSDTO getCurrentWappCall() {
        return currentWappCall;
    }

    public void setCurrentWappCall(ApiOperationCurrentWappCallWSDTO currentWappCall) {
        this.currentWappCall = currentWappCall;
    }
}
