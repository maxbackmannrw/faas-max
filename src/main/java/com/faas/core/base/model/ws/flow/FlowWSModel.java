package com.faas.core.base.model.ws.flow;

import com.faas.core.base.model.ws.flow.dto.FlowWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class FlowWSModel {

    private GeneralWSModel general;
    private List<FlowWSDTO>flows;

    public FlowWSModel() {
    }

    public FlowWSModel(GeneralWSModel general, List<FlowWSDTO> flows) {
        this.general = general;
        this.flows = flows;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<FlowWSDTO> getFlows() {
        return flows;
    }

    public void setFlows(List<FlowWSDTO> flows) {
        this.flows = flows;
    }
}
