package com.faas.core.base.model.ws.client.settings;

import com.faas.core.base.model.ws.client.settings.dto.FlowTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class FlowTypeWSModel {

    private GeneralWSModel general;
    private List<FlowTypeWSDTO> flowTypes;


    public FlowTypeWSModel() {
    }

    public FlowTypeWSModel(GeneralWSModel general, List<FlowTypeWSDTO> flowTypes) {
        this.general = general;
        this.flowTypes = flowTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<FlowTypeWSDTO> getFlowTypes() {
        return flowTypes;
    }

    public void setFlowTypes(List<FlowTypeWSDTO> flowTypes) {
        this.flowTypes = flowTypes;
    }
}
