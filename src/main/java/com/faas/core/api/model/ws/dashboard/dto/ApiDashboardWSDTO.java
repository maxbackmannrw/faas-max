package com.faas.core.api.model.ws.dashboard.dto;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiDashboardOperationWSDTO readyManualOperation;
    private ApiDashboardOperationWSDTO readyInquiryOperation;
    private ApiDashboardOperationWSDTO activeOperation;
    private List<ApiDashboardCampaignWSDTO> dashboardCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiDashboardOperationWSDTO readyManualOperation, ApiDashboardOperationWSDTO readyInquiryOperation, ApiDashboardOperationWSDTO activeOperation, List<ApiDashboardCampaignWSDTO> dashboardCampaigns) {
        this.readyManualOperation = readyManualOperation;
        this.readyInquiryOperation = readyInquiryOperation;
        this.activeOperation = activeOperation;
        this.dashboardCampaigns = dashboardCampaigns;
    }

    public ApiDashboardOperationWSDTO getReadyManualOperation() {
        return readyManualOperation;
    }

    public void setReadyManualOperation(ApiDashboardOperationWSDTO readyManualOperation) {
        this.readyManualOperation = readyManualOperation;
    }

    public ApiDashboardOperationWSDTO getReadyInquiryOperation() {
        return readyInquiryOperation;
    }

    public void setReadyInquiryOperation(ApiDashboardOperationWSDTO readyInquiryOperation) {
        this.readyInquiryOperation = readyInquiryOperation;
    }

    public ApiDashboardOperationWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiDashboardOperationWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }

    public List<ApiDashboardCampaignWSDTO> getDashboardCampaigns() {
        return dashboardCampaigns;
    }

    public void setDashboardCampaigns(List<ApiDashboardCampaignWSDTO> dashboardCampaigns) {
        this.dashboardCampaigns = dashboardCampaigns;
    }
}
