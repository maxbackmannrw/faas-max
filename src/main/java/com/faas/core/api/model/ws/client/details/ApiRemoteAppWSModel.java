package com.faas.core.api.model.ws.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiRemoteAppWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiRemoteAppWSModel {

    private GeneralWSModel general;
    private List<ApiRemoteAppWSDTO> remoteApps;

    public ApiRemoteAppWSModel() {
    }

    public ApiRemoteAppWSModel(GeneralWSModel general, List<ApiRemoteAppWSDTO> remoteApps) {
        this.general = general;
        this.remoteApps = remoteApps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiRemoteAppWSDTO> getRemoteApps() {
        return remoteApps;
    }

    public void setRemoteApps(List<ApiRemoteAppWSDTO> remoteApps) {
        this.remoteApps = remoteApps;
    }
}
