package com.faas.core.data.ws.api.operation.details.channel.message.wapp;

import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWappMessageWSModel {

    private GeneralWSModel general;
    private List<ApiOperationWappMessageWSDTO> operationWappMessages;

    public ApiOperationWappMessageWSModel() {
    }

    public ApiOperationWappMessageWSModel(GeneralWSModel general, List<ApiOperationWappMessageWSDTO> operationWappMessages) {
        this.general = general;
        this.operationWappMessages = operationWappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationWappMessageWSDTO> getOperationWappMessages() {
        return operationWappMessages;
    }

    public void setOperationWappMessages(List<ApiOperationWappMessageWSDTO> operationWappMessages) {
        this.operationWappMessages = operationWappMessages;
    }
}
