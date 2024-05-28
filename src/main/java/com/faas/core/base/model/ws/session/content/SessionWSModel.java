package com.faas.core.base.model.ws.session.content;

import com.faas.core.base.model.ws.session.content.dto.SessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class SessionWSModel {

    private GeneralWSModel general;
    private List<SessionWSDTO> sessions;

    public SessionWSModel() {
    }

    public SessionWSModel(GeneralWSModel general, List<SessionWSDTO> sessions) {
        this.general = general;
        this.sessions = sessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SessionWSDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionWSDTO> sessions) {
        this.sessions = sessions;
    }
}
