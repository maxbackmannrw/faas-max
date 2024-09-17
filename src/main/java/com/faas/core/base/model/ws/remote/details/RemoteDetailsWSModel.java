package com.faas.core.base.model.ws.remote.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.details.dto.RemoteDetailsWSDTO;

import java.util.List;

public class RemoteDetailsWSModel {

    private GeneralWSModel general;
    private List<RemoteDetailsWSDTO> remoteDetails;

    public RemoteDetailsWSModel() {
    }

    public RemoteDetailsWSModel(GeneralWSModel general, List<RemoteDetailsWSDTO> remoteDetails) {
        this.general = general;
        this.remoteDetails = remoteDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteDetailsWSDTO> getRemoteDetails() {
        return remoteDetails;
    }

    public void setRemoteDetails(List<RemoteDetailsWSDTO> remoteDetails) {
        this.remoteDetails = remoteDetails;
    }
}
