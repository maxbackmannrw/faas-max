package com.faas.core.base.model.ws.campaign.details.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.inquiry.dto.CampaignInquiryWSDTO;


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
