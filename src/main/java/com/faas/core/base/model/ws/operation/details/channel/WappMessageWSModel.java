package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.WappMessageWSDTO;

import java.util.List;

public class WappMessageWSModel {

    private GeneralWSModel general;
    private List<WappMessageWSDTO>operationWappMessages;

    public WappMessageWSModel() {
    }

    public WappMessageWSModel(GeneralWSModel general, List<WappMessageWSDTO> operationWappMessages) {
        this.general = general;
        this.operationWappMessages = operationWappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappMessageWSDTO> getOperationWappMessages() {
        return operationWappMessages;
    }

    public void setOperationWappMessages(List<WappMessageWSDTO> operationWappMessages) {
        this.operationWappMessages = operationWappMessages;
    }
}
