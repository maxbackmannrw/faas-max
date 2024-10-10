package com.faas.core.api.model.ws.operation.manager.message.email;

import com.faas.core.api.model.ws.operation.manager.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationEmailTempWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailTempWSDTO emailTemp;

    public ApiOperationEmailTempWSModel() {
    }

    public ApiOperationEmailTempWSModel(GeneralWSModel general, ApiOperationEmailTempWSDTO emailTemp) {
        this.general = general;
        this.emailTemp = emailTemp;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationEmailTempWSDTO getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(ApiOperationEmailTempWSDTO emailTemp) {
        this.emailTemp = emailTemp;
    }
}
