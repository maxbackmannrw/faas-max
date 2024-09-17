package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationSmsTempWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsTempWSDTO smsTemp;

    public ApiOperationSmsTempWSModel() {
    }

    public ApiOperationSmsTempWSModel(GeneralWSModel general, ApiOperationSmsTempWSDTO smsTemp) {
        this.general = general;
        this.smsTemp = smsTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsTempWSDTO getSmsTemp() {
        return smsTemp;
    }

    public void setSmsTemp(ApiOperationSmsTempWSDTO smsTemp) {
        this.smsTemp = smsTemp;
    }
}
