package com.faas.core.data.ws.api.operation.details.channel.message.wapp;

import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


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
