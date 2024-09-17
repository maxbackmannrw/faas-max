package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiOperationWSModel {

    private GeneralWSModel general;
    private List<ApiOperationWSDTO> operations;

    public ApiOperationWSModel() {
    }

    public ApiOperationWSModel(GeneralWSModel general, List<ApiOperationWSDTO> operations) {
        this.general = general;
        this.operations = operations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationWSDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<ApiOperationWSDTO> operations) {
        this.operations = operations;
    }
}
