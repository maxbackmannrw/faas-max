package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWappMessageWSModel {

    private GeneralWSModel general;
    private List<ApiOperationWappMessageWSDTO> wappMessages;

    public ApiOperationWappMessageWSModel() {
    }

    public ApiOperationWappMessageWSModel(GeneralWSModel general, List<ApiOperationWappMessageWSDTO> wappMessages) {
        this.general = general;
        this.wappMessages = wappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationWappMessageWSDTO> getWappMessages() {
        return wappMessages;
    }

    public void setWappMessages(List<ApiOperationWappMessageWSDTO> wappMessages) {
        this.wappMessages = wappMessages;
    }
}
