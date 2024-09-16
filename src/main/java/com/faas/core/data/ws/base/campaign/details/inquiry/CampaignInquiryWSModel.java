package com.faas.core.data.ws.base.campaign.details.inquiry;

import com.faas.core.data.ws.base.campaign.details.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


public class CampaignInquiryWSModel {

    private GeneralWSModel general;
    private CampaignInquiryWSDTO campaignInquiry;

    public CampaignInquiryWSModel() {
    }

    public CampaignInquiryWSModel(GeneralWSModel general, CampaignInquiryWSDTO campaignInquiry) {
        this.general = general;
        this.campaignInquiry = campaignInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignInquiryWSDTO getCampaignInquiry() {
        return campaignInquiry;
    }

    public void setCampaignInquiry(CampaignInquiryWSDTO campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }
}
