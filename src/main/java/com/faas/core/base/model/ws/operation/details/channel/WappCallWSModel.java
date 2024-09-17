package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.WappCallWSDTO;

import java.util.List;

public class WappCallWSModel {

    private GeneralWSModel general;
    private List<WappCallWSDTO> operationWappCalls;

    public WappCallWSModel() {
    }

    public WappCallWSModel(GeneralWSModel general, List<WappCallWSDTO> operationWappCalls) {
        this.general = general;
        this.operationWappCalls = operationWappCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappCallWSDTO> getOperationWappCalls() {
        return operationWappCalls;
    }

    public void setOperationWappCalls(List<WappCallWSDTO> operationWappCalls) {
        this.operationWappCalls = operationWappCalls;
    }
}
