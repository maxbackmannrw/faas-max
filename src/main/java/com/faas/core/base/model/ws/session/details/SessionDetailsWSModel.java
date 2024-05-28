package com.faas.core.base.model.ws.session.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.session.details.dto.SessionDetailsWSDTO;

import java.util.List;

public class SessionDetailsWSModel {

    private GeneralWSModel general;
    private List<SessionDetailsWSDTO>sessionDetails;

    public SessionDetailsWSModel() {
    }

    public SessionDetailsWSModel(GeneralWSModel general, List<SessionDetailsWSDTO> sessionDetails) {
        this.general = general;
        this.sessionDetails = sessionDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SessionDetailsWSDTO> getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(List<SessionDetailsWSDTO> sessionDetails) {
        this.sessionDetails = sessionDetails;
    }
}
