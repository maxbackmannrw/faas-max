package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWappMessageTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationWappMessageTempWSDTO> operationWappMessageTemps;

    public ApiOperationWappMessageTempWSModel() {
    }

    public ApiOperationWappMessageTempWSModel(GeneralWSModel general, List<ApiOperationWappMessageTempWSDTO> operationWappMessageTemps) {
        this.general = general;
        this.operationWappMessageTemps = operationWappMessageTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationWappMessageTempWSDTO> getOperationWappMessageTemps() {
        return operationWappMessageTemps;
    }

    public void setOperationWappMessageTemps(List<ApiOperationWappMessageTempWSDTO> operationWappMessageTemps) {
        this.operationWappMessageTemps = operationWappMessageTemps;
    }
}
