package com.faas.core.api.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.details.content.dao.ClientNoteDAO;

public class ApiClientNoteWSDTO {

    private ClientNoteDAO clientNote;

    public ApiClientNoteWSDTO() {
    }

    public ApiClientNoteWSDTO(ClientNoteDAO clientNote) {
        this.clientNote = clientNote;
    }

    public ClientNoteDAO getClientNote() {
        return clientNote;
    }

    public void setClientNote(ClientNoteDAO clientNote) {
        this.clientNote = clientNote;
    }
}
