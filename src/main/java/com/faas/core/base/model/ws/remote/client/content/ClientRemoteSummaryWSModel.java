package com.faas.core.base.model.ws.remote.client.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteSummaryWSDTO;

public class ClientRemoteSummaryWSModel {

    private GeneralWSModel general;
    private ClientRemoteSummaryWSDTO clientRemoteSummary;

    public ClientRemoteSummaryWSModel() {
    }

    public ClientRemoteSummaryWSModel(GeneralWSModel general, ClientRemoteSummaryWSDTO clientRemoteSummary) {
        this.general = general;
        this.clientRemoteSummary = clientRemoteSummary;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientRemoteSummaryWSDTO getClientRemoteSummary() {
        return clientRemoteSummary;
    }

    public void setClientRemoteSummary(ClientRemoteSummaryWSDTO clientRemoteSummary) {
        this.clientRemoteSummary = clientRemoteSummary;
    }
}
