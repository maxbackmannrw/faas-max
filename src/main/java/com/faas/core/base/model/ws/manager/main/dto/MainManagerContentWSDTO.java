package com.faas.core.base.model.ws.manager.main.dto;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;

import java.util.List;

public class MainManagerContentWSDTO {

    private List<CampaignManagerWSDTO>campaignManagers;
    private OperationManagerWSDTO readyOperation;
    private OperationManagerWSDTO activeOperation;

    public MainManagerContentWSDTO() {
    }

    public MainManagerContentWSDTO(List<CampaignManagerWSDTO> campaignManagers, OperationManagerWSDTO readyOperation, OperationManagerWSDTO activeOperation) {
        this.campaignManagers = campaignManagers;
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
    }

    public List<CampaignManagerWSDTO> getCampaignManagers() {
        return campaignManagers;
    }

    public void setCampaignManagers(List<CampaignManagerWSDTO> campaignManagers) {
        this.campaignManagers = campaignManagers;
    }

    public OperationManagerWSDTO getReadyOperation() {
        return readyOperation;
    }

    public void setReadyOperation(OperationManagerWSDTO readyOperation) {
        this.readyOperation = readyOperation;
    }

    public OperationManagerWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(OperationManagerWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }
}
