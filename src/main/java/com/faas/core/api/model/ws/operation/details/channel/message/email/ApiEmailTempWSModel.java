package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiEmailTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiEmailTempWSModel {

    private GeneralWSModel general;
    private List<ApiEmailTempWSDTO>emailTemps;

    public ApiEmailTempWSModel() {
    }

    public ApiEmailTempWSModel(GeneralWSModel general, List<ApiEmailTempWSDTO> emailTemps) {
        this.general = general;
        this.emailTemps = emailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiEmailTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<ApiEmailTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }
}
