package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationPushTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationPushTempWSDTO>pushTemps;

    public ApiOperationPushTempWSModel() {
    }

    public ApiOperationPushTempWSModel(GeneralWSModel general, List<ApiOperationPushTempWSDTO> pushTemps) {
        this.general = general;
        this.pushTemps = pushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationPushTempWSDTO> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<ApiOperationPushTempWSDTO> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
