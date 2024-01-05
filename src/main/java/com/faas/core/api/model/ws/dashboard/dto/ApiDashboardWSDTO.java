package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiOperationListWSDTO readManualOperation;
    private ApiOperationListWSDTO readyInquiryOperation;
    private ApiOperationListWSDTO activeOperation;
    private List<ApiCampaignWSDTO> dashboardCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiOperationListWSDTO readManualOperation, ApiOperationListWSDTO readyInquiryOperation, ApiOperationListWSDTO activeOperation, List<ApiCampaignWSDTO> dashboardCampaigns) {
        this.readManualOperation = readManualOperation;
        this.readyInquiryOperation = readyInquiryOperation;
        this.activeOperation = activeOperation;
        this.dashboardCampaigns = dashboardCampaigns;
    }

    public ApiOperationListWSDTO getReadManualOperation() {
        return readManualOperation;
    }

    public void setReadManualOperation(ApiOperationListWSDTO readManualOperation) {
        this.readManualOperation = readManualOperation;
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
