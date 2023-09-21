package com.faas.core.base.model.ws.campaign.details.client.inquiry;

import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class CampaignInquirySessionWSModel {

    private GeneralWSModel general;
    private CampaignInquirySessionWSDTO campaignInquiry;

    public CampaignInquirySessionWSModel() {
    }

    public CampaignInquirySessionWSModel(GeneralWSModel general, CampaignInquirySessionWSDTO campaignInquiry) {
        this.general = general;
        this.campaignInquiry = campaignInquiry;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignInquirySessionWSDTO getCampaignInquiry() {
        return campaignInquiry;
    }

    public void setCampaignInquiry(CampaignInquirySessionWSDTO campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }
}
