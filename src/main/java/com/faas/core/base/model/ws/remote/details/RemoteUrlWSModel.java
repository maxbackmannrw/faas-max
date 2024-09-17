package com.faas.core.base.model.ws.remote.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.details.dto.RemoteUrlWSDTO;

import java.util.List;

public class RemoteUrlWSModel {

    private GeneralWSModel general;
    private List<RemoteUrlWSDTO> remoteUrls;

    public RemoteUrlWSModel() {
    }

    public RemoteUrlWSModel(GeneralWSModel general, List<RemoteUrlWSDTO> remoteUrls) {
        this.general = general;
        this.remoteUrls = remoteUrls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteUrlWSDTO> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<RemoteUrlWSDTO> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }
}
