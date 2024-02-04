package com.faas.core.api.model.ws.operation.details.channel.call.wapp;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiWappCallAccountWSModel {

    private GeneralWSModel general;
    private List<ApiWappCallWSDTO> wappCalls;

    public ApiWappCallAccountWSModel() {
    }

    public ApiWappCallAccountWSModel(GeneralWSModel general, List<ApiWappCallWSDTO> wappCalls) {
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
