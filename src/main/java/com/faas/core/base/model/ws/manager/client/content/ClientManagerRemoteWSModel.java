package com.faas.core.base.model.ws.manager.client.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientManagerRemoteWSDTO;


public class ClientManagerRemoteWSModel {

    private GeneralWSModel general;
    private ClientManagerRemoteWSDTO clientManagerRemote;

    public ClientManagerRemoteWSModel() {
    }

    public ClientManagerRemoteWSModel(GeneralWSModel general, ClientManagerRemoteWSDTO clientManagerRemote) {
        this.general = general;
        this.clientManagerRemote = clientManagerRemote;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientManagerRemoteWSDTO getClientManagerRemote() {
        return clientManagerRemote;
    }

    public void setClientManagerRemote(ClientManagerRemoteWSDTO clientManagerRemote) {
        this.clientManagerRemote = clientManagerRemote;
    }
}
