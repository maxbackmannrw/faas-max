package com.faas.core.api.model.ws.operation.details.remoteapp;

import com.faas.core.api.model.ws.operation.details.remoteapp.dto.ApiOperationRemoteAppWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationRemoteAppWSModel {

    private GeneralWSModel general;
    private List<ApiOperationRemoteAppWSDTO> remoteApps;

    public ApiOperationRemoteAppWSModel() {
    }

    public ApiOperationRemoteAppWSModel(GeneralWSModel general, List<ApiOperationRemoteAppWSDTO> remoteApps) {
        this.general = general;
        this.remoteApps = remoteApps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationRemoteAppWSDTO> getRemoteApps() {
        return remoteApps;
    }

    public void setRemoteApps(List<ApiOperationRemoteAppWSDTO> remoteApps) {
        this.remoteApps = remoteApps;
    }
}
