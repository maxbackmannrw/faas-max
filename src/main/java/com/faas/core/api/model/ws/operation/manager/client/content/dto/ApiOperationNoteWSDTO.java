package com.faas.core.api.model.ws.operation.manager.client.content.dto;

import com.faas.core.data.db.client.details.dao.ClientNoteDAO;

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
