package com.faas.core.api.model.ws.operation.details.client.note;

import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationNoteWSModel {

    private GeneralWSModel general;
    private List<ApiOperationNoteWSDTO> operationNotes;

    public ApiOperationNoteWSModel() {
    }

    public ApiOperationNoteWSModel(GeneralWSModel general, List<ApiOperationNoteWSDTO> operationNotes) {
        this.general = general;
        this.operationNotes = operationNotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationNoteWSDTO> getOperationNotes() {
        return operationNotes;
    }

    public void setOperationNotes(List<ApiOperationNoteWSDTO> operationNotes) {
        this.operationNotes = operationNotes;
    }
}
