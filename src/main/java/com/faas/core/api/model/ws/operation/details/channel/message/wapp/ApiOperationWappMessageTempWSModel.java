package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWappMessageTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationWappMessageTempWSDTO> wappMessageTemps;

    public ApiOperationWappMessageTempWSModel() {
    }

    public ApiOperationWappMessageTempWSModel(GeneralWSModel general, List<ApiOperationWappMessageTempWSDTO> wappMessageTemps) {
        this.general = general;
        this.wappMessageTemps = wappMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationWappMessageTempWSDTO> getWappMessageTemps() {
        return wappMessageTemps;
    }

    public void setWappMessageTemps(List<ApiOperationWappMessageTempWSDTO> wappMessageTemps) {
        this.wappMessageTemps = wappMessageTemps;
    }
}
