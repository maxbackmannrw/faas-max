package com.faas.core.base.model.ws.operation.automatic.content.dto;

import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;

import java.util.List;

public class AutomaticManagerWSDTO {

    private OperationListWSDTO readyOperationList;
    private OperationListWSDTO activeOperationList;
    private List<OperationCampaignWSDTO> campaigns;

    public AutomaticManagerWSDTO() {
    }

    public AutomaticManagerWSDTO(OperationListWSDTO readyOperationList, OperationListWSDTO activeOperationList, List<OperationCampaignWSDTO> campaigns) {
        this.readyOperationList = readyOperationList;
        this.activeOperationList = activeOperationList;
        this.campaigns = campaigns;
    }

    public OperationListWSDTO getReadyOperationList() {
        return readyOperationList;
    }

    public void setReadyOperationList(OperationListWSDTO readyOperationList) {
        this.readyOperationList = readyOperationList;
    }

    public OperationListWSDTO getActiveOperationList() {
        return activeOperationList;
    }

    public void setActiveOperationList(OperationListWSDTO activeOperationList) {
        this.activeOperationList = activeOperationList;
    }

    public List<OperationCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<OperationCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
