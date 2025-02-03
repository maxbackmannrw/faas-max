package com.faas.core.api.model.ws.operation.manager.channel.message.push;

import com.faas.core.api.model.ws.operation.manager.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationPushTempWSModel {

    private GeneralWSModel general;
    private ApiOperationPushTempWSDTO pushTemp;

    public ApiOperationPushTempWSModel() {
    }

    public ApiOperationPushTempWSModel(GeneralWSModel general, ApiOperationPushTempWSDTO pushTemp) {
        this.general = general;
        this.pushTemp = pushTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPushTempWSDTO getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(ApiOperationPushTempWSDTO pushTemp) {
        this.pushTemp = pushTemp;
    }
}
