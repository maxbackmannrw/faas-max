package com.faas.core.api.model.ws.user.details;

import com.faas.core.api.model.ws.user.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiAgentDetailsWSModel {

    private GeneralWSModel general;
    private ApiAgentDetailsWSDTO apiAgentDetails;

    public ApiAgentDetailsWSModel() {
    }

    public ApiAgentDetailsWSModel(GeneralWSModel general, ApiAgentDetailsWSDTO apiAgentDetails) {
        this.general = general;
        this.apiAgentDetails = apiAgentDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiAgentDetailsWSDTO getApiAgentDetails() {
        return apiAgentDetails;
    }

    public void setApiAgentDetails(ApiAgentDetailsWSDTO apiAgentDetails) {
        this.apiAgentDetails = apiAgentDetails;
    }
}
