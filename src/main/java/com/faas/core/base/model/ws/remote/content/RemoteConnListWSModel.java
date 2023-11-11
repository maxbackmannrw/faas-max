package com.faas.core.base.model.ws.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteConnListWSDTO;

public class RemoteConnListWSModel {

    private GeneralWSModel general;
    private RemoteConnListWSDTO remoteConnList;

    public RemoteConnListWSModel() {
    }

    public RemoteConnListWSModel(GeneralWSModel general, RemoteConnListWSDTO remoteConnList) {
        this.general = general;
        this.remoteConnList = remoteConnList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteConnListWSDTO getRemoteConnList() {
        return remoteConnList;
    }

    public void setRemoteConnList(RemoteConnListWSDTO remoteConnList) {
        this.remoteConnList = remoteConnList;
    }
}
