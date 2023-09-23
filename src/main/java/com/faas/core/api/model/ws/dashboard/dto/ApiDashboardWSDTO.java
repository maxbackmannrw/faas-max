package com.faas.core.api.model.ws.dashboard.dto;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.client.inquiry.dto.ApiClientInquiryWSDTO;
import com.faas.core.api.model.ws.client.session.dto.ApiSessionWSDTO;

import java.util.List;

public class ApiDashboardWSDTO {

    private ApiSessionWSDTO readySession;
    private ApiSessionWSDTO activeSession;
    private ApiClientInquiryWSDTO clientInquiry;
    private List<ApiCampaignWSDTO> agentCampaigns;

    public ApiDashboardWSDTO() {
    }

    public ApiDashboardWSDTO(ApiSessionWSDTO readySession, ApiSessionWSDTO activeSession, ApiClientInquiryWSDTO clientInquiry, List<ApiCampaignWSDTO> agentCampaigns) {
        this.readySession = readySession;
        this.activeSession = activeSession;
        this.clientInquiry = clientInquiry;
        this.agentCampaigns = agentCampaigns;
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

    public List<ApiCampaignWSDTO> getAgentCampaigns() {
        return agentCampaigns;
    }

    public void setAgentCampaigns(List<ApiCampaignWSDTO> agentCampaigns) {
        this.agentCampaigns = agentCampaigns;
    }
}
