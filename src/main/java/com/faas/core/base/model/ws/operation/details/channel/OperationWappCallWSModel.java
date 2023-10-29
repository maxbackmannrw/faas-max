package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationWappCallWSDTO;

import java.util.List;

public class OperationWappCallWSModel {

    private GeneralWSModel general;
    private List<OperationWappCallWSDTO>wappCalls;

    public OperationWappCallWSModel() {
    }

    public OperationWappCallWSModel(GeneralWSModel general, List<OperationWappCallWSDTO> wappCalls) {
        this.general = general;
        this.wappCalls = wappCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationWappCallWSDTO> getWappCalls() {
        return wappCalls;
    }

    public void setWappCalls(List<OperationWappCallWSDTO> wappCalls) {
        this.wappCalls = wappCalls;
    }
}
