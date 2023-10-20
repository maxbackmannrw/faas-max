package com.faas.core.api.model.ws.flow.details;

import com.faas.core.api.model.ws.flow.details.dto.ApiFlowDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiFlowDetailsWSModel {

    private GeneralWSModel general;
    private ApiFlowDetailsWSDTO flowDetailsWSDTO;

    public ApiFlowDetailsWSModel() {
    }

    public ApiFlowDetailsWSModel(GeneralWSModel general, ApiFlowDetailsWSDTO flowDetailsWSDTO) {
        this.general = general;
        this.flowDetailsWSDTO = flowDetailsWSDTO;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiFlowDetailsWSDTO getFlowDetailsWSDTO() {
        return flowDetailsWSDTO;
    }

    public void setFlowDetailsWSDTO(ApiFlowDetailsWSDTO flowDetailsWSDTO) {
        this.flowDetailsWSDTO = flowDetailsWSDTO;
    }
}
