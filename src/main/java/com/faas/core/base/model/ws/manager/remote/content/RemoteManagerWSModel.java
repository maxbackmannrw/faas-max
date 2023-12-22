package com.faas.core.base.model.ws.manager.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.remote.content.dto.RemoteManagerWSDTO;

public class RemoteManagerWSModel {

    private GeneralWSModel general;
    private RemoteManagerWSDTO remoteManager;

    public RemoteManagerWSModel() {
    }

    public RemoteManagerWSModel(GeneralWSModel general, RemoteManagerWSDTO remoteManager) {
        this.general = general;
        this.remoteManager = remoteManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteManagerWSDTO getRemoteManager() {
        return remoteManager;
    }

    public void setRemoteManager(RemoteManagerWSDTO remoteManager) {
        this.remoteManager = remoteManager;
    }
}
