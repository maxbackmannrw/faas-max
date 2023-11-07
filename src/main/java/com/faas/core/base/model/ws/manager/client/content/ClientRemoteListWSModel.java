package com.faas.core.base.model.ws.manager.client.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteListWSDTO;

public class ClientRemoteListWSModel {

    private GeneralWSModel general;
    private ClientRemoteListWSDTO clientRemoteList;

    public ClientRemoteListWSModel() {
    }

    public ClientRemoteListWSModel(GeneralWSModel general, ClientRemoteListWSDTO clientRemoteList) {
        this.general = general;
        this.clientRemoteList = clientRemoteList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientRemoteListWSDTO getClientRemoteList() {
        return clientRemoteList;
    }

    public void setClientRemoteList(ClientRemoteListWSDTO clientRemoteList) {
        this.clientRemoteList = clientRemoteList;
    }
}
