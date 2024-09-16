package com.faas.core.data.ws.base.campaign.details.channel;

import com.faas.core.data.ws.base.campaign.details.channel.dto.CampaignWappChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class CampaignWappChannelWSModel {

    private GeneralWSModel general;
    private CampaignWappChannelWSDTO campaignWappChannel;

    public CampaignWappChannelWSModel() {
    }

    public CampaignWappChannelWSModel(GeneralWSModel general, CampaignWappChannelWSDTO campaignWappChannel) {
        this.general = general;
        this.campaignWappChannel = campaignWappChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public CampaignWappChannelWSDTO getCampaignWappChannel() {
        return campaignWappChannel;
    }

    public void setCampaignWappChannel(CampaignWappChannelWSDTO campaignWappChannel) {
        this.campaignWappChannel = campaignWappChannel;
    }
}
