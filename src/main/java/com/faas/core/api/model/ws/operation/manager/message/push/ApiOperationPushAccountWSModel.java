package com.faas.core.api.model.ws.operation.manager.message.push;

import com.faas.core.api.model.ws.operation.manager.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationPushAccountWSModel {

    private GeneralWSModel general;
    private ApiOperationPushAccountWSDTO pushAccount;

    public ApiOperationPushAccountWSModel() {
    }

    public ApiOperationPushAccountWSModel(GeneralWSModel general, ApiOperationPushAccountWSDTO pushAccount) {
        this.general = general;
        this.pushAccount = pushAccount;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPushAccountWSDTO getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(ApiOperationPushAccountWSDTO pushAccount) {
        this.pushAccount = pushAccount;
    }
}
