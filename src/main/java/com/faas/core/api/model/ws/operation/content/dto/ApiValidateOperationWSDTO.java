package com.faas.core.api.model.ws.operation.content.dto;


public class ApiValidateOperationWSDTO {

    private long agentId;
    private String operationId;
    private long operationCount;
    private long operationLimit;

    public ApiValidateOperationWSDTO() {
    }

    public ApiValidateOperationWSDTO(long agentId, String operationId, long operationCount, long operationLimit) {
        this.agentId = agentId;
        this.operationId = operationId;
        this.operationCount = operationCount;
        this.operationLimit = operationLimit;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public long getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(long operationCount) {
        this.operationCount = operationCount;
    }

    public long getOperationLimit() {
        return operationLimit;
    }

    public void setOperationLimit(long operationLimit) {
        this.operationLimit = operationLimit;
    }
}
