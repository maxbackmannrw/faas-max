package com.faas.core.base.model.ws.remote.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppSummaryWSDTO;

public class RemoteAppSummaryWSModel {

    private GeneralWSModel general;
    private RemoteAppSummaryWSDTO clientRemoteSummary;

    public RemoteAppSummaryWSModel() {
    }

    public RemoteAppSummaryWSModel(GeneralWSModel general, RemoteAppSummaryWSDTO clientRemoteSummary) {
        this.general = general;
        this.clientRemoteSummary = clientRemoteSummary;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteAppSummaryWSDTO getClientRemoteSummary() {
        return clientRemoteSummary;
    }

    public void setClientRemoteSummary(RemoteAppSummaryWSDTO clientRemoteSummary) {
        this.clientRemoteSummary = clientRemoteSummary;
    }
}
