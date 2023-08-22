package com.faas.core.api.model.ws.flow.details;

import com.faas.core.api.model.ws.flow.details.dto.ApiFlowDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiFlowDetailsWSModel {

    private GeneralWSModel general;
    private ApiFlowDetailsWSDTO flowDetails;

    public ApiFlowDetailsWSModel() {
    }

    public ApiFlowDetailsWSModel(GeneralWSModel general, ApiFlowDetailsWSDTO flowDetails) {
        this.general = general;
        this.flowDetails = flowDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiFlowDetailsWSDTO getFlowDetails() {
        return flowDetails;
    }

    public void setFlowDetails(ApiFlowDetailsWSDTO flowDetails) {
        this.flowDetails = flowDetails;
    }
}
