package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;

public class ApiOperationAgentWSDTO {

    private UserDBModel agent;
    private UserDetailsDBModel agentDetails;
    private long activeOperation;
    private long operationLimit;

    public ApiOperationAgentWSDTO() {
    }

    public ApiOperationAgentWSDTO(UserDBModel agent, UserDetailsDBModel agentDetails, long activeOperation, long operationLimit) {
        this.agent = agent;
        this.agentDetails = agentDetails;
        this.activeOperation = activeOperation;
        this.operationLimit = operationLimit;
    }

    public UserDBModel getAgent() {
        return agent;
    }

    public void setAgent(UserDBModel agent) {
        this.agent = agent;
    }

    public UserDetailsDBModel getAgentDetails() {
        return agentDetails;
    }

    public void setAgentDetails(UserDetailsDBModel agentDetails) {
        this.agentDetails = agentDetails;
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
