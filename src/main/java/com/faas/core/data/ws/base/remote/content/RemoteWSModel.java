package com.faas.core.data.ws.base.remote.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.remote.content.dto.RemoteWSDTO;

import java.util.List;

public class RemoteWSModel {

    private GeneralWSModel general;
    private List<RemoteWSDTO> remotes;

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
