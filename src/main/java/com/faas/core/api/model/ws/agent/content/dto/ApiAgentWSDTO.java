package com.faas.core.api.model.ws.agent.content.dto;

import com.faas.core.base.model.db.user.content.UserDBModel;

public class ApiAgentWSDTO {

    private UserDBModel agent;

    public ApiAgentWSDTO() {
    }

    public ApiAgentWSDTO(UserDBModel agent) {
        this.agent = agent;
    }

    public UserDBModel getAgent() {
        return agent;
    }

    public void setAgent(UserDBModel agent) {
        this.agent = agent;
    }
}
