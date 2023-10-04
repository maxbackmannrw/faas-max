package com.faas.core.api.model.ws.flow.content.dto;

import com.faas.core.base.model.db.operation.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class ApiFlowDTO {

    private OperationFlowDBModel flow;
    private SessionDBModel flowSession;

    public ApiFlowDTO() {
    }

    public ApiFlowDTO(OperationFlowDBModel flow, SessionDBModel flowSession) {
        this.flow = flow;
        this.flowSession = flowSession;
    }

    public OperationFlowDBModel getFlow() {
        return flow;
    }

    public void setFlow(OperationFlowDBModel flow) {
        this.flow = flow;
    }

    public SessionDBModel getFlowSession() {
        return flowSession;
    }

    public void setFlowSession(SessionDBModel flowSession) {
        this.flowSession = flowSession;
    }
}
