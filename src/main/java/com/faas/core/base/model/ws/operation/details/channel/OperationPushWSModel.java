package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationPushWSDTO;

import java.util.List;

public class OperationPushWSModel {

    private GeneralWSModel general;
    private List<OperationPushWSDTO>operationPushes;

    public OperationPushWSModel() {
    }

    public OperationPushWSModel(GeneralWSModel general, List<OperationPushWSDTO> operationPushes) {
        this.general = general;
        this.operationPushes = operationPushes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationPushWSDTO> getOperationPushes() {
        return operationPushes;
    }

    public void setOperationPushes(List<OperationPushWSDTO> operationPushes) {
        this.operationPushes = operationPushes;
    }
}
