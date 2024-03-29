package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationWappMessageWSDTO;

import java.util.List;

public class OperationWappMessageWSModel {

    private GeneralWSModel general;
    private List<OperationWappMessageWSDTO>operationWappMessages;

    public OperationWappMessageWSModel() {
    }

    public OperationWappMessageWSModel(GeneralWSModel general, List<OperationWappMessageWSDTO> operationWappMessages) {
        this.general = general;
        this.operationWappMessages = operationWappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationWappMessageWSDTO> getOperationWappMessages() {
        return operationWappMessages;
    }

    public void setOperationWappMessages(List<OperationWappMessageWSDTO> operationWappMessages) {
        this.operationWappMessages = operationWappMessages;
    }
}
