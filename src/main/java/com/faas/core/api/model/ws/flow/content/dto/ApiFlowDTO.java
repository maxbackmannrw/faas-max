package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.db.session.SessionDBModel;

public class ApiFlowDTO {

    private SessionDBModel flowSession;

    public ApiFlowDTO() {
    }

    public ApiFlowDTO(SessionDBModel flowSession) {
        this.flowSession = flowSession;
    }

    public SessionDBModel getFlowSession() {
        return flowSession;
    }

    public void setFlowSession(SessionDBModel flowSession) {
        this.flowSession = flowSession;
    }
}
