package com.faas.core.api.model.ws.user.details.dto;

import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;

public class ApiAgentDetailsWSDTO {

    private UserDBModel agent;
    private UserDetailsDBModel agentDetails;

    public ApiAgentDetailsWSDTO() {
    }

    public ApiAgentDetailsWSDTO(UserDBModel agent, UserDetailsDBModel agentDetails) {
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
