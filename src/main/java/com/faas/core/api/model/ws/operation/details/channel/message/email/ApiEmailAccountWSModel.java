package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiEmailAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiEmailAccountWSModel {

    private GeneralWSModel general;
    private List<ApiEmailAccountWSDTO> emailAccounts;

    public ApiEmailAccountWSModel() {
    }

    public ApiEmailAccountWSModel(GeneralWSModel general, List<ApiEmailAccountWSDTO> emailAccounts) {
        this.general = general;
        this.emailAccounts = emailAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiEmailAccountWSDTO> getEmailAccounts() {
        return emailAccounts;
    }

    public void setEmailAccounts(List<ApiEmailAccountWSDTO> emailAccounts) {
        this.emailAccounts = emailAccounts;
    }
}
