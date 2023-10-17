package com.faas.core.api.model.ws.client.details.dto;

import com.faas.core.base.model.db.client.details.ClientNoteDBModel;

public class ApiClientNoteWSDTO {

    private ClientNoteDBModel clientNote;

    public ApiClientNoteWSDTO() {
    }

    public ApiClientNoteWSDTO(ClientNoteDBModel clientNote) {
        this.clientNote = clientNote;
    }

    public ClientNoteDBModel getClientNote() {
        return clientNote;
    }

    public void setClientNote(ClientNoteDBModel clientNote) {
        this.clientNote = clientNote;
    }
}
