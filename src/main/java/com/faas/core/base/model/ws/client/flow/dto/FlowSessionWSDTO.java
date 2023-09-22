package com.faas.core.base.model.ws.client.flow.dto;


import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class FlowSessionWSDTO {

    private SessionDBModel clientSession;
    private ClientFlowDBModel clientFlow;

    public FlowSessionWSDTO() {
    }

    public FlowSessionWSDTO(SessionDBModel clientSession, ClientFlowDBModel clientFlow) {
        this.clientSession = clientSession;
        this.clientFlow = clientFlow;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public ClientFlowDBModel getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(ClientFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }
}
