package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationPushTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationPushTempWSDTO>operationPushTemps;

    public ApiOperationPushTempWSModel() {
    }

    public ApiOperationPushTempWSModel(GeneralWSModel general, List<ApiOperationPushTempWSDTO> operationPushTemps) {
        this.general = general;
        this.operationPushTemps = operationPushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationPushTempWSDTO> getOperationPushTemps() {
        return operationPushTemps;
    }

    public void setOperationPushTemps(List<ApiOperationPushTempWSDTO> operationPushTemps) {
        this.operationPushTemps = operationPushTemps;
    }
}
