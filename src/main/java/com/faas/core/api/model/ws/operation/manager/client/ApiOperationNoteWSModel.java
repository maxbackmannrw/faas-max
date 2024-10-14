package com.faas.core.api.model.ws.operation.manager.client;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;

import java.util.List;


public class ApiOperationNoteWSModel {

    private GeneralWSModel general;
    private List<ClientNoteDAO> operationNotes;

    public ApiOperationNoteWSModel() {
    }

    public ApiOperationNoteWSModel(GeneralWSModel general, List<ClientNoteDAO> operationNotes) {
        this.general = general;
        this.operationNotes = operationNotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientNoteDAO> getOperationNotes() {
        return operationNotes;
    }

    public void setOperationNotes(List<ClientNoteDAO> operationNotes) {
        this.operationNotes = operationNotes;
    }
}
