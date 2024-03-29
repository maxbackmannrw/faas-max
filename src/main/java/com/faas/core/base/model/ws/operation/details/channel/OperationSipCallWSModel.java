package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationSipCallWSDTO;

import java.util.List;

public class OperationSipCallWSModel {

    private GeneralWSModel general;
    private List<OperationSipCallWSDTO>operationSipCalls;

    public OperationSipCallWSModel() {
    }

    public OperationSipCallWSModel(GeneralWSModel general, List<OperationSipCallWSDTO> operationSipCalls) {
        this.general = general;
        this.operationSipCalls = operationSipCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationSipCallWSDTO> getOperationSipCalls() {
        return operationSipCalls;
    }

    public void setOperationSipCalls(List<OperationSipCallWSDTO> operationSipCalls) {
        this.operationSipCalls = operationSipCalls;
    }
}
