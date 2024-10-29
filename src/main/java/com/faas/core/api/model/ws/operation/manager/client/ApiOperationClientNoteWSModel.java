package com.faas.core.api.model.ws.operation.manager.client;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;

import java.util.List;

public class ApiOperationClientNoteWSModel {

    private GeneralWSModel general;
    private List<ClientNoteDAO> operationClientNotes;

    public ApiOperationClientNoteWSModel() {
    }

    public ApiOperationClientNoteWSModel(GeneralWSModel general, List<ClientNoteDAO> operationClientNotes) {
        this.general = general;
        this.operationClientNotes = operationClientNotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientNoteDAO> getOperationClientNotes() {
        return operationClientNotes;
    }

    public void setOperationClientNotes(List<ClientNoteDAO> operationClientNotes) {
        this.operationClientNotes = operationClientNotes;
    }
}
