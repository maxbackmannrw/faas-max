package com.faas.core.base.model.ws.operation.automatic.content;

import com.faas.core.base.model.ws.operation.automatic.content.dto.OperationFlowSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class OperationFlowSessionWSModel {

    private GeneralWSModel general;
    private List<OperationFlowSessionWSDTO>flowSessions;

    public OperationFlowSessionWSModel() {
    }

    public OperationFlowSessionWSModel(GeneralWSModel general, List<OperationFlowSessionWSDTO> flowSessions) {
        this.general = general;
        this.flowSessions = flowSessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationFlowSessionWSDTO> getFlowSessions() {
        return flowSessions;
    }

    public void setFlowSessions(List<OperationFlowSessionWSDTO> flowSessions) {
        this.flowSessions = flowSessions;
    }
}
