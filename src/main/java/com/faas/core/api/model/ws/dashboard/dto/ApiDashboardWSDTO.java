package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.api.model.ws.session.content.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiInquiryWSDTO readyInquiry;
    private ApiSessionWSDTO activeSession;
    private List<ApiCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiSessionWSDTO readySession, ApiInquiryWSDTO readyInquiry, ApiSessionWSDTO activeSession, List<ApiCampaignWSDTO> dashCampaigns) {
        this.readySession = readySession;
        this.readyInquiry = readyInquiry;
        this.activeSession = activeSession;
        this.dashCampaigns = dashCampaigns;
    }

    public ApiSessionWSDTO getReadySession() {
        return readySession;
    }

    public void setReadySession(ApiSessionWSDTO readySession) {
        this.readySession = readySession;
    }

    public ApiInquiryWSDTO getReadyInquiry() {
        return readyInquiry;
    }

    public void setReadyInquiry(ApiInquiryWSDTO readyInquiry) {
        this.readyInquiry = readyInquiry;
    }

    public ApiSessionWSDTO getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(ApiSessionWSDTO activeSession) {
        this.activeSession = activeSession;
    }

    public List<ApiCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
