package com.faas.core.api.model.ws.client.flow;

import com.faas.core.api.model.ws.client.flow.dto.ApiClientFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiClientFlowWSModel {

    private GeneralWSModel general;
    private ApiClientFlowWSDTO clientFlow;

    public ApiClientFlowWSModel() {
    }

    public ApiClientFlowWSModel(GeneralWSModel general, ApiClientFlowWSDTO clientFlow) {
        this.general = general;
        this.clientFlow = clientFlow;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiClientFlowWSDTO getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(ApiClientFlowWSDTO clientFlow) {
        this.clientFlow = clientFlow;
    }
}
