package com.faas.core.base.model.ws.operation.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.dto.AgentOperationWSDTO;

public class AgentOperationWSModel {

    private GeneralWSModel general;
    private AgentOperationWSDTO agentOperation;

    public AgentOperationWSModel() {
    }

    public AgentOperationWSModel(GeneralWSModel general, AgentOperationWSDTO agentOperation) {
        this.general = general;
        this.agentOperation = agentOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AgentOperationWSDTO getAgentOperation() {
        return agentOperation;
    }

    public void setAgentOperation(AgentOperationWSDTO agentOperation) {
        this.agentOperation = agentOperation;
    }
}
