package com.faas.core.base.model.ws.manager.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.remote.content.dto.ClientRemoteManagerWSDTO;

public class ClientRemoteManagerWSModel {

    private GeneralWSModel general;
    private ClientRemoteManagerWSDTO clientRemoteManager;

    public ClientRemoteManagerWSModel() {
    }

    public ClientRemoteManagerWSModel(GeneralWSModel general, ClientRemoteManagerWSDTO clientRemoteManager) {
        this.general = general;
        this.clientRemoteManager = clientRemoteManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientRemoteManagerWSDTO getClientRemoteManager() {
        return clientRemoteManager;
    }

    public void setClientRemoteManager(ClientRemoteManagerWSDTO clientRemoteManager) {
        this.clientRemoteManager = clientRemoteManager;
    }
}
