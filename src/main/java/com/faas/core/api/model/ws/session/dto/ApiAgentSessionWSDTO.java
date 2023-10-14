package com.faas.core.api.model.ws.session.dto;

public class ApiAgentSessionWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;

    public ApiAgentSessionWSDTO() {
    }

    public ApiAgentSessionWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession) {
        this.readySession = readySession;
        this.activeSession = activeSession;
    }

    public ApiSessionWSDTO getReadySession() {
        return readySession;
    }

    public void setReadySession(ApiSessionWSDTO readySession) {
        this.readySession = readySession;
    }

    public ApiSessionWSDTO getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(ApiSessionWSDTO activeSession) {
        this.activeSession = activeSession;
    }
}
