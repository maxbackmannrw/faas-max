package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class ApiFlowDTO {

    private ClientFlowDBModel flow;
    private SessionDBModel flowSession;

    public ApiFlowDTO() {
    }

    public ApiFlowDTO(ClientFlowDBModel flow, SessionDBModel flowSession) {
        this.flow = flow;
        this.flowSession = flowSession;
    }

    public ClientFlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(ClientFlowDBModel flow) {
        this.flow = flow;
    }

    public SessionDBModel getFlowSession() {
        return flowSession;
    }

    public void setFlowSession(SessionDBModel flowSession) {
        this.flowSession = flowSession;
    }
}
