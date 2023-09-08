package com.faas.core.base.model.ws.client.flow;

import com.faas.core.base.model.ws.client.flow.dto.FlowCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class FlowCampaignWSModel {

    private GeneralWSModel general;
    private List<FlowCampaignWSDTO>flowCampaigns;

    public FlowCampaignWSModel() {
    }

    public FlowCampaignWSModel(GeneralWSModel general, List<FlowCampaignWSDTO> flowCampaigns) {
        this.general = general;
        this.flowCampaigns = flowCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<FlowCampaignWSDTO> getFlowCampaigns() {
        return flowCampaigns;
    }

    public void setFlowCampaigns(List<FlowCampaignWSDTO> flowCampaigns) {
        this.flowCampaigns = flowCampaigns;
    }
}
