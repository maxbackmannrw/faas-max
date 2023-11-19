package com.faas.core.base.model.ws.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteSummaryWSDTO;

public class RemoteSummaryWSModel {

    private GeneralWSModel general;
    private RemoteSummaryWSDTO remoteSummary;

    public RemoteSummaryWSModel() {
    }

    public RemoteSummaryWSModel(GeneralWSModel general, RemoteSummaryWSDTO remoteSummary) {
        this.general = general;
        this.remoteSummary = remoteSummary;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public RemoteSummaryWSDTO getRemoteSummary() {
        return remoteSummary;
    }

    public void setRemoteSummary(RemoteSummaryWSDTO remoteSummary) {
        this.remoteSummary = remoteSummary;
    }
}
