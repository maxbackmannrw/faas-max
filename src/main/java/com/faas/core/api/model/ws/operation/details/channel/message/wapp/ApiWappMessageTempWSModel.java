package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiWappMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiWappMessageTempWSModel {

    private GeneralWSModel general;
    private ApiWappMessageTempWSDTO wappMessageTemp;

    public ApiWappMessageTempWSModel() {
    }

    public ApiWappMessageTempWSModel(GeneralWSModel general, ApiWappMessageTempWSDTO wappMessageTemp) {
        this.general = general;
        this.wappMessageTemp = wappMessageTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiWappMessageTempWSDTO getWappMessageTemp() {
        return wappMessageTemp;
    }

    public void setWappMessageTemp(ApiWappMessageTempWSDTO wappMessageTemp) {
        this.wappMessageTemp = wappMessageTemp;
    }
}
