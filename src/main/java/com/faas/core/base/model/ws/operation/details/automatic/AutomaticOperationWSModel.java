package com.faas.core.base.model.ws.operation.details.automatic;

import com.faas.core.base.model.ws.operation.details.automatic.dto.AutomaticOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class AutomaticOperationWSModel {

    private GeneralWSModel general;
    private List<AutomaticOperationWSDTO>operationFlows;

    public AutomaticOperationWSModel() {
    }

    public AutomaticOperationWSModel(GeneralWSModel general, List<AutomaticOperationWSDTO> operationFlows) {
        this.general = general;
        this.operationFlows = operationFlows;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomaticOperationWSDTO> getOperationFlows() {
        return operationFlows;
    }

    public void setOperationFlows(List<AutomaticOperationWSDTO> operationFlows) {
        this.operationFlows = operationFlows;
    }
}
