package com.faas.core.base.model.ws.remote.app.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientListWSDTO;

public class RemoteClientListWSModel {

    private GeneralWSModel general;
    private RemoteClientListWSDTO remoteClientList;

    public RemoteClientListWSModel() {
    }

    public RemoteClientListWSModel(GeneralWSModel general, RemoteClientListWSDTO remoteClientList) {
        this.general = general;
        this.remoteClientList = remoteClientList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteClientListWSDTO getRemoteClientList() {
        return remoteClientList;
    }

    public void setRemoteClientList(RemoteClientListWSDTO remoteClientList) {
        this.remoteClientList = remoteClientList;
    }
}
