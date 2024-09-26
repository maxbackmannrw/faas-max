package com.faas.core.api.model.ws.operation.manager.channel.message;

import com.faas.core.api.model.ws.operation.manager.channel.message.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationEmailAccountWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailAccountWSDTO emailAccount;

    public ApiOperationEmailAccountWSModel() {
    }

    public ApiOperationEmailAccountWSModel(GeneralWSModel general, ApiOperationEmailAccountWSDTO emailAccount) {
        this.general = general;
        this.emailAccount = emailAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationEmailAccountWSDTO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ApiOperationEmailAccountWSDTO emailAccount) {
        this.emailAccount = emailAccount;
    }
}
