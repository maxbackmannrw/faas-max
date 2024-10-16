package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;

import java.util.List;

public class ApiDashContentWSDTO {

    private ApiOperationListWSDTO manualOperation;
    private ApiOperationListWSDTO inquiryOperation;
    private ApiOperationListWSDTO activeOperation;
    private List<ApiCampaignWSDTO> campaigns;

    public ApiDashContentWSDTO() {
    }

    public ApiDashContentWSDTO(ApiOperationListWSDTO manualOperation, ApiOperationListWSDTO inquiryOperation, ApiOperationListWSDTO activeOperation, List<ApiCampaignWSDTO> campaigns) {
        this.manualOperation = manualOperation;
        this.inquiryOperation = inquiryOperation;
        this.activeOperation = activeOperation;
        this.campaigns = campaigns;
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

    public List<ApiCampaignWSDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<ApiCampaignWSDTO> campaigns) {
        this.campaigns = campaigns;
    }
}
