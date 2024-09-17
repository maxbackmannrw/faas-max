package com.faas.core.base.model.ws.campaign.details.inquiry.dto;

import com.faas.core.data.db.campaign.content.dao.CampaignInquiryDAO;

public class CampaignInquiryWSDTO {

    private CampaignInquiryDAO campaignInquiry;

    public CampaignInquiryWSDTO() {
    }

    public CampaignInquiryWSDTO(CampaignInquiryDAO campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }

    public CampaignInquiryDAO getCampaignInquiry() {
        return campaignInquiry;
    }

    public void setCampaignInquiry(CampaignInquiryDAO campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }
}
