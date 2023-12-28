package com.faas.core.base.model.ws.remote.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppListWSDTO;

public class RemoteAppListWSModel {

    private GeneralWSModel general;
    private RemoteAppListWSDTO clientRemoteList;

    public RemoteAppListWSModel() {
    }

    public RemoteAppListWSModel(GeneralWSModel general, RemoteAppListWSDTO clientRemoteList) {
        this.general = general;
        this.clientRemoteList = clientRemoteList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteAppListWSDTO getClientRemoteList() {
        return clientRemoteList;
    }

    public void setClientRemoteList(RemoteAppListWSDTO clientRemoteList) {
        this.clientRemoteList = clientRemoteList;
    }
}
