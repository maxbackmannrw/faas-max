package com.faas.core.base.model.ws.operation.details.automatic.dto;


import com.faas.core.base.model.db.operation.details.flow.OperationFlowDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class OperationFlowSessionWSDTO {

    private SessionDBModel clientSession;
    private OperationFlowDBModel clientFlow;

    public OperationFlowSessionWSDTO() {
    }

    public OperationFlowSessionWSDTO(SessionDBModel clientSession, OperationFlowDBModel clientFlow) {
        this.clientSession = clientSession;
        this.clientFlow = clientFlow;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public OperationFlowDBModel getClientFlow() {
        return clientFlow;
    }

    public void setClientFlow(OperationFlowDBModel clientFlow) {
        this.clientFlow = clientFlow;
    }
}
