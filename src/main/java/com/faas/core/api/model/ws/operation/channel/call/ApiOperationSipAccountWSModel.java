package com.faas.core.api.model.ws.operation.channel.call;

import com.faas.core.api.model.ws.operation.channel.call.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSipAccountWSModel {

    private GeneralWSModel general;
    private ApiOperationSipAccountWSDTO sipAccount;

    public ApiOperationSipAccountWSModel() {
    }

    public ApiOperationSipAccountWSModel(GeneralWSModel general, ApiOperationSipAccountWSDTO sipAccount) {
        this.general = general;
        this.sipAccount = sipAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSipAccountWSDTO getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(ApiOperationSipAccountWSDTO sipAccount) {
        this.sipAccount = sipAccount;
    }
}
