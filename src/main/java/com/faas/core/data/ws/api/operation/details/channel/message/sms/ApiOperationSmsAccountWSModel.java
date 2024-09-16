package com.faas.core.data.ws.api.operation.details.channel.message.sms;

import com.faas.core.data.ws.api.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class ApiOperationSmsAccountWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsAccountWSDTO smsAccount;

    public ApiOperationSmsAccountWSModel() {
    }

    public ApiOperationSmsAccountWSModel(GeneralWSModel general, ApiOperationSmsAccountWSDTO smsAccount) {
        this.general = general;
        this.smsAccount = smsAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsAccountWSDTO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ApiOperationSmsAccountWSDTO smsAccount) {
        this.smsAccount = smsAccount;
    }
}
