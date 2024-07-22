package com.faas.core.base.model.ws.remoteapp.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteClientSummaryWSDTO;

public class RemoteClientSummaryWSModel {

    private GeneralWSModel general;
    private RemoteClientSummaryWSDTO clientRemoteSummary;

    public RemoteClientSummaryWSModel() {
    }

    public RemoteClientSummaryWSModel(GeneralWSModel general, RemoteClientSummaryWSDTO clientRemoteSummary) {
        this.general = general;
        this.clientRemoteSummary = clientRemoteSummary;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteClientSummaryWSDTO getClientRemoteSummary() {
        return clientRemoteSummary;
    }

    public void setClientRemoteSummary(RemoteClientSummaryWSDTO clientRemoteSummary) {
        this.clientRemoteSummary = clientRemoteSummary;
    }
}
