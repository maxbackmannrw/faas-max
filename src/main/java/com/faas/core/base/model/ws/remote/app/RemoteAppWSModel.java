package com.faas.core.base.model.ws.remote.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppWSDTO;

import java.util.List;

public class RemoteAppWSModel {

    private GeneralWSModel general;
    private List<RemoteAppWSDTO>clientRemotes;

    public RemoteAppWSModel() {
    }

    public RemoteAppWSModel(GeneralWSModel general, List<RemoteAppWSDTO> clientRemotes) {
        this.general = general;
        this.clientRemotes = clientRemotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteAppWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<RemoteAppWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }
}
