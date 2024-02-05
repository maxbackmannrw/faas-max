package com.faas.core.api.model.ws.operation.details.channel.call.sip;

import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiSipAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiSipAccountWSModel {

    private GeneralWSModel general;
    private List<ApiSipAccountWSDTO>sipAccounts;

    public ApiSipAccountWSModel() {
    }

    public ApiSipAccountWSModel(GeneralWSModel general, List<ApiSipAccountWSDTO> sipAccounts) {
        this.general = general;
        this.sipAccounts = sipAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSipAccountWSDTO> getSipAccounts() {
        return sipAccounts;
    }

    public void setSipAccounts(List<ApiSipAccountWSDTO> sipAccounts) {
        this.sipAccounts = sipAccounts;
    }
}
