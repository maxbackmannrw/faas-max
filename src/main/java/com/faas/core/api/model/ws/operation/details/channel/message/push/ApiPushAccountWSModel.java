package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiPushAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiPushAccountWSModel {

    private GeneralWSModel general;
    private List<ApiPushAccountWSDTO>pushAccounts;

    public ApiPushAccountWSModel() {
    }

    public ApiPushAccountWSModel(GeneralWSModel general, List<ApiPushAccountWSDTO> pushAccounts) {
        this.general = general;
        this.pushAccounts = pushAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiPushAccountWSDTO> getPushAccounts() {
        return pushAccounts;
    }

    public void setPushAccounts(List<ApiPushAccountWSDTO> pushAccounts) {
        this.pushAccounts = pushAccounts;
    }
}
