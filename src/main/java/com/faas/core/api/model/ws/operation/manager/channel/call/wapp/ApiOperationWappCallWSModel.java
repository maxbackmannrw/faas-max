package com.faas.core.api.model.ws.operation.manager.channel.call.wapp;

import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWappCallWSModel {

    private GeneralWSModel general;
    private List<ApiOperationWappCallWSDTO> operationWappCalls;

    public ApiOperationWappCallWSModel() {
    }

    public ApiOperationWappCallWSModel(GeneralWSModel general, List<ApiOperationWappCallWSDTO> operationWappCalls) {
        this.general = general;
        this.operationWappCalls = operationWappCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationWappCallWSDTO> getOperationWappCalls() {
        return operationWappCalls;
    }

    public void setOperationWappCalls(List<ApiOperationWappCallWSDTO> operationWappCalls) {
        this.operationWappCalls = operationWappCalls;
    }
}
