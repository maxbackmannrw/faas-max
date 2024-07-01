package com.faas.core.base.model.ws.campaign.details.temp.details.dto;

import com.faas.core.base.model.db.campaign.details.temp.WappMessageTempDBModel;

public class CampaignWappMessageTempWSDTO {

    private WappMessageTempDBModel campaignWappMessageTemp;

    public CampaignWappMessageTempWSDTO() {
    }

    public CampaignWappMessageTempWSDTO(WappMessageTempDBModel campaignWappMessageTemp) {
        this.campaignWappMessageTemp = campaignWappMessageTemp;
    }

    public WappMessageTempDBModel getCampaignWappMessageTemp() {
        return campaignWappMessageTemp;
    }

    public void setCampaignWappMessageTemp(WappMessageTempDBModel campaignWappMessageTemp) {
        this.campaignWappMessageTemp = campaignWappMessageTemp;
    }
}
