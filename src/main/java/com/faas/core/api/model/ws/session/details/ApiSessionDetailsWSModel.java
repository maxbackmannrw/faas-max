package com.faas.core.api.model.ws.session.details;

import com.faas.core.api.model.ws.session.details.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiSessionDetailsWSModel {

    private GeneralWSModel general;
    private ApiSessionDetailsWSDTO sessionDetails;

    public ApiSessionDetailsWSModel() {
    }

    public ApiSessionDetailsWSModel(GeneralWSModel general, ApiSessionDetailsWSDTO sessionDetails) {
        this.general = general;
        this.sessionDetails = sessionDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiSessionDetailsWSDTO getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(ApiSessionDetailsWSDTO sessionDetails) {
        this.sessionDetails = sessionDetails;
    }
}
