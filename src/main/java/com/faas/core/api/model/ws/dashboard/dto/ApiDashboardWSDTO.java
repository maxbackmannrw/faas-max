package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiOperationSessionWSDTO readyOperation;
    private ApiOperationSessionWSDTO readyInquiry;
    private ApiOperationSessionWSDTO activeOperation;
    private List<ApiCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiOperationSessionWSDTO readyOperation, ApiOperationSessionWSDTO readyInquiry, ApiOperationSessionWSDTO activeOperation, List<ApiCampaignWSDTO> dashCampaigns) {
        this.readyOperation = readyOperation;
        this.readyInquiry = readyInquiry;
        this.activeOperation = activeOperation;
        this.dashCampaigns = dashCampaigns;
    }

    public ApiOperationSessionWSDTO getReadyOperation() {
        return readyOperation;
    }

    public void setReadyOperation(ApiOperationSessionWSDTO readyOperation) {
        this.readyOperation = readyOperation;
    }

    public ApiOperationSessionWSDTO getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(ApiOperationSessionWSDTO readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public ApiOperationSessionWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiOperationSessionWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }

    public List<ApiCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
