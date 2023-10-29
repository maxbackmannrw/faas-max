package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationWappMessageWSDTO;

import java.util.List;

public class OperationWappMessageWSModel {

    private GeneralWSModel general;
    private List<OperationWappMessageWSDTO>wappMessages;

    public OperationWappMessageWSModel() {
    }

    public OperationWappMessageWSModel(GeneralWSModel general, List<OperationWappMessageWSDTO> wappMessages) {
        this.general = general;
        this.wappMessages = wappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationWappMessageWSDTO> getWappMessages() {
        return wappMessages;
    }

    public void setWappMessages(List<OperationWappMessageWSDTO> wappMessages) {
        this.wappMessages = wappMessages;
    }
}
