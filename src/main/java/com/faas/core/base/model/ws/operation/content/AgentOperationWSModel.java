package com.faas.core.base.model.ws.operation.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;

import java.util.List;

public class AgentOperationWSModel {

    private GeneralWSModel general;
    private List<OperationWSDTO>operations;

    public AgentOperationWSModel() {
    }

    public AgentOperationWSModel(GeneralWSModel general, List<OperationWSDTO> operations) {
        this.general = general;
        this.operations = operations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationWSDTO> operations) {
        this.operations = operations;
    }
}
