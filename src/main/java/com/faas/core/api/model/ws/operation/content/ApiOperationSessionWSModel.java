package com.faas.core.api.model.ws.operation.content;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSessionWSModel {

    private GeneralWSModel general;
    private ApiOperationSessionWSDTO operationSession;

    public ApiOperationSessionWSModel() {
    }

    public ApiOperationSessionWSModel(GeneralWSModel general, ApiOperationSessionWSDTO operationSession) {
        this.general = general;
        this.operationSession = operationSession;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSessionWSDTO getOperationSession() {
        return operationSession;
    }

    public void setOperationSession(ApiOperationSessionWSDTO operationSession) {
        this.operationSession = operationSession;
    }
}
