package com.faas.core.base.model.ws.campaign.details.client.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryClientRequestDTO;

import java.util.List;

public class CampaignInquiryClientRequest {

    private List<CampaignInquiryClientRequestDTO>inquiryRequests;

    public CampaignInquiryClientRequest() {
    }

    public CampaignInquiryClientRequest(List<CampaignInquiryClientRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }

    public List<CampaignInquiryClientRequestDTO> getInquiryRequests() {
        return inquiryRequests;
    }

    public void setInquiryRequests(List<CampaignInquiryClientRequestDTO> inquiryRequests) {
        this.inquiryRequests = inquiryRequests;
    }
}
