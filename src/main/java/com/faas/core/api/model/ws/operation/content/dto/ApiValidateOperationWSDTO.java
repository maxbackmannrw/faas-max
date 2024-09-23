package com.faas.core.api.model.ws.operation.content.dto;

import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;

public class ApiValidateOperationWSDTO {

    private UserDBModel agent;
    private long operationCount;
    private long operationLimit;
    private OperationDBModel operation;

    public ApiValidateOperationWSDTO() {
    }

    public ApiValidateOperationWSDTO(UserDBModel agent, long operationCount, long operationLimit, OperationDBModel operation) {
        this.agent = agent;
        this.operationCount = operationCount;
        this.operationLimit = operationLimit;
        this.operation = operation;
    }

    public UserDBModel getAgent() {
        return agent;
    }

    public void setAgent(UserDBModel agent) {
        this.agent = agent;
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

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }
}
