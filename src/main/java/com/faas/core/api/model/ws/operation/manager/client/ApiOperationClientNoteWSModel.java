package com.faas.core.api.model.ws.operation.manager.client;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationClientNoteWSModel {

    private GeneralWSModel general;
    private List<ApiOperationClientNoteWSDTO> clientNotes;

    public ApiOperationClientNoteWSModel() {
    }

    public ApiOperationClientNoteWSModel(GeneralWSModel general, List<ApiOperationClientNoteWSDTO> clientNotes) {
        this.general = general;
        this.clientNotes = clientNotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationClientNoteWSDTO> getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(List<ApiOperationClientNoteWSDTO> clientNotes) {
        this.clientNotes = clientNotes;
    }
}
