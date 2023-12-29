package com.faas.core.base.model.ws.remote.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppSummaryWSDTO;

public class RemoteAppSummaryWSModel {

    private GeneralWSModel general;
    private RemoteAppSummaryWSDTO remoteAppSummary;

    public RemoteAppSummaryWSModel() {
    }

    public RemoteAppSummaryWSModel(GeneralWSModel general, RemoteAppSummaryWSDTO remoteAppSummary) {
        this.general = general;
        this.remoteAppSummary = remoteAppSummary;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteAppSummaryWSDTO getRemoteAppSummary() {
        return remoteAppSummary;
    }

    public void setRemoteAppSummary(RemoteAppSummaryWSDTO remoteAppSummary) {
        this.remoteAppSummary = remoteAppSummary;
    }
}
