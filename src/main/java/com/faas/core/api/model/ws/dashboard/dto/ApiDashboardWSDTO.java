package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiClientInquiryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationSessionWSDTO;
import com.faas.core.api.model.ws.session.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiOperationSessionWSDTO readyOperation;
    private ApiOperationSessionWSDTO inquiryOperation;
    private ApiOperationSessionWSDTO activeOperation;
    private List<ApiCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiOperationSessionWSDTO readyOperation, ApiOperationSessionWSDTO inquiryOperation, ApiOperationSessionWSDTO activeOperation, List<ApiCampaignWSDTO> dashCampaigns) {
        this.readyOperation = readyOperation;
        this.inquiryOperation = inquiryOperation;
        this.activeOperation = activeOperation;
        this.dashCampaigns = dashCampaigns;
    }

    public ApiOperationSessionWSDTO getReadyOperation() {
        return readyOperation;
    }

    public void setReadyOperation(ApiOperationSessionWSDTO readyOperation) {
        this.readyOperation = readyOperation;
    }

    public ApiOperationSessionWSDTO getInquiryOperation() {
        return inquiryOperation;
    }

    public void setInquiryOperation(ApiOperationSessionWSDTO inquiryOperation) {
        this.inquiryOperation = inquiryOperation;
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
