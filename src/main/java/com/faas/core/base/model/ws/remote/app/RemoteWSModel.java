package com.faas.core.base.model.ws.remote.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteWSDTO;

import java.util.List;

public class RemoteWSModel {

    private GeneralWSModel general;
    private List<RemoteWSDTO>remotes;

    public RemoteWSModel() {
    }

    public RemoteWSModel(GeneralWSModel general, List<RemoteWSDTO> remotes) {
        this.general = general;
        this.remotes = remotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteWSDTO> getRemotes() {
        return remotes;
    }

    public void setRemotes(List<RemoteWSDTO> remotes) {
        this.remotes = remotes;
    }
}
