package com.faas.core.api.model.ws.operation.details.client.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientNoteDAO;

public class ApiOperationNoteWSDTO {

    private ClientNoteDAO operationNote;

    public ApiOperationNoteWSDTO() {
    }

    public ApiOperationNoteWSDTO(ClientNoteDAO operationNote) {
        this.operationNote = operationNote;
    }

    public ClientNoteDAO getOperationNote() {
        return operationNote;
    }

    public void setOperationNote(ClientNoteDAO operationNote) {
        this.operationNote = operationNote;
    }
}
