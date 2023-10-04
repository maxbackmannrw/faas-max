package com.faas.core.base.model.ws.operation.flow;

import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class OperationFlowCampaignWSModel {

    private GeneralWSModel general;
    private List<OperationFlowCampaignWSDTO>flowCampaigns;

    public OperationFlowCampaignWSModel() {
    }

    public OperationFlowCampaignWSModel(GeneralWSModel general, List<OperationFlowCampaignWSDTO> flowCampaigns) {
        this.general = general;
        this.flowCampaigns = flowCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationFlowCampaignWSDTO> getFlowCampaigns() {
        return flowCampaigns;
    }

    public void setFlowCampaigns(List<OperationFlowCampaignWSDTO> flowCampaigns) {
        this.flowCampaigns = flowCampaigns;
    }
}
