package com.faas.core.api.model.ws.operation.channel.message.wapp;

import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiWappMessageWSModel {

    private GeneralWSModel general;
    private List<ApiWappMessageWSDTO> wappMessages;

    public ApiWappMessageWSModel() {
    }

    public ApiWappMessageWSModel(GeneralWSModel general, List<ApiWappMessageWSDTO> wappMessages) {
        this.general = general;
        this.wappMessages = wappMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiWappMessageWSDTO> getWappMessages() {
        return wappMessages;
    }

    public void setWappMessages(List<ApiWappMessageWSDTO> wappMessages) {
        this.wappMessages = wappMessages;
    }
}
