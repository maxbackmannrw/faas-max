package com.faas.core.api.model.ws.operation.manager.message.sms;

import com.faas.core.api.model.ws.operation.manager.message.sms.dto.ApiOperationSmsAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
