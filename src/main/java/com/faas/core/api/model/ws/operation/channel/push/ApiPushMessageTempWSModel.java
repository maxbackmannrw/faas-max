package com.faas.core.api.model.ws.operation.channel.push;

import com.faas.core.api.model.ws.operation.channel.push.dto.ApiPushMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiPushMessageTempWSModel {

    private GeneralWSModel general;
    private List<ApiPushMessageTempWSDTO>pushTemps;

    public ApiPushMessageTempWSModel() {
    }

    public ApiPushMessageTempWSModel(GeneralWSModel general, List<ApiPushMessageTempWSDTO> pushTemps) {
        this.general = general;
        this.pushTemps = pushTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiPushMessageTempWSDTO> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<ApiPushMessageTempWSDTO> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
