package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiWappMessageAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiWappMessageAccountWSModel {

    private GeneralWSModel general;
    private List<ApiWappMessageAccountWSDTO> wappMessageAccounts;

    public ApiWappMessageAccountWSModel() {
    }

    public ApiWappMessageAccountWSModel(GeneralWSModel general, List<ApiWappMessageAccountWSDTO> wappMessageAccounts) {
        this.general = general;
        this.wappMessageAccounts = wappMessageAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiWappMessageAccountWSDTO> getWappMessageAccounts() {
        return wappMessageAccounts;
    }

    public void setWappMessageAccounts(List<ApiWappMessageAccountWSDTO> wappMessageAccounts) {
        this.wappMessageAccounts = wappMessageAccounts;
    }
}
