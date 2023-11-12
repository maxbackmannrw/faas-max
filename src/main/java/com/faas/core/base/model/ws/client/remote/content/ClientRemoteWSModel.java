package com.faas.core.base.model.ws.client.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteWSDTO;

import java.util.List;

public class ClientRemoteWSModel {

    private GeneralWSModel general;
    private List<ClientRemoteWSDTO>clientRemotes;

    public ClientRemoteWSModel() {
    }

    public ClientRemoteWSModel(GeneralWSModel general, List<ClientRemoteWSDTO> clientRemotes) {
        this.general = general;
        this.clientRemotes = clientRemotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientRemoteWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<ClientRemoteWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }
}
