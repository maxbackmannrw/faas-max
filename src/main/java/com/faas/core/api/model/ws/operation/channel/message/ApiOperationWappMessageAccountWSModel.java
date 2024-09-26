package com.faas.core.api.model.ws.operation.channel.message;

import com.faas.core.api.model.ws.operation.channel.message.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationWappMessageAccountWSModel {

    private GeneralWSModel general;
    private ApiOperationWappMessageAccountWSDTO wappMessageAccount;

    public ApiOperationWappMessageAccountWSModel() {
    }

    public ApiOperationWappMessageAccountWSModel(GeneralWSModel general, ApiOperationWappMessageAccountWSDTO wappMessageAccount) {
        this.general = general;
        this.wappMessageAccount = wappMessageAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappMessageAccountWSDTO getWappMessageAccount() {
        return wappMessageAccount;
    }

    public void setWappMessageAccount(ApiOperationWappMessageAccountWSDTO wappMessageAccount) {
        this.wappMessageAccount = wappMessageAccount;
    }
}
