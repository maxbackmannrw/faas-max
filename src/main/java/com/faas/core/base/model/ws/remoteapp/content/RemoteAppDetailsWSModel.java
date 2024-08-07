package com.faas.core.base.model.ws.remoteapp.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppDetailsWSDTO;

public class RemoteAppDetailsWSModel {

    private GeneralWSModel general;
    private RemoteAppDetailsWSDTO remoteAppDetails;

    public RemoteAppDetailsWSModel() {
    }

    public RemoteAppDetailsWSModel(GeneralWSModel general, RemoteAppDetailsWSDTO remoteAppDetails) {
        this.general = general;
        this.remoteAppDetails = remoteAppDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteAppDetailsWSDTO getRemoteAppDetails() {
        return remoteAppDetails;
    }

    public void setRemoteAppDetails(RemoteAppDetailsWSDTO remoteAppDetails) {
        this.remoteAppDetails = remoteAppDetails;
    }
}
