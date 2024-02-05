package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationSmsTempWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsTempWSDTO smsMessageTemp;

    public ApiOperationSmsTempWSModel() {
    }

    public ApiOperationSmsTempWSModel(GeneralWSModel general, ApiOperationSmsTempWSDTO smsMessageTemp) {
        this.general = general;
        this.smsMessageTemp = smsMessageTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsTempWSDTO getSmsMessageTemp() {
        return smsMessageTemp;
    }

    public void setSmsMessageTemp(ApiOperationSmsTempWSDTO smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }
}
