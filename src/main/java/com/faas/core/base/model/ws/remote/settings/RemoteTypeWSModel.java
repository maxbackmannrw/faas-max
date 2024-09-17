package com.faas.core.base.model.ws.remote.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.settings.dto.RemoteTypeWSDTO;

import java.util.List;

public class RemoteTypeWSModel {

    private GeneralWSModel general;
    private List<RemoteTypeWSDTO> remoteTypes;

    public RemoteTypeWSModel() {
    }

    public RemoteTypeWSModel(GeneralWSModel general, List<RemoteTypeWSDTO> remoteTypes) {
        this.general = general;
        this.remoteTypes = remoteTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteTypeWSDTO> getRemoteTypes() {
        return remoteTypes;
    }

    public void setRemoteTypes(List<RemoteTypeWSDTO> remoteTypes) {
        this.remoteTypes = remoteTypes;
    }
}
