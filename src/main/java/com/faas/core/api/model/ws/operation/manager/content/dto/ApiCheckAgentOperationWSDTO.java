package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;

public class ApiCheckAgentOperationWSDTO {

    private UserDBModel agent;
    private OperationDBModel operation;
    private long activeOperation;
    private long operationLimit;

    public ApiCheckAgentOperationWSDTO() {
    }

    public ApiCheckAgentOperationWSDTO(UserDBModel agent, OperationDBModel operation, long activeOperation, long operationLimit) {
        this.agent = agent;
        this.operation = operation;
        this.activeOperation = activeOperation;
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

    public long getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(long activeOperation) {
        this.activeOperation = activeOperation;
    }

    public long getOperationLimit() {
        return operationLimit;
    }

    public void setOperationLimit(long operationLimit) {
        this.operationLimit = operationLimit;
    }
}
