package com.faas.core.base.model.ws.manager.operation.details.manual.dto;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;

import java.util.List;

public class ManualManagerWSDTO {

    private OperationListWSDTO readyOperationList;
    private OperationListWSDTO activeOperationList;
    private List<CampaignManagerWSDTO> campaigns;

    public ManualManagerWSDTO() {
    }

    public ManualManagerWSDTO(OperationListWSDTO readyOperationList, OperationListWSDTO activeOperationList, List<CampaignManagerWSDTO> campaigns) {
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

    public List<CampaignManagerWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignManagerWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
