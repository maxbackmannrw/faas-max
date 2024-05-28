package com.faas.core.base.model.ws.operation.details.scenario.automation;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.scenario.automation.dto.OperationAutomationWSDTO;

import java.util.List;

public class OperationAutomationWSModel {

    private GeneralWSModel general;
    private List<OperationAutomationWSDTO>operationAutomations;

    public OperationAutomationWSModel() {
    }

    public OperationAutomationWSModel(GeneralWSModel general, List<OperationAutomationWSDTO> operationAutomations) {
        this.general = general;
        this.operationAutomations = operationAutomations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationAutomationWSDTO> getOperationAutomations() {
        return operationAutomations;
    }

    public void setOperationAutomations(List<OperationAutomationWSDTO> operationAutomations) {
        this.operationAutomations = operationAutomations;
    }
}
