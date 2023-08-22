package com.faas.core.api.model.ws.operation.details.client.note;

import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiClientNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiClientNoteWSModel {

    private GeneralWSModel general;
    private List<ApiClientNoteWSDTO> clientNotes;

    public ApiClientNoteWSModel() {
    }

    public ApiClientNoteWSModel(GeneralWSModel general, List<ApiClientNoteWSDTO> clientNotes) {
        this.general = general;
        this.clientNotes = clientNotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientNoteWSDTO> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ApiClientNoteWSDTO> clientNotes) {
        this.clientNotes = clientNotes;
    }
}
