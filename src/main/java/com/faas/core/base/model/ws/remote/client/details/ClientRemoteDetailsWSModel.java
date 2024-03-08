package com.faas.core.base.model.ws.remote.client.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.details.dto.ClientRemoteDetailsWSDTO;

public class ClientRemoteDetailsWSModel {

    private GeneralWSModel general;
    private ClientRemoteDetailsWSDTO clientRemoteDetails;

    public ClientRemoteDetailsWSModel() {
    }

    public ClientRemoteDetailsWSModel(GeneralWSModel general, ClientRemoteDetailsWSDTO clientRemoteDetails) {
        this.general = general;
        this.clientRemoteDetails = clientRemoteDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientRemoteDetailsWSDTO getClientRemoteDetails() {
        return clientRemoteDetails;
    }

    public void setClientRemoteDetails(ClientRemoteDetailsWSDTO clientRemoteDetails) {
        this.clientRemoteDetails = clientRemoteDetails;
    }
}
