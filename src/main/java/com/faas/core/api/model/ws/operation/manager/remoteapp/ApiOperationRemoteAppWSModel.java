package com.faas.core.api.model.ws.operation.manager.remoteapp;

import com.faas.core.api.model.ws.operation.manager.remoteapp.dto.ApiOperationRemoteAppWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationRemoteAppWSModel {

    private GeneralWSModel general;
    private List<ApiOperationRemoteAppWSDTO> operationRemoteApps;

    public ApiOperationRemoteAppWSModel() {
    }

    public ApiOperationRemoteAppWSModel(GeneralWSModel general, List<ApiOperationRemoteAppWSDTO> operationRemoteApps) {
        this.general = general;
        this.operationRemoteApps = operationRemoteApps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationRemoteAppWSDTO> getOperationRemoteApps() {
        return operationRemoteApps;
    }

    public void setOperationRemoteApps(List<ApiOperationRemoteAppWSDTO> operationRemoteApps) {
        this.operationRemoteApps = operationRemoteApps;
    }
}
