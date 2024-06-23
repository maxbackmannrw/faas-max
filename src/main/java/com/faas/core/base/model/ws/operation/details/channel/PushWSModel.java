package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.PushWSDTO;

import java.util.List;

public class PushWSModel {

    private GeneralWSModel general;
    private List<PushWSDTO>operationPushes;

    public PushWSModel() {
    }

    public PushWSModel(GeneralWSModel general, List<PushWSDTO> operationPushes) {
        this.general = general;
        this.operationPushes = operationPushes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<PushWSDTO> getOperationPushes() {
        return operationPushes;
    }

    public void setOperationPushes(List<PushWSDTO> operationPushes) {
        this.operationPushes = operationPushes;
    }
}
