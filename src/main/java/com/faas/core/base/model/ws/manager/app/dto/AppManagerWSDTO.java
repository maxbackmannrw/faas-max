package com.faas.core.base.model.ws.manager.app.dto;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;

import java.util.List;

public class AppManagerWSDTO {

    private List<CampaignManagerWSDTO>manualCampaigns;
    private List<CampaignManagerWSDTO>inquiryCampaigns;
    private List<CampaignManagerWSDTO>automaticCampaigns;
    private OperationManagerWSDTO readyOperation;
    private OperationManagerWSDTO activeOperation;
    private OperationManagerWSDTO finishedOperation;

    public AppManagerWSDTO() {
    }

    public AppManagerWSDTO(List<CampaignManagerWSDTO> manualCampaigns, List<CampaignManagerWSDTO> inquiryCampaigns, List<CampaignManagerWSDTO> automaticCampaigns, OperationManagerWSDTO readyOperation, OperationManagerWSDTO activeOperation, OperationManagerWSDTO finishedOperation) {
        this.manualCampaigns = manualCampaigns;
        this.inquiryCampaigns = inquiryCampaigns;
        this.automaticCampaigns = automaticCampaigns;
        this.readyOperation = readyOperation;
        this.activeOperation = activeOperation;
        this.finishedOperation = finishedOperation;
    }

    public List<CampaignManagerWSDTO> getManualCampaigns() {
        return manualCampaigns;
    }

    public void setManualCampaigns(List<CampaignManagerWSDTO> manualCampaigns) {
        this.manualCampaigns = manualCampaigns;
    }

    public List<CampaignManagerWSDTO> getInquiryCampaigns() {
        return inquiryCampaigns;
    }

    public void setInquiryCampaigns(List<CampaignManagerWSDTO> inquiryCampaigns) {
        this.inquiryCampaigns = inquiryCampaigns;
    }

    public List<CampaignManagerWSDTO> getAutomaticCampaigns() {
        return automaticCampaigns;
    }

    public void setAutomaticCampaigns(List<CampaignManagerWSDTO> automaticCampaigns) {
        this.automaticCampaigns = automaticCampaigns;
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

    public OperationManagerWSDTO getFinishedOperation() {
        return finishedOperation;
    }

    public void setFinishedOperation(OperationManagerWSDTO finishedOperation) {
        this.finishedOperation = finishedOperation;
    }
}
