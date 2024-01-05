package com.faas.core.api.model.ws.operation.content.dto;


public class ApiAgentOperationWSDTO {

    private ApiOperationListWSDTO readyOperation;
    private ApiOperationListWSDTO activeOperation;

    public ApiAgentOperationWSDTO() {
    }

    public ApiAgentOperationWSDTO(ApiOperationListWSDTO readyOperation, ApiOperationListWSDTO activeOperation) {
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
    }

    public ApiOperationListWSDTO getReadyOperation() {
        return readyOperation;
    }

    public void setReadyOperation(ApiOperationListWSDTO readyOperation) {
        this.readyOperation = readyOperation;
    }

    public ApiOperationListWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiOperationListWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }
}
