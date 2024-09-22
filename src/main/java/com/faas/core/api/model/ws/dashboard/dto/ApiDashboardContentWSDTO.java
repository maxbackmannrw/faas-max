package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;

import java.util.List;

public class ApiDashboardContentWSDTO {

    private ApiOperationListWSDTO manualOperation;
    private ApiOperationListWSDTO inquiryOperation;
    private ApiOperationListWSDTO activeOperation;
    private List<ApiCampaignWSDTO> activeCampaigns;

    public ApiDashboardContentWSDTO() {
    }

    public ApiDashboardContentWSDTO(ApiOperationListWSDTO manualOperation, ApiOperationListWSDTO inquiryOperation, ApiOperationListWSDTO activeOperation, List<ApiCampaignWSDTO> activeCampaigns) {
        this.manualOperation = manualOperation;
        this.inquiryOperation = inquiryOperation;
        this.activeOperation = activeOperation;
        this.activeCampaigns = activeCampaigns;
    }

    public ApiOperationListWSDTO getManualOperation() {
        return manualOperation;
    }

    public void setManualOperation(ApiOperationListWSDTO manualOperation) {
        this.manualOperation = manualOperation;
    }

    public ApiOperationListWSDTO getInquiryOperation() {
        return inquiryOperation;
    }

    public void setInquiryOperation(ApiOperationListWSDTO inquiryOperation) {
        this.inquiryOperation = inquiryOperation;
    }

    public ApiOperationListWSDTO getActiveOperation() {
        return activeOperation;
    }

    public void setActiveOperation(ApiOperationListWSDTO activeOperation) {
        this.activeOperation = activeOperation;
    }

    public List<ApiCampaignWSDTO> getActiveCampaigns() {
        return activeCampaigns;
    }

    public void setActiveCampaigns(List<ApiCampaignWSDTO> activeCampaigns) {
        this.activeCampaigns = activeCampaigns;
    }
}
