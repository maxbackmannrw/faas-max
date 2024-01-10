package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiEmailWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiEmailWSModel {

    private GeneralWSModel general;
    private List<ApiEmailWSDTO> emails;

    public ApiEmailWSModel() {
    }

    public ApiEmailWSModel(GeneralWSModel general, List<ApiEmailWSDTO> emails) {
        this.general = general;
        this.emails = emails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiEmailWSDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<ApiEmailWSDTO> emails) {
        this.emails = emails;
    }
}
