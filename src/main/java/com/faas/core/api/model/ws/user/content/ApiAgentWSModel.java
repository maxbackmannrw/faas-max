package com.faas.core.api.model.ws.user.content;

import com.faas.core.api.model.ws.user.content.dto.ApiAgentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiAgentWSModel {

    private GeneralWSModel general;
    private List<ApiAgentWSDTO> agents;

    public ApiAgentWSModel() {
    }

    public ApiAgentWSModel(GeneralWSModel general, List<ApiAgentWSDTO> agents) {
        this.general = general;
        this.agents = agents;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiAgentWSDTO> getAgents() {
        return agents;
    }

    public void setAgents(List<ApiAgentWSDTO> agents) {
        this.agents = agents;
    }
}
