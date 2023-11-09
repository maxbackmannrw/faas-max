package com.faas.core.base.model.ws.manager.client.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.RemoteConnWSDTO;

import java.util.List;

public class RemoteConnWSModel {

    private GeneralWSModel general;
    private List<RemoteConnWSDTO>remoteConns;

    public RemoteConnWSModel() {
    }

    public RemoteConnWSModel(GeneralWSModel general, List<RemoteConnWSDTO> remoteConns) {
        this.general = general;
        this.remoteConns = remoteConns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteConnWSDTO> getRemoteConns() {
        return remoteConns;
    }

    public void setRemoteConns(List<RemoteConnWSDTO> remoteConns) {
        this.remoteConns = remoteConns;
    }
}
