package com.faas.core.base.model.ws.remoteapp.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppWSDTO;

import java.util.List;

public class RemoteAppWSModel {

    private GeneralWSModel general;
    private List<RemoteAppWSDTO> remoteApps;

    public RemoteAppWSModel() {
    }

    public RemoteAppWSModel(GeneralWSModel general, List<RemoteAppWSDTO> remoteApps) {
        this.general = general;
        this.remoteApps = remoteApps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteAppWSDTO> getRemoteApps() {
        return remoteApps;
    }

    public void setRemoteApps(List<RemoteAppWSDTO> remoteApps) {
        this.remoteApps = remoteApps;
    }
}
