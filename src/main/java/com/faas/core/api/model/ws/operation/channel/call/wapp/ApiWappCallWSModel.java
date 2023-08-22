package com.faas.core.api.model.ws.operation.channel.call.wapp;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiWappCallWSModel {

    private GeneralWSModel general;
    private List<ApiWappCallWSDTO> wappCalls;

    public ApiWappCallWSModel() {
    }

    public ApiWappCallWSModel(GeneralWSModel general, List<ApiWappCallWSDTO> wappCalls) {
        this.general = general;
        this.wappCalls = wappCalls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiWappCallWSDTO> getWappCalls() {
        return wappCalls;
    }

    public void setWappCalls(List<ApiWappCallWSDTO> wappCalls) {
        this.wappCalls = wappCalls;
    }
}
