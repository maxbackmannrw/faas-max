package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsMessageTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiSmsMessageTempWSModel {

    private GeneralWSModel general;
    private ApiSmsMessageTempWSDTO smsMessageTemp;

    public ApiSmsMessageTempWSModel() {
    }

    public ApiSmsMessageTempWSModel(GeneralWSModel general, ApiSmsMessageTempWSDTO smsMessageTemp) {
        this.general = general;
        this.smsMessageTemp = smsMessageTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiSmsMessageTempWSDTO getSmsMessageTemp() {
        return smsMessageTemp;
    }

    public void setSmsMessageTemp(ApiSmsMessageTempWSDTO smsMessageTemp) {
        this.smsMessageTemp = smsMessageTemp;
    }
}
