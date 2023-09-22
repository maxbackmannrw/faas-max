package com.faas.core.base.model.ws.campaign.details.client.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionRequestDTO;

import java.util.List;

public class CampaignInquirySessionRequest {

    private List<CampaignInquirySessionRequestDTO>sessionRequests;

    public CampaignInquirySessionRequest() {
    }

    public CampaignInquirySessionRequest(List<CampaignInquirySessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }

    public List<CampaignInquirySessionRequestDTO> getSessionRequests() {
        return sessionRequests;
    }

    public void setSessionRequests(List<CampaignInquirySessionRequestDTO> sessionRequests) {
        this.sessionRequests = sessionRequests;
    }
}
