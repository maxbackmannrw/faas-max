package com.faas.core.api.model.ws.operation.manager.channel.call.sip;

import com.faas.core.api.model.ws.operation.manager.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationSipCallWSModel {

    private GeneralWSModel general;
    private List<ApiOperationSipCallWSDTO> operationSipCalls;

    public ApiOperationSipCallWSModel() {
    }

    public ApiOperationSipCallWSModel(GeneralWSModel general, List<ApiOperationSipCallWSDTO> operationSipCalls) {
        this.general = general;
        this.operationSipCalls = operationSipCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationSipCallWSDTO> getOperationSipCalls() {
        return operationSipCalls;
    }

    public void setOperationSipCalls(List<ApiOperationSipCallWSDTO> operationSipCalls) {
        this.operationSipCalls = operationSipCalls;
    }
}
