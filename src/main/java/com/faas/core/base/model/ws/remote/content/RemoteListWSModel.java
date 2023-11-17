package com.faas.core.base.model.ws.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteListWSDTO;

public class RemoteListWSModel {

    private GeneralWSModel general;
    private RemoteListWSDTO remoteList;

    public RemoteListWSModel() {
    }

    public RemoteListWSModel(GeneralWSModel general, RemoteListWSDTO remoteList) {
        this.general = general;
        this.remoteList = remoteList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteListWSDTO getRemoteList() {
        return remoteList;
    }

    public void setRemoteList(RemoteListWSDTO remoteList) {
        this.remoteList = remoteList;
    }
}
