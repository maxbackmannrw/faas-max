package com.faas.core.api.model.ws.operation.client.dto;

import com.faas.core.data.db.client.details.dao.ClientNoteDAO;

public class ApiOperationClientNoteWSDTO {

    private ClientNoteDAO clientNote;

    public ApiOperationClientNoteWSDTO() {
    }

    public ApiOperationClientNoteWSDTO(ClientNoteDAO clientNote) {
        this.clientNote = clientNote;
    }

    public ClientNoteDAO getClientNote() {
        return clientNote;
    }

    public void setClientNote(ClientNoteDAO clientNote) {
        this.clientNote = clientNote;
    }
}
