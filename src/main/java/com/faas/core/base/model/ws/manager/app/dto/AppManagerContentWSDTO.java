package com.faas.core.base.model.ws.manager.app.dto;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;

import java.util.List;

public class AppManagerContentWSDTO {

    private List<CampaignManagerWSDTO>campaignManagers;
    private OperationManagerWSDTO readyOperationManager;
    private OperationManagerWSDTO activeOperationManager;

    public AppManagerContentWSDTO() {
    }

    public AppManagerContentWSDTO(List<CampaignManagerWSDTO> campaignManagers, OperationManagerWSDTO readyOperationManager, OperationManagerWSDTO activeOperationManager) {
        this.campaignManagers = campaignManagers;
        this.readyOperationManager = readyOperationManager;
        this.activeOperationManager = activeOperationManager;
    }

    public List<CampaignManagerWSDTO> getCampaignManagers() {
        return campaignManagers;
    }

    public void setCampaignManagers(List<CampaignManagerWSDTO> campaignManagers) {
        this.campaignManagers = campaignManagers;
    }

    public OperationManagerWSDTO getReadyOperationManager() {
        return readyOperationManager;
    }

    public void setReadyOperationManager(OperationManagerWSDTO readyOperationManager) {
        this.readyOperationManager = readyOperationManager;
    }

    public OperationManagerWSDTO getActiveOperationManager() {
        return activeOperationManager;
    }

    public void setActiveOperationManager(OperationManagerWSDTO activeOperationManager) {
        this.activeOperationManager = activeOperationManager;
    }
}
