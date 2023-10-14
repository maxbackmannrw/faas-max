package com.faas.core.api.model.ws.operation.content.dto;


public class ApiAgentOperationWSDTO {

    private ApiOperationSessionWSDTO readyOperation;
    private ApiOperationSessionWSDTO activeOperation;

    public ApiAgentOperationWSDTO() {
    }

    public ApiAgentOperationWSDTO(ApiOperationSessionWSDTO readyOperation, ApiOperationSessionWSDTO activeOperation) {
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
    }

    public ApiOperationSessionWSDTO getReadyOperation() {
        return readyOperation;
    }

    public void setReadyOperation(ApiOperationSessionWSDTO readyOperation) {
        this.readyOperation = readyOperation;
    }

    public ApiOperationSessionWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiOperationSessionWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }
}
