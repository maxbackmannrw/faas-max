package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiClientInquiryWSDTO;
import com.faas.core.api.model.ws.session.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;
    private ApiClientInquiryWSDTO clientInquiry;
    private List<ApiCampaignWSDTO> dashCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession, ApiClientInquiryWSDTO clientInquiry, List<ApiCampaignWSDTO> dashCampaigns) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.clientInquiry = clientInquiry;
        this.dashCampaigns = dashCampaigns;
    }

    public ApiSessionWSDTO getReadySession() {
        return readySession;
    }

    public void setReadySession(ApiSessionWSDTO readySession) {
        this.readySession = readySession;
    }

    public ApiSessionWSDTO getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(ApiSessionWSDTO activeSession) {
        this.activeSession = activeSession;
    }

    public ApiClientInquiryWSDTO getClientInquiry() {
        return clientInquiry;
    }

    public void setClientInquiry(ApiClientInquiryWSDTO clientInquiry) {
        this.clientInquiry = clientInquiry;
    }

    public List<ApiCampaignWSDTO> getDashCampaigns() {
        return dashCampaigns;
    }

    public void setDashCampaigns(List<ApiCampaignWSDTO> dashCampaigns) {
        this.dashCampaigns = dashCampaigns;
    }
}
