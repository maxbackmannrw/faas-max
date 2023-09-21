package com.faas.core.base.model.ws.campaign.details.client.manual;

import com.faas.core.base.model.ws.campaign.details.client.manual.dto.CampaignManualSessionRequestDTO;

import java.util.List;

public class CampaignManualSessionRequest {

    private List<CampaignManualSessionRequestDTO>sessionRequests;

    public CampaignManualSessionRequest() {
    }

    public CampaignManualSessionRequest(List<CampaignManualSessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }

    public List<CampaignManualSessionRequestDTO> getSessionRequests() {
        return sessionRequests;
    }

    public void setSessionRequests(List<CampaignManualSessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }
}
