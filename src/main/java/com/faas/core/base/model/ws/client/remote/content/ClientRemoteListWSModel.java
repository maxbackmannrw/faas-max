package com.faas.core.base.model.ws.client.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteListWSDTO;

public class ClientRemoteListWSModel {

    private GeneralWSModel general;
    private ClientRemoteListWSDTO remoteList;

    public ClientRemoteListWSModel() {
    }

    public ClientRemoteListWSModel(GeneralWSModel general, ClientRemoteListWSDTO remoteList) {
        this.general = general;
        this.remoteList = remoteList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientRemoteListWSDTO getRemoteList() {
        return remoteList;
    }

    public void setRemoteList(ClientRemoteListWSDTO remoteList) {
        this.remoteList = remoteList;
    }
}
