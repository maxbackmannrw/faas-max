package com.faas.core.data.ws.api.operation.details.channel.message.push;

import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


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
