package com.faas.core.base.model.ws.client.session.details;

import com.faas.core.base.model.ws.client.session.details.dto.SessionRequestDTO;

import java.util.List;

public class SessionRequest {

    private List<SessionRequestDTO>sessionRequests;

    public SessionRequest() {
    }

    public SessionRequest(List<SessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }

    public List<SessionRequestDTO> getSessionRequests() {
        return sessionRequests;
    }

    public void setSessionRequests(List<SessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }
}
