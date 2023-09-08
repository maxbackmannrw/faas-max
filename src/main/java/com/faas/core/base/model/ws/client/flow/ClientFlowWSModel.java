package com.faas.core.base.model.ws.client.flow;

import com.faas.core.base.model.ws.client.flow.dto.ClientFlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ClientFlowWSModel {

    private GeneralWSModel general;
    private List<ClientFlowWSDTO>clientFlows;

    public ClientFlowWSModel() {
    }

    public ClientFlowWSModel(GeneralWSModel general, List<ClientFlowWSDTO> clientFlows) {
        this.general = general;
        this.clientFlows = clientFlows;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientFlowWSDTO> getClientFlows() {
        return clientFlows;
    }

    public void setClientFlows(List<ClientFlowWSDTO> clientFlows) {
        this.clientFlows = clientFlows;
    }
}
