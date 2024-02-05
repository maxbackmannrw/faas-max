package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationEmailTempWSModel {

    private GeneralWSModel general;
    private List<ApiOperationEmailTempWSDTO>emailTemps;

    public ApiOperationEmailTempWSModel() {
    }

    public ApiOperationEmailTempWSModel(GeneralWSModel general, List<ApiOperationEmailTempWSDTO> emailTemps) {
        this.general = general;
        this.emailTemps = emailTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationEmailTempWSDTO> getEmailTemps() {
        return emailTemps;
    }

    public void setEmailTemps(List<ApiOperationEmailTempWSDTO> emailTemps) {
        this.emailTemps = emailTemps;
    }
}
