package com.faas.core.base.model.ws.client.flow;

import com.faas.core.base.model.ws.client.flow.dto.FlowSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class FlowSessionWSModel {

    private GeneralWSModel general;
    private List<FlowSessionWSDTO>flowSessions;

    public FlowSessionWSModel() {
    }

    public FlowSessionWSModel(GeneralWSModel general, List<FlowSessionWSDTO> flowSessions) {
        this.general = general;
        this.flowSessions = flowSessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<FlowSessionWSDTO> getFlowSessions() {
        return flowSessions;
    }

    public void setFlowSessions(List<FlowSessionWSDTO> flowSessions) {
        this.flowSessions = flowSessions;
    }
}
