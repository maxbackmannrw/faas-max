package com.faas.core.data.ws.api.agent.details;

import com.faas.core.data.ws.api.agent.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ApiAgentInfoWSModel {

    private GeneralWSModel general;
    private List<ApiAgentInfoWSDTO> agentInfos;

    public ApiAgentInfoWSModel() {
    }

    public ApiAgentInfoWSModel(GeneralWSModel general, List<ApiAgentInfoWSDTO> agentInfos) {
        this.general = general;
        this.agentInfos = agentInfos;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiAgentInfoWSDTO> getAgentInfos() {
        return agentInfos;
    }

    public void setAgentInfos(List<ApiAgentInfoWSDTO> agentInfos) {
        this.agentInfos = agentInfos;
    }
}
