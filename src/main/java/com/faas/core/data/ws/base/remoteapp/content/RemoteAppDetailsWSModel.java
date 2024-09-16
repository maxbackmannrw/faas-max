package com.faas.core.data.ws.base.remoteapp.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.remoteapp.content.dto.RemoteAppDetailsWSDTO;

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
