package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiWappCallAccountWSModel {

    private GeneralWSModel general;
    private List<ApiWappCallAccountWSDTO> wappCallAccounts;

    public ApiWappCallAccountWSModel() {
    }

    public ApiWappCallAccountWSModel(GeneralWSModel general, List<ApiWappCallAccountWSDTO> wappCallAccounts) {
        this.general = general;
        this.wappCallAccounts = wappCallAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiWappCallAccountWSDTO> getWappCallAccounts() {
        return wappCallAccounts;
    }

    public void setWappCallAccounts(List<ApiWappCallAccountWSDTO> wappCallAccounts) {
        this.wappCallAccounts = wappCallAccounts;
    }
}
