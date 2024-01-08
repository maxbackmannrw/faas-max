package com.faas.core.api.model.ws.operation.content.dto;


import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;

public class ApiValidateOperationWSDTO {

    private UserDBModel agent;
    private OperationDBModel operation;
    private long operationCount;
    private long operationLimit;

    public ApiValidateOperationWSDTO() {
    }

    public ApiValidateOperationWSDTO(UserDBModel agent, OperationDBModel operation, long operationCount, long operationLimit) {
        this.agent = agent;
        this.operation = operation;
        this.operationCount = operationCount;
        this.operationLimit = operationLimit;
    }

    public UserDBModel getAgent() {
        return agent;
    }

    public void setAgent(UserDBModel agent) {
        this.agent = agent;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
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
