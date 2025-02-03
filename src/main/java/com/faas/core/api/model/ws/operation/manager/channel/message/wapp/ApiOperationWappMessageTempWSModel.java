package com.faas.core.api.model.ws.operation.manager.channel.message.wapp;

import com.faas.core.api.model.ws.operation.manager.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationWappMessageTempWSModel {

    private GeneralWSModel general;
    private ApiOperationWappMessageTempWSDTO wappMessageTemp;

    public ApiOperationWappMessageTempWSModel() {
    }

    public ApiOperationWappMessageTempWSModel(GeneralWSModel general, ApiOperationWappMessageTempWSDTO wappMessageTemp) {
        this.general = general;
        this.wappMessageTemp = wappMessageTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappMessageTempWSDTO getWappMessageTemp() {
        return wappMessageTemp;
    }

    public void setWappMessageTemp(ApiOperationWappMessageTempWSDTO wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }
}
