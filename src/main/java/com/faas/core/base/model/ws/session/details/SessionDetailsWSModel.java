package com.faas.core.base.model.ws.session.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.session.details.dto.SessionDetailsWSDTO;

public class SessionDetailsWSModel {

    private GeneralWSModel general;
    private SessionDetailsWSDTO sessionDetails;

    public SessionDetailsWSModel() {
    }

    public SessionDetailsWSModel(GeneralWSModel general, SessionDetailsWSDTO sessionDetails) {
        this.general = general;
        this.sessionDetails = sessionDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public SessionDetailsWSDTO getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(SessionDetailsWSDTO sessionDetails) {
        this.sessionDetails = sessionDetails;
    }
}
