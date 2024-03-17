package com.faas.core.api.model.ws.agent.content.dto;

import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;

public class ApiAgentWSDTO {

    private UserDBModel agent;
    private UserDetailsDBModel agentDetails;

    public ApiAgentWSDTO() {
    }

    public ApiAgentWSDTO(UserDBModel agent, UserDetailsDBModel agentDetails) {
        this.agent = agent;
        this.agentDetails = agentDetails;
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
}
