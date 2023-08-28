package com.faas.core.api.model.ws.operation.details.peer;

import com.faas.core.api.model.ws.operation.details.peer.dto.ApiClientPeerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiClientPeerWSModel {

    private GeneralWSModel general;
    private List<ApiClientPeerWSDTO>clientPeers;

    public ApiClientPeerWSModel() {
    }

    public ApiClientPeerWSModel(GeneralWSModel general, List<ApiClientPeerWSDTO> clientPeers) {
        this.general = general;
        this.clientPeers = clientPeers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientPeerWSDTO> getClientPeers() {
        return clientPeers;
    }

    public void setClientPeers(List<ApiClientPeerWSDTO> clientPeers) {
        this.clientPeers = clientPeers;
    }
}
