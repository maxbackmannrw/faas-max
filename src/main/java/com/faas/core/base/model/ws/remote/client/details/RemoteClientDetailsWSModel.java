package com.faas.core.base.model.ws.remote.client.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.details.dto.RemoteClientDetailsWSDTO;

public class RemoteClientDetailsWSModel {

    private GeneralWSModel general;
    private RemoteClientDetailsWSDTO clientRemoteDetails;

    public RemoteClientDetailsWSModel() {
    }

    public RemoteClientDetailsWSModel(GeneralWSModel general, RemoteClientDetailsWSDTO clientRemoteDetails) {
        this.general = general;
        this.clientRemoteDetails = clientRemoteDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteClientDetailsWSDTO getClientRemoteDetails() {
        return clientRemoteDetails;
    }

    public void setClientRemoteDetails(RemoteClientDetailsWSDTO clientRemoteDetails) {
        this.clientRemoteDetails = clientRemoteDetails;
    }
}
