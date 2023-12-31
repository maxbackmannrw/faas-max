package com.faas.core.base.model.ws.manager.remoteapp.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.remoteapp.content.dto.RemoteAppManagerWSDTO;

public class RemoteAppManagerWSModel {

    private GeneralWSModel general;
    private RemoteAppManagerWSDTO remoteManager;

    public RemoteAppManagerWSModel() {
    }

    public RemoteAppManagerWSModel(GeneralWSModel general, RemoteAppManagerWSDTO remoteManager) {
        this.general = general;
        this.remoteManager = remoteManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteAppManagerWSDTO getRemoteManager() {
        return remoteManager;
    }

    public void setRemoteManager(RemoteAppManagerWSDTO remoteManager) {
        this.remoteManager = remoteManager;
    }
}
