package com.faas.core.api.model.ws.operation.details.client.note.dto;

import com.faas.core.base.model.db.client.details.ClientNoteDBModel;

import java.util.List;

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
