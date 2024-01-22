package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiOperationListWSDTO readyManualOperation;
    private ApiOperationListWSDTO readyInquiryOperation;
    private ApiOperationListWSDTO activeOperation;
    private List<ApiCampaignWSDTO> dashboardCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiOperationListWSDTO readyManualOperation, ApiOperationListWSDTO readyInquiryOperation, ApiOperationListWSDTO activeOperation, List<ApiCampaignWSDTO> dashboardCampaigns) {
        this.readyManualOperation = readyManualOperation;
        this.readyInquiryOperation = readyInquiryOperation;
        this.activeOperation = activeOperation;
        this.dashboardCampaigns = dashboardCampaigns;
    }

    public ApiOperationListWSDTO getReadyManualOperation() {
        return readyManualOperation;
    }

    public void setReadyManualOperation(ApiOperationListWSDTO readyManualOperation) {
        this.readyManualOperation = readyManualOperation;
    }

    public ApiOperationListWSDTO getReadyInquiryOperation() {
        return readyInquiryOperation;
    }

    public void setReadyInquiryOperation(ApiOperationListWSDTO readyInquiryOperation) {
        this.readyInquiryOperation = readyInquiryOperation;
    }

    public ApiOperationListWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiOperationListWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }

    public List<ApiCampaignWSDTO> getDashboardCampaigns() {
        return dashboardCampaigns;
    }

    public void setDashboardCampaigns(List<ApiCampaignWSDTO> dashboardCampaigns) {
        this.dashboardCampaigns = dashboardCampaigns;
    }
}
