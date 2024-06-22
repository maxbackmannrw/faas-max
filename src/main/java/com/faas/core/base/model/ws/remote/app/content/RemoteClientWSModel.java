package com.faas.core.base.model.ws.remote.app.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientWSDTO;

import java.util.List;

public class RemoteClientWSModel {

    private GeneralWSModel general;
    private List<RemoteClientWSDTO>remoteClients;

    public RemoteClientWSModel() {
    }

    public RemoteClientWSModel(GeneralWSModel general, List<RemoteClientWSDTO> remoteClients) {
        this.general = general;
        this.remoteClients = remoteClients;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteClientWSDTO> getRemoteClients() {
        return remoteClients;
    }

    public void setRemoteClients(List<RemoteClientWSDTO> remoteClients) {
        this.remoteClients = remoteClients;
    }
}
