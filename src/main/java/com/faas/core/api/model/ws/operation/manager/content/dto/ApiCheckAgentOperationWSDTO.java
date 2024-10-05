package com.faas.core.api.model.ws.operation.manager.content.dto;

import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;

public class ApiCheckAgentOperationWSDTO {

    private UserDBModel agent;
    private UserDetailsDBModel agentDetails;
    private long activeOperation;
    private OperationDBModel agentOperation;

    public ApiCheckAgentOperationWSDTO() {
    }

    public ApiCheckAgentOperationWSDTO(UserDBModel agent, UserDetailsDBModel agentDetails, long activeOperation, OperationDBModel agentOperation) {
        this.agent = agent;
        this.agentDetails = agentDetails;
        this.activeOperation = activeOperation;
        this.agentOperation = agentOperation;
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

    public OperationDBModel getAgentOperation() {
        return agentOperation;
    }

    public void setAgentOperation(OperationDBModel agentOperation) {
        this.agentOperation = agentOperation;
    }
}
