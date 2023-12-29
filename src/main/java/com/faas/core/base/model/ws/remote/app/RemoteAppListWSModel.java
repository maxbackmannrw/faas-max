package com.faas.core.base.model.ws.remote.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppListWSDTO;

public class RemoteAppListWSModel {

    private GeneralWSModel general;
    private RemoteAppListWSDTO remoteAppList;

    public RemoteAppListWSModel() {
    }

    public RemoteAppListWSModel(GeneralWSModel general, RemoteAppListWSDTO remoteAppList) {
        this.general = general;
        this.remoteAppList = remoteAppList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteAppListWSDTO getRemoteAppList() {
        return remoteAppList;
    }

    public void setRemoteAppList(RemoteAppListWSDTO remoteAppList) {
        this.remoteAppList = remoteAppList;
    }
}
