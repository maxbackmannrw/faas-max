package com.faas.core.data.ws.base.remoteapp.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.remoteapp.content.dto.RemoteAppListWSDTO;

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
