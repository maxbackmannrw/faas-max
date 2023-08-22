package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.db.flow.FlowDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;

public class ApiFlowDTO {

    private FlowDBModel flow;
    private SessionDBModel flowSession;

    public ApiFlowDTO() {
    }

    public ApiFlowDTO(FlowDBModel flow, SessionDBModel flowSession) {
        this.flow = flow;
        this.flowSession = flowSession;
    }

    public FlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(FlowDBModel flow) {
        this.flow = flow;
    }

    public SessionDBModel getFlowSession() {
        return flowSession;
    }

    public void setFlowSession(SessionDBModel flowSession) {
        this.flowSession = flowSession;
    }
}
