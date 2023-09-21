package com.faas.core.base.model.ws.campaign.details.client.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionRequestDTO;

import java.util.List;

public class CampaignInquirySessionRequest {

    private List<CampaignInquirySessionRequestDTO>inquiryRequests;

    public CampaignInquirySessionRequest() {
    }

    public CampaignInquirySessionRequest(List<CampaignInquirySessionRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }

    public List<CampaignInquirySessionRequestDTO> getInquiryRequests() {
        return inquiryRequests;
    }

    public void setInquiryRequests(List<CampaignInquirySessionRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }
}
