package com.faas.core.api.model.ws.client.flow.content;

import com.faas.core.api.model.ws.client.flow.content.dto.ApiFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiFlowWSModel {

    private GeneralWSModel general;
    private ApiFlowWSDTO flow;

    public ApiFlowWSModel() {
    }

    public ApiFlowWSModel(GeneralWSModel general, ApiFlowWSDTO flow) {
        this.general = general;
        this.flow = flow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiFlowWSDTO getFlow() {
        return flow;
    }

    public void setFlow(ApiFlowWSDTO flow) {
        this.flow = flow;
    }
}
