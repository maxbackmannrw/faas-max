package com.faas.core.base.model.ws.operation.details.content.dto;


import com.faas.core.base.model.db.session.SessionDBModel;

public class OperationFlowSessionWSDTO {

    private SessionDBModel clientSession;

    public OperationFlowSessionWSDTO() {
    }

    public OperationFlowSessionWSDTO(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }

    public SessionDBModel getClientSession() {
        return clientSession;
    }

    public void setClientSession(SessionDBModel clientSession) {
        this.clientSession = clientSession;
    }
}
