package com.faas.core.data.ws.api.operation.details.channel.message.email;

import com.faas.core.data.ws.api.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
